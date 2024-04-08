package com.lab.sea.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lab.sea.dto.DeviceDto;
import com.lab.sea.entity.Device;
import com.lab.sea.mapper.DeviceMapper;
import com.lab.sea.service.IDeviceService;
import com.lab.sea.util.SseEmitterUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {

    @Override
    public String saveDeviceData(Device device) {
        saveOrUpdate(device);
        pushDeviceData();
        return "success";
    }

    @Override
    public void pushDeviceData() {
        int count = (int) count();
        QueryWrapper<Device> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("device_status", "online");
        int online = (int) count(queryWrapper);
        queryWrapper.eq("device_status", "warning");
        int warning = (int) count(queryWrapper);
        SseEmitterUtil.batchSendMessage(new DeviceDto(count, online, warning));
    }
}

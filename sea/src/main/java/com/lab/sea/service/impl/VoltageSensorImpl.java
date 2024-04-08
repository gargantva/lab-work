package com.lab.sea.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lab.sea.dto.VoltageDto;
import com.lab.sea.entity.VoltageSensor;
import com.lab.sea.mapper.VoltageSensorMapper;
import com.lab.sea.service.IVoltageSensorService;
import com.lab.sea.util.SseEmitterUtil;
import org.springframework.stereotype.Service;

@Service
public class VoltageSensorImpl extends ServiceImpl<VoltageSensorMapper, VoltageSensor> implements IVoltageSensorService {
    public String pushData(VoltageSensor voltageSensor) {
        save(voltageSensor);
        SseEmitterUtil.batchSendMessage(new VoltageDto(voltageSensor));
        return "success";
    }
}

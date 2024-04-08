package com.lab.sea.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lab.sea.entity.Device;

import java.util.List;

public interface IDeviceService extends IService<Device> {
    public String saveDeviceData(Device device);

    public void pushDeviceData();
}

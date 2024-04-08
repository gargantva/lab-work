package com.lab.sea.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lab.sea.entity.TemperatureSensor;

public interface ITemperatureSensorService extends IService<TemperatureSensor> {
    public String pushData(TemperatureSensor temperatureSensor);
}

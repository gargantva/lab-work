package com.lab.sea.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lab.sea.entity.VoltageSensor;

public interface IVoltageSensorService extends IService<VoltageSensor> {
    public String pushData(VoltageSensor voltageSensor);
}

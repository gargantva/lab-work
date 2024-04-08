package com.lab.sea.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lab.sea.dto.TemDto;
import com.lab.sea.entity.TemperatureSensor;
import com.lab.sea.mapper.TemperatureSensorMapper;
import com.lab.sea.service.ITemperatureSensorService;
import com.lab.sea.util.SseEmitterUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TemperatureSensorImpl extends ServiceImpl<TemperatureSensorMapper, TemperatureSensor> implements ITemperatureSensorService {


    public String pushData(TemperatureSensor temperatureSensor) {
        save(temperatureSensor);
        SseEmitterUtil.batchSendMessage(new TemDto(temperatureSensor));
        log.info("success");
        return "success";
    }
}

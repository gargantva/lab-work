package com.lab.sea.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@TableName("temperature_sensor")
public class TemperatureSensor {
    @TableId(type = IdType.AUTO)
    private int id;
    private String deviceId;
    private double temperature;
    private double humidity;
    private Timestamp time;
}

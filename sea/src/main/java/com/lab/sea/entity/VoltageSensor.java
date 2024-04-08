package com.lab.sea.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@TableName("voltage_sensor")
public class VoltageSensor {
    @TableId(type = IdType.AUTO)
    private int id;
    private String deviceId;
    private double camera;
    private double sensor1;
    private double sensor2;
    private double reserved;
    private double multiple;
    private Timestamp time;
}

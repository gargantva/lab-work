package com.lab.sea.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

@Setter
@Getter
public class Device {
    @TableId
    private String deviceId;
    private String deviceStatus;
    private Timestamp time;
}

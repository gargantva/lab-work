package com.lab.sea.dto;

import com.lab.sea.entity.VoltageSensor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class VoltageDto {
    private double camera;
    private double sensor1;
    private double sensor2;
    private double reserved;
    private double multiple;

    public VoltageDto(VoltageSensor voltageSensor){
        this.camera = voltageSensor.getCamera();
        this.sensor1 = voltageSensor.getSensor1();
        this.sensor2 = voltageSensor.getSensor2();
        this.reserved = voltageSensor.getReserved();
        this.multiple = voltageSensor.getMultiple();
    }
}

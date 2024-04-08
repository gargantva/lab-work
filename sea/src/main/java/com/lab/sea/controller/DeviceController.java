package com.lab.sea.controller;

import com.lab.sea.entity.Device;
import com.lab.sea.service.IDeviceService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Resource
    private IDeviceService deviceService;

    @PostMapping
    public String deviceStatus(@RequestBody Device device){
        return deviceService.saveDeviceData(device);
    }

    @GetMapping
    public void getDeviceStatus() {
        deviceService.pushDeviceData();
    }
}

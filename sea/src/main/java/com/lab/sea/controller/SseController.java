package com.lab.sea.controller;

import com.lab.sea.util.SseEmitterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/sse")
public class SseController {

    @GetMapping("/connect")
    public SseEmitter sse(@RequestParam(name = "name") String name) {
        String userId = name + new Date().getTime();
        return SseEmitterUtil.connect(userId);
    }
}

package com.comparison.consumer.controller;

import com.comparison.dto.CustomerRequestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @PostMapping("/nothing")
    public ResponseEntity<Void> testNothing(@RequestBody CustomerRequestDTO input) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/simple-log")
    public ResponseEntity<Void> testSimpleLog(@RequestBody CustomerRequestDTO input) {
        log.debug("testSimpleLog:{}", input);
        return ResponseEntity.ok().build();
    }
}

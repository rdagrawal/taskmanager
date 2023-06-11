package com.rdagrawal.taskmanager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hell")
    String Hello(){
        return "Hi";
    }
}

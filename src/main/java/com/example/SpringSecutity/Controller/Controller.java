package com.example.SpringSecutity.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello World");
    }
    @GetMapping("/goobye")
    public ResponseEntity<String> goodbye(){
        return ResponseEntity.ok("Good Bye");
    }
}

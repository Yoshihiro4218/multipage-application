package com.kadowork.multipageapp.controller;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/public")
@AllArgsConstructor
@Slf4j
public class PublicController {

    @GetMapping("")
    public String index() {
        return "public";
    }
}

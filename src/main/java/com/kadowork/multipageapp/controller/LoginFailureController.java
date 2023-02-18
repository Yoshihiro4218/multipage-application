package com.kadowork.multipageapp.controller;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth-error")
@AllArgsConstructor
@Slf4j
public class LoginFailureController {

    @GetMapping("")
    public String index() {
        // 認証失敗なので、keycloak のログアウトを叩かないと home にいけてしまう。
        return "loginFailure";
    }
}

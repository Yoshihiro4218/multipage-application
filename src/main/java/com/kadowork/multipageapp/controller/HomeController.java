package com.kadowork.multipageapp.controller;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.security.core.annotation.*;
import org.springframework.security.oauth2.core.oidc.user.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
@AllArgsConstructor
@Slf4j
public class HomeController {

    @GetMapping("")
    public String index(@AuthenticationPrincipal OidcUser oidcUser,
                        Model model) {
        log.info("Claim: {}", oidcUser.getUserInfo().getClaims());

        model.addAttribute("username", oidcUser.getUserInfo().getClaims().get("preferred_username"));
        model.addAttribute("email", oidcUser.getUserInfo().getClaims().get("email"));
        model.addAttribute("sub", oidcUser.getUserInfo().getClaims().get("sub"));
        return "home";
    }
}

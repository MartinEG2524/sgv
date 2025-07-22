package com.garritas.sgv.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/inicio")
    public String showInicio() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
            return "redirect:/login";
        }
        return "inicio";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/acceso-denegado")
    public String errorPage() {
        return "acceso-denegado";
    }
}

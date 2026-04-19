package com.Fotocopiadoras.Fotocopiadoras.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Fotocopiadoras.Fotocopiadoras.Service.RolService;

@Controller
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/roles")
    public String listarRoles(Model model) {
        model.addAttribute("roles", rolService.listar());
        return "roles";
    }
}
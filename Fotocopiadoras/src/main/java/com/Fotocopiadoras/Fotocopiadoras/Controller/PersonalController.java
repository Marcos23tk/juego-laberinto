package com.Fotocopiadoras.Fotocopiadoras.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Fotocopiadoras.Fotocopiadoras.Service.PersonalService;

@Controller
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    @GetMapping("/personal")
    public String listarPersonal(Model model) {
        model.addAttribute("personales", personalService.listar());
        return "personal";
    }
}
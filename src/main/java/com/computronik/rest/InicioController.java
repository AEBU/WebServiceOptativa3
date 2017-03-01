package com.computronik.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Alexis on 09/01/2017.
 */

@Controller
public class InicioController {

    @RequestMapping("/")
    public String getIndexPage(){
        return "UserManagment";
    }
}

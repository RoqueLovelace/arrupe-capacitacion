package com.chris.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.chris.curso.springboot.webapp.springboot_web.models.User;


@Controller // es una clase controladora
public class UserController {
  
  @GetMapping("/details")
  public String details( Model model) {
    User user = new User("Chris", "Cortez");

    user.setEmail("chris.cortez@gmail.com");
    model.addAttribute("title", "Hola Mundo, this is Spring Boot");
    model.addAttribute("user", user);
    
    // con Map<String,Object> model
    // model.put("title", "Hola Mundo, this is Spring Boot");
    // model.put("name", "Chris");
    // model.put("lastname", "Cortez");
    

    return "details"; // es una vista
  }

  @GetMapping("/list")
  public String list(ModelMap model) {
    model.addAttribute("title", "Listado de usuarios");
    return "list";
  }

  @ModelAttribute("users")
  public List<User> usersModel(){
    List<User> users = Arrays.asList(
      new User("Dewey", "NoLastName"), 
      new User("Malcolm", "NoLastName","malcolm@inthemiddle.com"), 
      new User("Reese", "NoLastName"));
    return users;
  }
  
}

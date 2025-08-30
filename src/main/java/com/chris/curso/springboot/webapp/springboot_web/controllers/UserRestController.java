package com.chris.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chris.curso.springboot.webapp.springboot_web.models.User;
import com.chris.curso.springboot.webapp.springboot_web.models.dto.UserDto;
import org.springframework.web.bind.annotation.RequestParam;


@RestController // es una clase controladora rest
@RequestMapping("/api") // una ruta base, o de primer nivel
// RequestMapping es para mapear un request a un URL, por defecto GET, por lo que es sustituible por GetMapping 
public class UserRestController {
  
  @GetMapping("/details") // ruta secundaria
  // @RequestMapping(path="/details", method = RequestMethod.GET)
  // @ResponseBody
  public UserDto details() {
    UserDto userDto = new UserDto();
    User user = new User("Chris", "Cortez");
    userDto.setUser(user);
    userDto.setTitle("This is Spring But");

    return userDto; // es una vista 
  }

  // @GetMapping("/details") // ruta secundaria
  // // @RequestMapping(path="/details", method = RequestMethod.GET)
  // // @ResponseBody
  // public Map<String, Object> details() {
  //   User user = new User("Chris", "Cortez");
  //   Map<String, Object> body = new HashMap<>();

  //   body.put("title", "Hola Mundo, this is Spring Boot");
  //   body.put("user", user);
  //   return body; // es una vista 
  // }

  @GetMapping("/list")
  public List<User> list() {
    User user1 = new User("Out", "lander");
    User user2 = new User("Dark", "Priest");
    User user3 = new User("Ca", "hara");
    
    List<User> users = Arrays.asList(user1,user2,user3); // Helpers arrays, es estatico
    // List<User> users = new ArrayList<>();
    // users.add(user1);
    // users.add(user2);
    // users.add(user3);

    return users;
  }
}

package com.chris.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.curso.springboot.webapp.springboot_web.models.User;
import com.chris.curso.springboot.webapp.springboot_web.models.dto.ParamDTO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/api/var")
public class PattVariableController {
  
  @Value("${config.username}")
  private String username;
  
  @Value("${config.listOfValues}")
  private String[]  listOfValues;
  
  @Value("${config.code}")
  private Integer code;


  @GetMapping("/baz/{message}/{code}")
  public ParamDTO baz(@PathVariable(name = "message") String messageT,@PathVariable() String code) {
    ParamDTO param = new ParamDTO();
    param.setMessage(messageT);
    param.setCode(Integer.parseInt(code));
    return param;
  }
 
  @GetMapping("/mix/{product}/{id}")
  public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
    Map<String, Object> json = new HashMap<>();
    json.put("product", product);
    json.put("id", id);
    return json;
  }

  @PostMapping("/create")
  public User create(@RequestBody User user) {
    user.setName(user.getName().toUpperCase());
    return user;
  }
  
  @GetMapping("/values")
  public Map<String, Object> values(@Value("${config.message}") String message) {
    Map<String, Object> map = new HashMap<>();

    map.put("username",username);
    map.put("message",message);
    map.put("code",code);
    map.put("list of values",listOfValues);

    return map;
  }
  
}

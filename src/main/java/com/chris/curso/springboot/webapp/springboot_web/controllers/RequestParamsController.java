package com.chris.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.curso.springboot.webapp.springboot_web.models.dto.ParamDTO;
import com.chris.curso.springboot.webapp.springboot_web.models.dto.ParamMixDTO;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

  @GetMapping("/foo")
  public ParamDTO foo(@RequestParam(required = false, defaultValue ="No se envio mensaje") String message){
    ParamDTO param = new ParamDTO();

    param.setMessage(message);
    return param;
  }

  @GetMapping("/bar")
  public ParamDTO bar(@RequestParam() String text, @RequestParam Integer code) {

    ParamDTO params = new ParamDTO();

    params.setMessage(text);
    params.setCode(code);
    return params;
  }
  
  @GetMapping("/request")
  public ParamMixDTO request(HttpServletRequest request) {

    ParamMixDTO params = new ParamMixDTO();

    params.setCode(Integer.parseInt(request.getParameter("code")));
    params.setMessage(request.getParameter("message"));
    return params;
  }
  
  
}

package net.re.springdatajpa.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String index( HttpServletRequest request){
        return "hello world " + request.getSession().getId();
    }

    @GetMapping("/csrf-token")
    @ResponseBody
    public CsrfToken getCsrfToken( HttpServletRequest request ){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}

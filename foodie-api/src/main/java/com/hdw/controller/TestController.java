package com.hdw.controller;


import com.hdw.pojo.Testtb;
import com.hdw.service.TesttbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TesttbService testtbService;

    @GetMapping("/hello")
    public String test(){
        return "test,hello world";
    }

    @GetMapping("/gettesttb")
    public Testtb getTesttb(int id){
        return testtbService.getTesttbById(id);
    }

    @PostMapping("savetesttb")
    public String saveTesttb(Testtb testtb){
        Testtb testtb1 = new Testtb();
        testtb1.setUserName(testtb.getUserName());
        testtb1.setEmail(testtb.getEmail());
        testtbService.saveTesttb(testtb1);
        return "Success";
    }
}

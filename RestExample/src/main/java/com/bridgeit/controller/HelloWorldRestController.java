package com.bridgeit.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgeit.model.Message;

@RestController
public class HelloWorldRestController {
 
    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to RestTemplate Example.";
    }
    
    @RequestMapping("/hello/{player}")
    @ResponseBody
    public Message message(@PathVariable String player) {
    	//REST Endpoint.
 
        Message msg = new Message(player, "Hello " + player);
        return msg;
    }
}
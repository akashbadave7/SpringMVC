package com.bridgeit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController { 
	@RequestMapping(method = RequestMethod.GET)
   public String printHello(ModelMap model/*,@PathVariable("hello") String name*/) {
      model.addAttribute("message", "Hello Spring MVC Framework!");
      return "hello";
   }
}
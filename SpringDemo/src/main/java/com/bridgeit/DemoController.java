package com.bridgeit;

import java.sql.Date;
import java.text.SimpleDateFormat;


import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.Demo;

@Controller
/*@RequestMapping("/form")*/
public class DemoController {
	
	@InitBinder
	public void InitBinder(WebDataBinder binder)
	{
		binder.setDisallowedFields(new String[] {""});
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		binder.registerCustomEditor(Date.class, "dob",new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "fname",new NameEditor());
	}
	
	@RequestMapping(value="/form",method= RequestMethod.GET)
	public ModelAndView getFrom(){
		ModelAndView model1= new ModelAndView("form");
		
		/*model1.addObject("headerMessage","Welcome to Spring MVC");*/
		return model1;
	}
	
	@ModelAttribute
	public void addingCommonObjext(Model model1)
	{
		model1.addAttribute("headerMessage","Welcome to Spring MVC");
	}
	@RequestMapping(value="/addDetails",method=RequestMethod.POST)
	/*public ModelAndView addDetails(@RequestParam(value="fname",defaultValue="Akash") String fName,@RequestParam("lname") String lName)*/
	public ModelAndView addDetails(@ModelAttribute("demo") Demo demo,BindingResult result)
	{
		if(result.hasErrors()){
			ModelAndView model1=  new ModelAndView("/from");
			return model1;
		}
		
		ModelAndView model1 = new ModelAndView("success");
		
		/*model1.addObject("msg","Details submited by you :: Name: "+fName+" "+lName);*/
		/*model1.addObject("headerMessage","Welcome to Spring MVC");*/
		
		
		return model1;
		
	}
	
}

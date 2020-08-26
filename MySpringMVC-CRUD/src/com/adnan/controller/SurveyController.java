package com.adnan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adnan.entity.Customer;
import com.adnan.entity.Survey;
import com.adnan.service.SurveyService;

@Controller
@RequestMapping("/survey")
public class SurveyController {

	// need to inject our customer service
	@Autowired
	private SurveyService surveyService;
	
	@GetMapping("/list")
	public String lisSurveys(Model theModel) {
		
		// get customers from the service
		List<Survey> theSurvey = surveyService.getSurveys();
				
		// add the customers to the model
		theModel.addAttribute("surveys", theSurvey);
		
		return "list-surveys";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Survey theSurvey = new Survey();
		
		theModel.addAttribute("surveys", theSurvey);
		
		return "survey-form";
	}
	
	@PostMapping("/saveSurvey")
	public String saveCustomer(@ModelAttribute("surveys") Survey theSurvey) {
		
		// save the customer using our service
		surveyService.saveSurvey(theSurvey);	
		
		return "redirect:/survey/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("surveyId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Survey theSurvey = surveyService.getSurvey(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("surveys", theSurvey);
		
		// send over to our form		
		return "survey-form";
	}
	
	@GetMapping("/delete")
	public String deleteSurvey(@RequestParam("surveyId") int theId) {
		
		// delete the customer
		surveyService.deleteSurvey(theId);
		
		return "redirect:/survey/list";
	}
}











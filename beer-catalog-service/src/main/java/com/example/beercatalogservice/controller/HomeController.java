package com.example.beercatalogservice.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	 @GetMapping("/home")
	 @SuppressWarnings("unchecked")
	 public String howdy(Model model, Principal principal) {
		 OAuth2Authentication authentication = (OAuth2Authentication) principal;
		 Map<String, Object> user = (Map<String, Object>) authentication.getUserAuthentication().getDetails();
	     model.addAttribute("user", user);
	     System.out.println(user.toString());
	     return "home";
	    }
}

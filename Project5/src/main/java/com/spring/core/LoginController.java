package com.spring.core;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//http://localhost:8085/spring-mvc/hello
@Controller
public class LoginController {

	@Autowired
	ApplicationContext applicationContext;

	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello() {

		String[] beanNames = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println("---> " + beanName);
		}

		return "Hello Saurabh !";
	}

	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	public String sayHello1() {

		return "login";
	}

	@RequestMapping(value = "/hello1", method = RequestMethod.POST)
	public String sayHello2(@RequestParam String name, @RequestParam String password, ModelMap model) {
		model.put("name1", name);
		model.put("password", password);
		return "hello";
	}


}

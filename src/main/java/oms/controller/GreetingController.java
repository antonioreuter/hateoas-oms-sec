package oms.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import oms.model.Greeting;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("GreetingController")
@RequestMapping("/oms/greetings")
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/hello")
    @ResponseBody
    public Greeting greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
    	
    	System.out.println("\n\n\nTESTE");

        Greeting greeting = new Greeting(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

        return greeting;
    }
}

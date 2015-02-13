package oms.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController("healthcheck")
@RequestMapping("/healthcheck")
public class HealthcheckController {

	@RequestMapping(method=RequestMethod.GET)
	public String healthcheck() {
		return "OK";
	}
	
}

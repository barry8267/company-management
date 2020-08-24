package com.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestApi {

	Logger log = LoggerFactory.getLogger(TestApi.class);

	@RequestMapping(value = "/123", method = RequestMethod.GET)
	public void test() throws Exception {
		log.info("get !!!");
	}

}

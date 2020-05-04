package com.zhangjing.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhangjing.springmvc.model.User;

@Controller
@RequestMapping(value = { "testClass", "testClass01" })
public class TestController {

	@RequestMapping(value = "testMethod")
	public String test() {
		System.out.println("==test===");
		return "test";
	}

	@RequestMapping(value = "testMethod", method = RequestMethod.GET)
	public String test2() {
		System.out.println("=get=test===");
		return "test";
	}

	@RequestMapping(value = "testMethod", method = RequestMethod.POST)
	public String test3() {
		System.out.println("=post=test===");
		return "test";
	}

	@RequestMapping(value = "testMethodParam", params = { "username", "age" }, headers = { "!Accept-Language" })
	public String test4() {
		System.out.println("==test==param=header==");
		return "test";
	}

	/**
	 * testClass/testMethodPath/color/red
	 */

	@RequestMapping(value = "testMethodPath/{v_cata}/{v_color}")
	public String test5(@PathVariable("v_cata") String param1, @PathVariable("v_color") String param2) {
		System.out.println("==test==param=rest==");
		System.out.println(param1);
		System.out.println(param2);
		return "test";
	}

	/**
	 * testClass/testrequestparam?username=1&age=2&sex=f
	 */
	@RequestMapping(value = "testrequestparam")
	public String test6(@RequestParam("username") String p1,
			@RequestParam(value = "age", required = false, defaultValue = "0") int p2,
			@RequestParam(value = "sex", required = false) String p3,
			@RequestHeader(value = "Accept-Language") String acceptlang,
			@CookieValue(value="JSESSIONID") String jsess) {

		System.out.println(p1 + p2 + p3 + acceptlang+jsess);
		return "test";

	}
	
	@RequestMapping("testUser")
	public String testUser(User user) {
		System.out.println(user);
		return "test";
	}
	
	@RequestMapping("testservletapi")
	public void test7(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		System.out.println("req:"+req);
		System.out.println("resp:"+resp);
		
		//req.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(req, resp);
		//resp.sendRedirect("http://www.baidu.com");
		resp.getWriter().print("xxxxxx");
	}
}

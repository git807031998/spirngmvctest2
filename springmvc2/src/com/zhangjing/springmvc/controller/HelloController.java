package com.zhangjing.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	
	/**\
	 * ����ͻ��˵�����http://localhost:8888/springmvc01/hello
	 * RequestMapping:�������
	 */
	@RequestMapping(value="hello")
	public String hello() {
		System.out.println("HelloController...hello...");
		return "hello";
	}
}

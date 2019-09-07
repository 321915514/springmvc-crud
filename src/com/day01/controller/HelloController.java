package com.day01.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.day01.entity.User;
import com.sun.net.httpserver.HttpHandler;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("hello world");
		return "index";
	}
	@RequestMapping("/login")
	public String login(@Valid User user,BindingResult result,Model model) {
		Map<String, Object> map=new HashMap<String, Object>();
		if (result.hasErrors()) {
			System.out.println("有错");
			System.out.println(result.getErrorCount());
			return "redirect:/index.jsp";
		}else {
			System.out.println(user.toString());
			return "index";
		}
		
		
	}
	@ResponseBody
	@RequestMapping("/ajax")
	public User ajax() {
		User user=new User();
		user.setUsername("hello");
		user.setPassword("123");
		user.setBirthday(new Date());
		
		return user;
		
	}
	@RequestMapping("/download")
	public ResponseEntity<Byte[]> download(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ServletContext context=request.getServletContext();
		String path=context.getRealPath("/js/jquery-1.12.4.js");
		FileInputStream inputStream=new FileInputStream(path);
		  response.setHeader("Content-Disposition", "attachment;filename=jquery");
		IOUtils.copy(inputStream,response.getOutputStream());
		return new ResponseEntity<Byte[]>(HttpStatus.OK);
		
		
		
		
	}
	@RequestMapping("/upload")
	public String upload(@RequestParam("photo")MultipartFile file) throws Exception, IOException {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getName());
		file.transferTo(new File("d:/"+file.getOriginalFilename()));
		return "forward:/index.jsp";
	}
	
		
	
}

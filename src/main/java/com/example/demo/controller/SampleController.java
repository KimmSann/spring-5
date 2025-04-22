package com.example.demo.controller;

import java.lang.module.ModuleDescriptor.Builder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dtp.SampleDTO;

//MVC 패턴으로 사이트 만들기

//C: Controller (사용자 요청을 처리하는 컴포넌트)

@Controller
@RequestMapping("/sample")

public class SampleController {
	
	@GetMapping("/ex1")// 전체경로: /sample/ex1
	public void ex1() {
		// 리턴값: view의 결로
		// string -> 파일의 경로를 직접 작성
		// void -> url 경로가 파일의 경로가 됨 (sample 폴더 아래 ex1.html)
		
		
	}
	
	@GetMapping("/ex2")
	public void ex2(Model model) {
		
		model.addAttribute("msg", "반가워요");
		
		
	}
	
	@GetMapping("/ex3")
	public void ex3(Model model) {
		model.addAttribute("msg1", "안녕하세요");
		model.addAttribute("msg2", "반가워요");
	}

	@GetMapping("/ex4")
	public void ex4(Model model) {
		SampleDTO sampleDTO = new SampleDTO(1, "hello", LocalDate.now());
		model.addAttribute("dto", sampleDTO); // 화면에 객체 전달
	}
	@GetMapping({"/ex5", "/ex6", "/ex7", "/ex8"})
	public void ex5(Model model) {
		List<SampleDTO> list = new ArrayList<>();
		list.add(new SampleDTO(1, "aaa", LocalDate.now()));
		list.add(new SampleDTO(2, "bbb", LocalDate.now()));
		list.add(new SampleDTO(3, "ccc", LocalDate.now()));
		model.addAttribute("list", list); // 화면에 리스트 전달
	}
	 @GetMapping("/ex9")
	    public void ex9(Model model){
	    	List<SampleDTO> list = new ArrayList();
	    	for(int i=1; i<=20;i++) {
	    		list.add(new SampleDTO(i, i+"번", LocalDate.now()));
	    	}
	    	model.addAttribute("list", list);
	    }
		@GetMapping("/ex10")
		public void ex10(Model model) {
			SampleDTO sampleDTO = new SampleDTO(1, "aaa", LocalDate.now());
			model.addAttribute("result", "success"); // 화면에 문자열 전달
			model.addAttribute("dto", sampleDTO); // 화면에 객체 전달
		}
		@GetMapping("/ex11")
		public void ex11(Model model) {
			model.addAttribute("date", LocalDateTime.now()); // 화면에 현재시간 전달
		}

}

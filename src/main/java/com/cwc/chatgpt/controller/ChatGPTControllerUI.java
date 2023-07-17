package com.cwc.chatgpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cwc.chatgpt.model.ChatMessagePrompt;
import com.cwc.chatgpt.service.ChatGPTService;

@Controller
public class ChatGPTControllerUI {


	@Autowired
	private ChatGPTService chatGPTService;

	@GetMapping("/chatprompt/{prompt}")
	public String getPrompt(@PathVariable("prompt") String prompt, Model model) {
		String prompts = this.chatGPTService.getPrompt(prompt);
		model.addAttribute("prompt", prompts);
		return "indexs.html";
	}
	
	@GetMapping("/home")
	public String getPage() {
		return "chatgpt";
	}

	@PostMapping("/chat")
	@ResponseBody
	public String getChatMessages(@RequestBody ChatMessagePrompt prompt) {
		
		System.out.println("Request is: ......................."+ prompt);
		String message = this.chatGPTService.getMessage(prompt);
		String response = "GPT generated response: " + message;		
		return message;
	}
}

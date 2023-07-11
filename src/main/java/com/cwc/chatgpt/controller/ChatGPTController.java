package com.cwc.chatgpt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cwc.chatgpt.model.ChatMessagePrompt;
import com.cwc.chatgpt.service.ChatGPTService;

@RestController
@RequestMapping("/api/v1/chatgpt")
public class ChatGPTController {

	@Autowired
	private ChatGPTService chatGPTService;

	@GetMapping("/{prompt}")
	public ResponseEntity<String> getPrompt(@PathVariable("prompt") String prompt) {
		return new ResponseEntity<String>(this.chatGPTService.getPrompt(prompt),HttpStatus.OK);
	}

	@PostMapping("/chat")
	public ResponseEntity<String> getChatMessages(@RequestBody ChatMessagePrompt prompt) {
		String message = this.chatGPTService.getMessage(prompt);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}

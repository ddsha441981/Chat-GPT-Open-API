package com.cwc.chatgpt.service;

import com.cwc.chatgpt.model.ChatMessagePrompt;

public interface ChatGPTService {
	
	public String getPrompt(String prompt);
	public String getMessage(ChatMessagePrompt  chatMessagePrompt);

}

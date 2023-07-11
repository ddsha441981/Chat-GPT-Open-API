package com.cwc.chatgpt.model;

import java.util.List;

import com.theokanning.openai.completion.chat.ChatMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class ChatMessagePrompt {
	
	private List<ChatMessage> chatMessages;

}

package com.cwc.chatgpt.service.impl;

import java.time.Duration;

import org.springframework.stereotype.Service;

import com.cwc.chatgpt.model.ChatMessagePrompt;
import com.cwc.chatgpt.service.ChatGPTService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.service.OpenAiService;

@Service
public class ChatGPTServiceImpl implements ChatGPTService {

	
	private static final String API_KEY = "";
	private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(50);

	@Override
	public String getPrompt(String prompt) {
		/*
		  /v1/completions(Legacy) -> text-davinci-003, text-davinci-002,
		  text-davinci-001, text-curie-001, text-babbage-001, text-ada-001, davinci,
		  curie, babbage, ada
		*/

		OpenAiService openAiService = new OpenAiService(API_KEY, DEFAULT_TIMEOUT);
		CompletionRequest completionRequest = CompletionRequest.builder().prompt(prompt).model("text-davinci-003")
				.echo(true).build();
		// openAiService.createCompletion(completionRequest).getChoices().forEach(System.out::println);
		return openAiService.createCompletion(completionRequest).getChoices().get(0).getText();
	}

	@Override
	public String getMessage(ChatMessagePrompt chatMessagePrompt) {
		/*
		 /v1/chat/completions -> gpt-4, gpt-4-0613, gpt-4-32k, gpt-4-32k-0613,
		 gpt-3.5-turbo, gpt-3.5-turbo-0613, gpt-3.5-turbo-16k, gpt-3.5-turbo-16k-0613
		*/ 

		OpenAiService openAiService = new OpenAiService(API_KEY, DEFAULT_TIMEOUT);
		ChatCompletionRequest completionRequest = ChatCompletionRequest.builder()
				.messages(chatMessagePrompt.getChatMessages()).model("gpt-3.5-turbo-16k").build();
		String content = openAiService.createChatCompletion(completionRequest).getChoices().get(0).getMessage()
				.getContent();

		openAiService.shutdownExecutor();
		return content;

	}

}

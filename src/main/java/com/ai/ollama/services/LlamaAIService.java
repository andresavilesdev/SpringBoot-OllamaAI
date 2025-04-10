package com.ai.ollama.services;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.stereotype.Service;

@Service
public class LlamaAIService {

    private final OllamaChatModel ollamaChatModel;

    public LlamaAIService(OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }

    public String generateResult(String prompt) {
        OllamaOptions options = new OllamaOptions();
        options.setModel("llama2");

        ChatResponse response = ollamaChatModel.call(new Prompt(prompt,options));

        if (response != null) {
            return response.getResult().getOutput().getText();
        }

        return "There is no response received from Ollama API";
    }
}

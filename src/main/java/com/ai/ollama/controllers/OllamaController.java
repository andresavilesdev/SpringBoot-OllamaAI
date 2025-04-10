package com.ai.ollama.controllers;

import com.ai.ollama.services.LlamaAIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OllamaController {

    private final LlamaAIService llamaAIService;

    public OllamaController(LlamaAIService llamaAIService) {
        this.llamaAIService = llamaAIService;
    }
    @GetMapping("/api/v1/generate")
    public String generate(@RequestParam(value = "promptMessage") String promptMessage){
        return llamaAIService.generateResult(promptMessage);
    }
}

package com.example.nutrition_chatbot_backend.controllers;

// ChatController.java
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.ai.chat.client.ChatClient;
import java.util.Map;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @PostMapping("/chat")
    public ResponseEntity<Map<String, String>> chat(@RequestBody Map<String, String> payload) {

        String userMessage = payload.get("message");

        // Call the LLM API here
        String botReply = callLLM(userMessage);

        return ResponseEntity.ok(Map.of("reply", botReply));
    }

    private String callLLM(String message) {
        String response = chatClient.prompt()
            .user(message)
            .call()
            .content();

        return response;
    }
}

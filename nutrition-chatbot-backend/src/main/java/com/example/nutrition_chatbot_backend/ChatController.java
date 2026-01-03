package com.example.nutrition_chatbot_backend;

// ChatController.java
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

@RestController
public class ChatController {

    @PostMapping("/chat")
    public ResponseEntity<Map<String, String>> chat(@RequestBody Map<String, String> payload) {
        String userMessage = payload.get("message");

        // TODO: Call your LLM API here
        String botReply = callLLM(userMessage);

        return ResponseEntity.ok(Map.of("reply", botReply));
    }

    private String callLLM(String message) {
        @Value("${gemini.api-key}")
        private String apiKey;

        GenerateContentResponse response =
            client.models.generateContent(
                "gemini-2.5-flash",
                message,
                null);

            return response.text();
    }
}

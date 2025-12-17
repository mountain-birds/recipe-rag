// ChatController.java
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Map;

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
        // Example: pseudo-code for OpenAI API call
        // HttpRequest request = HttpRequest.newBuilder()
        //   .uri(URI.create("https://api.openai.com/v1/chat/completions"))
        //   .header("Authorization", "Bearer YOUR_API_KEY")
        //   .POST(BodyPublishers.ofString("{...json payload...}"))
        //   .build();
        // HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        // return parseResponse(response.body());

        return "This is a placeholder response for: " + message;
    }
}

// Gemini API example usage
/*package com.example;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class GenerateTextFromTextInput {
  public static void main(String[] args) {
    Client client = Client.builder().apiKey("YOUR_API_KEY").build();

    GenerateContentResponse response =
        client.models.generateContent(
            "gemini-2.5-flash",
            "Explain how AI works in a few words",
            null);

    System.out.println(response.text());
  }
}*/
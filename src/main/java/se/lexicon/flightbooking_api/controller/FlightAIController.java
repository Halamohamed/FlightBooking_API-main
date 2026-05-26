package se.lexicon.flightbooking_api.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.flightbooking_api.service.FlightChatbotAssistant;

@RestController
@RequestMapping("/api/ai/flights-chat")
@RequiredArgsConstructor
public class FlightAIController {
    private final FlightChatbotAssistant flightChatbotAssistant;

    public String chat (@RequestParam @NotBlank(message = "chatId cannot be blank") String chatId,
                        @RequestParam @NotBlank(message = "message cannot be blank") String message) {
        return flightChatbotAssistant.chat(chatId, message);
    }

}

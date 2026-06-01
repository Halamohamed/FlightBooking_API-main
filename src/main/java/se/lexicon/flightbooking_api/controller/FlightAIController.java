package se.lexicon.flightbooking_api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import se.lexicon.flightbooking_api.dto.ChatRequestDTO;
import se.lexicon.flightbooking_api.dto.ChatResponseDTO;
import se.lexicon.flightbooking_api.service.FlightChatbotAssistant;

@RestController
@RequestMapping("/api/flights/ai")
@RequiredArgsConstructor
public class FlightAIController {

    private final FlightChatbotAssistant flightChatbotAssistant;

    @PostMapping("/flights-chat")
    public ChatResponseDTO chat(@Valid @RequestBody ChatRequestDTO request) {
        String answer = flightChatbotAssistant.chat(request.chatId(), request.message());
        return new ChatResponseDTO(answer);
    }

}

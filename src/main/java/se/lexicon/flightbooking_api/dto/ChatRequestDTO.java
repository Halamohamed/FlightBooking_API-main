package se.lexicon.flightbooking_api.dto;

import jakarta.validation.constraints.NotBlank;

public record ChatRequestDTO(
        @NotBlank(message = "chatId cannot be blank")
        String chatId,

        @NotBlank(message = "message cannot be blank")
        String message
) {}

package com.pblgllgs.backendbanksecuritysb2.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        String path,
        String exceptionName,
        String message,
        int status,
        LocalDateTime localDateTime) {
}
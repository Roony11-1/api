package com.api.api_bot.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ApiResponse<T>
{
    private int status;
    private String message;
    private T data;
}

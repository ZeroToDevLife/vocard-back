package com.korit.vocard.common.dto.response.utils;

import org.springframework.http.ResponseEntity;

import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.ResponseType;

import lombok.Getter;

@Getter
public class GetTemporaryPasswordResponseDto extends ResponseDto {
    private String temporaryPassword;

    private GetTemporaryPasswordResponseDto(String temporaryPassword) {
        super(ResponseType.SUCCESS);
        this.temporaryPassword = temporaryPassword;
    }

    public static ResponseEntity<GetTemporaryPasswordResponseDto> success(String temporaryPassword) {
        GetTemporaryPasswordResponseDto result = new GetTemporaryPasswordResponseDto(temporaryPassword);
        return ResponseEntity.ok(result);
    }
} 
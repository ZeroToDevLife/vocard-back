package com.korit.vocard.common.dto.response.utils;

import org.springframework.http.ResponseEntity;

import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.ResponseType;

import lombok.Getter;

@Getter
public class SendTemporaryPasswordEmailResponseDto extends ResponseDto {
    private SendTemporaryPasswordEmailResponseDto() {
        super(ResponseType.SUCCESS);
    }

    public static ResponseEntity<SendTemporaryPasswordEmailResponseDto> success() {
        SendTemporaryPasswordEmailResponseDto result = new SendTemporaryPasswordEmailResponseDto();
        return ResponseEntity.ok(result);
    }
} 
package com.korit.vocard.common.dto.response.utils;

import org.springframework.http.ResponseEntity;

import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.ResponseType;

import lombok.Getter;

@Getter
public class SendVerificationEmailResponseDto extends ResponseDto {
    private SendVerificationEmailResponseDto() {
        super(ResponseType.SUCCESS);
    }

    public static ResponseEntity<SendVerificationEmailResponseDto> success() {
        SendVerificationEmailResponseDto result = new SendVerificationEmailResponseDto();
        return ResponseEntity.ok(result);
    }
} 
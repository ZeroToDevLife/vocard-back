package com.korit.vocard.common.dto.response.utils;

import org.springframework.http.ResponseEntity;

import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.ResponseType;

import lombok.Getter;

@Getter
public class GetRandomNicknameResponseDto extends ResponseDto {
    private String nickname;

    private GetRandomNicknameResponseDto(String nickname) {
        super(ResponseType.SUCCESS);
        this.nickname = nickname;
    }

    public static ResponseEntity<GetRandomNicknameResponseDto> success(String nickname) {
        GetRandomNicknameResponseDto result = new GetRandomNicknameResponseDto(nickname);
        return ResponseEntity.ok(result);
    }
} 
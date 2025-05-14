package com.korit.vocard.common.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.ResponseType;
import com.korit.vocard.common.entity.UserEntity;

import lombok.Getter;

@Getter
public class GetSignInUserResponseDto extends ResponseDto {
  private String email;
  private String nickname;
  private boolean isVerified;

  private GetSignInUserResponseDto(UserEntity userEntity) {
    super(ResponseType.SUCCESS);
    this.email = userEntity.getEmail();
    this.nickname = userEntity.getNickname();
    this.isVerified = userEntity.isVerified();
  }

  public static ResponseEntity<GetSignInUserResponseDto> success (UserEntity userEntity) {
    GetSignInUserResponseDto body = new GetSignInUserResponseDto(userEntity);
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }
  
}

package com.korit.vocard.service;

import org.springframework.http.ResponseEntity;

import com.korit.vocard.common.dto.request.user.ChangePasswordRequestDto;
import com.korit.vocard.common.dto.request.user.PatchUserRequestDto;
import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.user.GetSignInUserResponseDto;

public interface UserService {
  ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
  ResponseEntity<ResponseDto> patchUser(PatchUserRequestDto dto, String email);
  ResponseEntity<ResponseDto> deleteUser(String email);
  ResponseEntity<ResponseDto> changePassword(ChangePasswordRequestDto dto, String email);
}

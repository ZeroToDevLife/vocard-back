package com.korit.vocard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korit.vocard.common.dto.request.user.PatchUserRequestDto;
import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.user.GetSignInUserResponseDto;
import com.korit.vocard.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user") 
//->http://localhost:3000/api/v1/user

@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/me")
  public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(
    @AuthenticationPrincipal String email
  ) {
    ResponseEntity<? super GetSignInUserResponseDto> response = userService.getSignInUser(email);
    return response;
  }

  @PatchMapping("/change-nickname")
  public ResponseEntity<ResponseDto> patchUser(
    @RequestBody @Valid PatchUserRequestDto requestBody,
    @AuthenticationPrincipal String email    
  ) {
    ResponseEntity<ResponseDto> response = userService.patchUser(requestBody, email);
    return response;
  }

  @DeleteMapping({"", "/"})
  public ResponseEntity<ResponseDto> deleteUser(
    @AuthenticationPrincipal String email
  ) {
    ResponseEntity<ResponseDto> response = userService.deleteUser(email);
    return response;
  }

}

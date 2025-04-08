package com.korit.vocard.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.vocard.common.dto.request.user.PatchUserRequestDto;
import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.user.GetSignInUserResponseDto;
import com.korit.vocard.common.entity.UserEntity;
import com.korit.vocard.repository.UserRepository;
import com.korit.vocard.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

  private final UserRepository userRepository;

  @Override
  public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email) {
    
    UserEntity userEntity = null;

    try {

      userEntity = userRepository.findByEmail(email);
      
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetSignInUserResponseDto.success(userEntity);

  }

  @Override
  public ResponseEntity<ResponseDto> patchUser(PatchUserRequestDto dto, String email) {

    try {

      UserEntity userEntity = userRepository.findByEmail(email);
      userEntity.patch(dto);
      userRepository.save(userEntity);
      
    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.OK);

  }
  
}

package com.korit.vocard.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.korit.vocard.common.dto.request.user.ChangePasswordRequestDto;
import com.korit.vocard.common.dto.request.user.PatchUserRequestDto;
import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.user.GetSignInUserResponseDto;
import com.korit.vocard.common.entity.UserEntity;
import com.korit.vocard.repository.UserRepository;
import com.korit.vocard.service.UserService;

@Service
public class UserServiceImplement implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserServiceImplement(UserRepository userRepository) {
    this.userRepository = userRepository;
    this.passwordEncoder = new BCryptPasswordEncoder();
  }

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

  @Override
  public ResponseEntity<ResponseDto> deleteUser(String email) {
    
    try {
      UserEntity userEntity = userRepository.findByEmail(email);
      if (userEntity == null) {
        return ResponseDto.userNotExist();
      }
      userRepository.delete(userEntity);
    } catch(Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<ResponseDto> changePassword(ChangePasswordRequestDto dto, String email) {
    try {
      UserEntity userEntity = userRepository.findByEmail(email);
      if (userEntity == null) {
        return ResponseDto.userNotExist();
      }

      if (!passwordEncoder.matches(dto.getCurrentPassword(), userEntity.getPassword())) {
        System.out.println("현재 비밀번호 불일치: " + email);
        return ResponseDto.validationFail();
      }

      if (!dto.getNewPassword().equals(dto.getConfirmNewPassword())) {
        System.out.println("새 비밀번호, 확인 비밀번호 불일치: " + email);
        return ResponseDto.validationFail();
      }

      String encodedNewPassword = passwordEncoder.encode(dto.getNewPassword());
      userEntity.setPassword(encodedNewPassword);
      userRepository.save(userEntity);

    } catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.OK);
  }
  
}

package com.korit.vocard.common.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequestDto {

    @NotBlank
    private String currentPassword;

    @NotBlank
    @Pattern(regexp = "^(?=[a-zA-Z])(?=.*\\d)[a-zA-Z\\d!@#$%^&*]{8,20}$", 
             message = "비밀번호는 영문자로 시작해야 하며, 영문자와 숫자를 포함하여 8~20자여야 합니다. 특수문자(!@#$%^&*)도 사용할 수 있습니다.")
    private String newPassword;

    @NotBlank
    private String confirmNewPassword;
} 
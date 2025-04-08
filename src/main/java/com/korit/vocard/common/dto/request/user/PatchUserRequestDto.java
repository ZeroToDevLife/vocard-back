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
public class PatchUserRequestDto {

  @NotBlank
  @Pattern(regexp = "^[a-zA-Z][a-zA-Z\\d]{2,19}$")
  private String nickname;
}

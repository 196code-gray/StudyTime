package com.samkim.member.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class MemberPostDto {
    @NotBlank
    private String name;
    @NotBlank
    @Pattern(regexp = "^010-\\d{3,4}-\\d{3,4}$")
    private String phone;
    @NotBlank
    @Email
    private String email;
    @Pattern(regexp = "^\\d{2,3}$")
    @Range(min=50, max=250)
    private int height;
}

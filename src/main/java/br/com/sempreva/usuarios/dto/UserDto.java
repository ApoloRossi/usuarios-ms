package br.com.sempreva.usuarios.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    private int age;

}

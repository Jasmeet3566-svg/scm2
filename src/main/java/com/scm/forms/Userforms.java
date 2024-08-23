package com.scm.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Userforms {

    @NotBlank(message = "username is required")
    @Size(min = 3,message = "Minimun three characters required")
    private String name;
    @Email(message = "Invalid email required")
    private String email;
    @Size(min = 6,message = "Minimun six characters required")
    private String password;
    @NotBlank(message = "About is required")
    private String about;
    @Size(min = 8,max = 12,message = "Invalid phone number")
    private String phoneNumber;


}

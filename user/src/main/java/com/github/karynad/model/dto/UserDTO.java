package com.github.karynad.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    private String username;

    // @JsonIgnore todo
    private transient String rawPassword;
}

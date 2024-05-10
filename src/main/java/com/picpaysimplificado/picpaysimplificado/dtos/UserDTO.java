package com.picpaysimplificado.picpaysimplificado.dtos;

import java.math.BigDecimal;
import com.picpaysimplificado.picpaysimplificado.domain.user.UserType;

public record UserDTO(String firstname, String lastname, String document, BigDecimal balance, String email,
        String password, UserType userType) {

}

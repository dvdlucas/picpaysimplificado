package com.picpaysimplificado.picpaysimplificado;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import java.math.BigDecimal;
import org.springframework.http.MediaType;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.picpaysimplificado.picpaysimplificado.controllers.UserController;
import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.picpaysimplificado.dtos.UserDTO;
import com.picpaysimplificado.picpaysimplificado.services.UserService;

@WebMvcTest(UserController.class)
public class UserTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void testeCreateUser() throws Exception {
        UserDTO userDTO = new UserDTO("John", "Doe", "123456789", BigDecimal.valueOf(100.00), "john@example.com",
                "senha123", UserType.COMMON);

        User user = new User();
        user.setId(1L);
        user.setLastName("testuser");
        user.setEmail("test@example.com");

        when(userService.createUser(any(UserDTO.class))).thenReturn(user);

        ResultActions result = mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON) // Passando uma instância de MediaType
                .content(objectMapper.writeValueAsString(userDTO)));

        result.andExpect(status().isCreated());

        verify(userService, times(1)).createUser(any(UserDTO.class));
    }

}

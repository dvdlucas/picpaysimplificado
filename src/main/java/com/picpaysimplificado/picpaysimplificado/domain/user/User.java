package com.picpaysimplificado.picpaysimplificado.domain.user;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.picpaysimplificado.picpaysimplificado.dtos.UserDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO data) {
        this.firstName = data.firstname();
        this.lastName = data.lastname();
        this.balance = data.balance();
        this.email = data.email();
        this.password = data.password();
        this.document = data.document();
        this.userType = data.userType();
    }

    public void setFirstName(String firstName) {
        validateNonNull(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateNonNull(lastName);
        this.lastName = lastName;
    }

    public void setDocument(String document) {
        validateNonNull(document);
        this.document = document;
    }

    public void setEmail(String email) {
        validateNonNull(email);
        this.email = email;
    }

    public void setPassword(String password) {
        validateNonNull(password);
        this.password = password;
    }

    public void setBalance(BigDecimal balance) {
        validateNonNull(balance);
        this.balance = balance;
    }

    public void setUserType(UserType userType) {
        validateNonNull(userType);
        this.userType = userType;
    }

    private void validateNonNull(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
    }
}

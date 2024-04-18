package com.picpaysimplificado.picpaysimplificado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpaysimplificado.picpaysimplificado.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Optional
    <User> void findUserByDocument(String document);

    @Optional
    <User> void findUserById(Long Id);
}

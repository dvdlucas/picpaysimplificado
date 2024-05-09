package com.picpaysimplificado.picpaysimplificado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpaysimplificado.picpaysimplificado.domain.Transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

package org.jpa.hibernate.repository;

import org.jpa.hibernate.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
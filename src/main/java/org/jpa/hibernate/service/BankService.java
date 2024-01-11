package org.jpa.hibernate.service;

import org.jpa.hibernate.entities.Bank;
import org.jpa.hibernate.repository.BankRepository;
import org.springframework.stereotype.Service;

@Service
public record BankService(BankRepository bankRepository) {
    public void saveBank(Bank bank) {
        bankRepository.save(bank);
    }

    public Bank getBank(Long id) {
        return bankRepository.findById(id).orElse(null);
    }
}
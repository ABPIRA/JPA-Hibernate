package org.jpa.hibernate.controller;

import org.jpa.hibernate.entities.Bank;
import org.jpa.hibernate.service.BankService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public record BankController(BankService bankService) {

    @PostMapping("/bank")
    public void saveBank(@RequestBody Bank bank) {
        bankService.saveBank(bank);
    }

    @GetMapping("/bank")
    public Bank getBank(@RequestParam Long id) {
        return bankService.getBank(id);
    }
}
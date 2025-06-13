package com.wb.pgcryptotest;

import java.util.Collection;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeEndpoint {

    private final EmployeeRepository employeeRepository;

    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @GetMapping("/encrypted-pesel")
    public Collection<String> getAllEncryptedPeselNumbers() {
        return employeeRepository.getAllEncryptedPeselNumbers();
    }

    @GetMapping("/decrypted-pesel")
    public Collection<String> getAllDecryptedPeselNumbers() {
        return employeeRepository.getAllDecryptedPeselNumbers();
    }
}

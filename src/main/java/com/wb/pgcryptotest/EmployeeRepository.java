package com.wb.pgcryptotest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * Returns encrypted PESEL numbers of all employees
     */
    @Query(value = "SELECT pesel FROM employees", nativeQuery = true)
    List<String> getAllEncryptedPeselNumbers();

    /**
     * Returns decrypted PESEL numbers of all employees
     */
    @Query(value = "SELECT pgp_sym_decrypt(pesel, current_setting('encryption.key')) FROM employees", nativeQuery = true)
    List<String> getAllDecryptedPeselNumbers();
}
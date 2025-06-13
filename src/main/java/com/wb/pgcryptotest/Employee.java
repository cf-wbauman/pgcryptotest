package com.wb.pgcryptotest;

import jakarta.persistence.*;

import org.hibernate.annotations.ColumnTransformer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_generator")
    @SequenceGenerator(name = "employee_id_generator", sequenceName = "employee_id_seq")
    private Integer id;
    private String name;

    @ColumnTransformer(
            read = "pgp_sym_decrypt(pesel, current_setting('encryption.key'))",
            write = "pgp_sym_encrypt(?, current_setting('encryption.key'))")
    @Column(columnDefinition = "bytea", name = "pesel")
    private String pesel;
}

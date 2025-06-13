package com.wb.pgcryptotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class PgcryptotestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PgcryptotestApplication.class, args);
    }
}

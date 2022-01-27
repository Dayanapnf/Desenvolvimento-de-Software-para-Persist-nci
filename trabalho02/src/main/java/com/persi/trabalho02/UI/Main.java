package com.persi.trabalho02.UI;

import com.persi.trabalho02.Controller.OperacionsCRUD;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.persi.trabalho02.entity")
@EnableJpaRepositories("com.persi.trabalho02.DAO")
@ComponentScan("com.persi.trabalho02")
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(OperacionsCRUD.class);
        builder.headless(false).run(args);
    }
}

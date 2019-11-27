package com.example.springboot_test_examination;

import com.codegym.service.CategoryService;
import com.codegym.service.GoodService;
import com.codegym.service.impl.CategoryServiceImpl;
import com.codegym.service.impl.GoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@SpringBootApplication
@EntityScan("com.codegym.model")
@ComponentScan("com.codegym.controller")
@EnableJpaRepositories("com.codegym.repository")
@EnableTransactionManagement
@EnableWebMvc
@EnableSpringDataWebSupport
//doneEntity


public class SpringbootTestExaminationApplication {
    @Bean
    public GoodService goodService(){
        return new GoodServiceImpl();
    }
    @Bean
    public CategoryService categoryService(){
        return new CategoryServiceImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTestExaminationApplication.class, args);
    }

}

package br.com.shelfpix.main;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@EnableAutoConfiguration
@PropertySources(value = {@PropertySource("classpath:application.properties")})
@ComponentScan({
	"br.com.shelfpix.controllers",
	"br.com.shelfpix.dao",
	"br.com.shelfpix.entities",
	"br.com.shelfpix.model",
	"br.com.shelfpix.model.dto",
	"br.com.shelfpix.util"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
    //TODO: consultar o banco para pegar de quais estados sao os pesquisadores e quem sao os respectivos supervisores
    // a exibicao 
    //TODO: iniciar agendamento de consultas ao banco
    // a ideia e criar um "cache interno" com os resultados de todas as consultas da proc do alex
    // em uma base SQLite, para que, mesmo offline, os dados nao desapareçam.

}

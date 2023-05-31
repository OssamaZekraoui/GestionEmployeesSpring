package org.example;


import org.example.security.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountService accountService){
        return args -> {

            /*
            accountService.createUser("admin","123","admin@gmail.com","123");
            accountService.createUser("rh","123","rh@gmail.com","123");
            accountService.createUser("accountant","123","accountant@gmail.com","123");

            accountService.createRole("ADMIN");
            accountService.createRole("RH");
            accountService.createRole("ACCOUNTANT");


            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("admin","RH");
            accountService.addRoleToUser("rh","RH");
            accountService.addRoleToUser("accountant","USER");


            accountService.removeRoleFromUser("rh","RH");
            accountService.removeRoleFromUser("accountant","USER");

             */

            System.out.println(accountService.loadUserByUsername("admin").getEmail());
        };
    }
}
















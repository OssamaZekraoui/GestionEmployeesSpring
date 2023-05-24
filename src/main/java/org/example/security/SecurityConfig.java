package org.example.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
        httpSecurity.formLogin()
                .loginPage("/login").defaultSuccessUrl("/").permitAll();
                 httpSecurity.authorizeHttpRequests().requestMatchers("/webjars/**").permitAll();

        //-----------------Employees---------------------
        httpSecurity.authorizeHttpRequests().requestMatchers("/createEmployee","/saveEmployee").hasAnyRole("ADMIN","RH");
        httpSecurity.authorizeHttpRequests().requestMatchers("/employeesList").hasAnyRole("ADMIN","RH","USER");
        httpSecurity.authorizeHttpRequests().requestMatchers("/deleteEmployee","/showEmployee","/updateEmployee").hasAnyRole("ADMIN");
        //------------------------------------------------

        //------------------Jobs-------------------------
        httpSecurity.authorizeHttpRequests().requestMatchers("/createJob","/saveJob").hasAnyRole("ADMIN","RH");
        httpSecurity.authorizeHttpRequests().requestMatchers("/jobsList").hasAnyRole("ADMIN","RH","USER");
        httpSecurity.authorizeHttpRequests().requestMatchers("/deleteJob","/showJob","/updateJob").hasAnyRole("ADMIN");
        //------------------------------------------------

        httpSecurity.exceptionHandling().accessDeniedPage("/accessDenied");


        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
        return httpSecurity.build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(
                User.withUsername("admin").password(passwordEncoder.encode("admin123")).roles("ADMIN","USER").build(),
                User.withUsername("rh").password(passwordEncoder.encode("rh123")).roles("RH").build(),
                User.withUsername("accountant").password(passwordEncoder.encode("accountant123")).roles("USER").build()
                );
    }



}

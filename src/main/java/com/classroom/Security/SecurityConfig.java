package com.classroom.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/*


@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {
 SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{

     http.authorizeHttpRequests((requests) ->requests
					 .requestMatchers("/Student/add_Student","/Student/Update_Student","/Student/Delete_Student","/Student/Get_Student_Details")
			         .requestMatchers("/classroom/Get_ClassRoom_Details","/TimeTable/Get_TimeTable_Details").permitAll()
					 .req
			*//* .
					 .requestMatchers("/classroom/add_ClassRoom","/classroom/Update_ClassRoom","/classroom/Delete_ClassRoom"
			 ,"/Principal/add_Principal","/Principal/Update_Principal","/Principal/Get_Principal_Details","/Principal/Delete_Principal","/Teacher/add_Teacher"
					 ,"/Teacher/Update_Teacher","/Teacher/Delete_Teacher","/Teacher/Get_Teacher_Details"
			 ,"/TimeTable/add_TimeTable","/TimeTable/Update_TimeTable","/TimeTable/Delete_TimeTable")
*//*
			*//* .formLogin(Customizer.withDefaults())
			 .logout(Customizer.withDefaults());*//*

     return ;

 }

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user1=User.withUsername("Prashant")
				.password(encoder().encode("Pathak"))
				.authorities("Principal")
				.build();

		UserDetails user2=User.withUsername("Poonam")
				.password(encoder().encode("Misra"))
				.authorities("Teacher")
				.build();

		UserDetails user3=User.withUsername("user")
				.password(encoder().encode("Student"))
				.build();


		return new InMemoryUserDetailsManager(user1,user2,user3);
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}*/

package com.project;

import com.project.Models.User.User;
import com.project.Repository.UserRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(UserRepository userRepository){
        return args -> {
            Faker faker = new Faker();
            String name = faker.name().fullName();
            String company = faker.industrySegments().industry();
            String phone = faker.phoneNumber().cellPhone();
            String locations = faker.nation().capitalCity();
            User u1 = new User(
                    name,
                    name.replaceAll(" ", "_").toLowerCase() + "@gmail.com",
                    company,
                    phone,
                    locations,
                    "password"
                    );

            userRepository.save(u1);
        };
    }
}

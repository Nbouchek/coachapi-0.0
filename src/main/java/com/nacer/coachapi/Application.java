package com.nacer.coachapi;

import com.nacer.coachapi.model.Car;
import com.nacer.coachapi.repository.CarRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

/**
 * config - class which will read from property files
 * <p>
 * cache - caching mechanism class files
 * <p>
 * constants - constant defined class
 * <p>
 * controller - controller class
 * <p>
 * exception - exception class
 * <p>
 * model - pojos classes will be present
 * <p>
 * security - security classes
 * <p>
 * service - Impl classes
 * <p>
 * util - utility classes
 * <p>
 * validation - validators classes
 * <p>
 * bootloader - main class
 * <p>
 * <p>
 * src/main/java
 * +- com
 * +- example
 * +- Application.java
 * +- ApplicationConstants.java
 * +- configuration
 * |   +- ApplicationConfiguration.java
 * +- controller
 * |   +- ApplicationController.java
 * +- dao
 * |   +- impl
 * |   |   +- ApplicationDaoImpl.java
 * |   +- ApplicationDao.java
 * +- dto
 * |   +- ApplicationDto.java
 * +- service
 * |   +- impl
 * |   |   +- ApplicationServiceImpl.java
 * |   +- ApplicationService.java
 * +- util
 * |   +- ApplicationUtils.java
 * +- validation
 * |   +- impl
 * |   |   +- ApplicationValidationImpl.java
 * |   +- ApplicationValidation.java
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ApplicationRunner init(CarRepository repository) {
        return args -> {
            Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
                    "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV", "BMW S1").forEach(name -> {
                Car car = new Car();
                car.setName(name);
                repository.save(car);
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}

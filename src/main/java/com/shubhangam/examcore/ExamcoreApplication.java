package com.shubhangam.examcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class ExamcoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamcoreApplication.class, args);
    }

}

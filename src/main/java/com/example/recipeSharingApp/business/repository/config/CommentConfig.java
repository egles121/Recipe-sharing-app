package com.example.recipeSharingApp.business.repository.config;

import com.example.recipeSharingApp.business.repository.CommentRepository;
import com.example.recipeSharingApp.model.Comment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CommentConfig {

    @Bean
    CommandLineRunner commandLineRunner(CommentRepository repository) {
        return args -> {
            Comment comment1 = new Comment(
                    1L,
                    1L,
                    1L,
                    "this is great"
            );

            Comment comment2 = new Comment(
                    2L,
                    2L,
                    1L,
                    "delicious!"
            );

            Comment comment3 = new Comment(
                    3L,
                    1L,
                    1L,
                    "in the end this recipe didn't work out for me :("
            );

            repository.saveAll(
                    List.of(comment1, comment2, comment3));
        };
    }
}

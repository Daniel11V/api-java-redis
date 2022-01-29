package com.coderhouse;

import com.coderhouse.model.Message;
import com.coderhouse.repository.MessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(MessageRepository repository) {
		return (args) -> {
			repository.save(Message.builder().id(1L).description("Mensaje-A").build());
			repository.save(Message.builder().id(2L).description("Mensaje-B").build());
			repository.save(Message.builder().id(3L).description("Mensaje-C").build());
			repository.save(Message.builder().id(4L).description("Mensaje-D").build());
			repository.save(Message.builder().id(5L).description("Mensaje-D").build());
		};
	}

}

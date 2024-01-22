package it.ruggero.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DraftApplication {

	public static void main(String[] args) {
		SpringApplication.run(DraftApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		Book book = new Book();
		book.setName("name");
		book.setTitle("title");
		book.setId(2L);

		return (args -> {
			repository.save(book);
			Book book1 = repository.findAll().stream().findFirst().orElse(new Book());
			System.out.println(book1);
		});
	}

}

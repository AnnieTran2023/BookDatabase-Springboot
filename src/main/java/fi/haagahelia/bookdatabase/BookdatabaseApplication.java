package fi.haagahelia.bookdatabase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookdatabase.domain.Book;
import fi.haagahelia.bookdatabase.domain.BookRepository;

@SpringBootApplication
public class BookdatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookdatabaseApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository){
		return (args) -> {
			Book book1 = new Book("JK Rowling","Harry Potter", "978-1-4088-1234-5", 2023);
			Book book2 = new Book("Isaac Asimov","Foundation","978-0-553-08002-7",2021);
			Book book3 = new Book("Agatha Christie","Murder on the Orient Express","978-0-06-207350-1", 2020);
			Book book4 = new Book("George R.R. Martin","A Game of Thrones","978-0-553-10354-0", 1999);

			repository.save(book1);
			repository.save(book2);
			repository.save(book3);
			repository.save(book4);

		};
	}

}

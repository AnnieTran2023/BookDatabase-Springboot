package fi.haagahelia.bookdatabase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookdatabase.domain.AppUser;
import fi.haagahelia.bookdatabase.domain.AppUserRepository;
import fi.haagahelia.bookdatabase.domain.Book;
import fi.haagahelia.bookdatabase.domain.BookRepository;
import fi.haagahelia.bookdatabase.domain.Category;
import fi.haagahelia.bookdatabase.domain.CategoryRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class BookdatabaseApplication {

	private static final Logger log = LoggerFactory.getLogger(BookdatabaseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookdatabaseApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository,
			AppUserRepository urepository) {
		return (args) -> {
	
			Category fiction = new Category("Fiction");
			Category scienceFiction = new Category("Science Fiction");
			Category mystery = new Category("Mystery");

			// Saving categories to the repository
			crepository.save(fiction);
			crepository.save(scienceFiction);
			crepository.save(mystery);

		
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER",
					"user@email.fi");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"ADMIN", "admin@email.fi");

			urepository.save(user1);
			urepository.save(user2);

			Book book1 = new Book("JK Rowling", "Harry Potter", "978-1-4088-1234-5", 2023, fiction);
			Book book2 = new Book("Isaac Asimov", "Foundation", "978-0-553-08002-7", 2021, scienceFiction);
			Book book3 = new Book("Agatha Christie", "Murder on the Orient Express", "978-0-06-207350-1", 2020,
					mystery);
			Book book4 = new Book("George R.R. Martin", "A Game of Thrones", "978-0-553-10354-0", 1999, fiction);

			// Saving books to the repository
			repository.save(book1);
			repository.save(book2);
			repository.save(book3);
			repository.save(book4);
			log.info(user1.getRole());
			log.info(user2.getRole());
		};
	}
}

package fi.haagahelia.bookdatabase;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookdatabase.domain.Book;
import fi.haagahelia.bookdatabase.domain.BookRepository;
import fi.haagahelia.bookdatabase.domain.Category;
import fi.haagahelia.bookdatabase.domain.CategoryRepository;

@SpringBootApplication
public class BookdatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookdatabaseApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			// Creating categories
			Category fiction = new Category("Fiction");
			Category scienceFiction = new Category("Science Fiction");
			Category mystery = new Category("Mystery");
			

			// Saving categories to the repository
			crepository.save(fiction);
			crepository.save(scienceFiction);
			crepository.save(mystery);

			// Creating books and associating them with categories
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
		};
	}
}

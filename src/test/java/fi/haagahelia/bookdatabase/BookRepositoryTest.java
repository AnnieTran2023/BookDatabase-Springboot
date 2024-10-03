package fi.haagahelia.bookdatabase;

import java.util.List;
import fi.haagahelia.bookdatabase.domain.Category;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fi.haagahelia.bookdatabase.domain.Book;
import fi.haagahelia.bookdatabase.domain.BookRepository;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByTitleShouldReturnBook (){
        List<Book> books = repository.findByTitle("Harry Potter");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("JK Rowling");
    }

    @Test
    public void createNewBook() {
        Category fiction = new Category("Fiction");
        Book book = new Book("Fujiko", "Doraemon", "978-2-4088-1234-6", 1999, fiction);
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

}

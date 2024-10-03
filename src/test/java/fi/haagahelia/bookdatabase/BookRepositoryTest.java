package fi.haagahelia.bookdatabase;

import java.util.List;
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
        List<Book> books = repository.findByTitle("A Farewell to Arms");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Ernest Hemingway");
    }

}

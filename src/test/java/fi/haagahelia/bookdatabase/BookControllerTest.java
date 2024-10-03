package fi.haagahelia.bookdatabase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

import fi.haagahelia.bookdatabase.domain.BookRepository;

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestSecurityConfig.class) // Import the test security configuration to bypass the login
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testGetBookById() throws Exception {
        this.mockMvc.perform(get("/api/books/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Harry Potter"));
    }

    @Test
    public void testGetBooks() throws Exception {
        this.mockMvc.perform(get("/api/books"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.books").exists());
    }

    @Test
    public void testDeleteBook() throws Exception {
        this.mockMvc.perform(get("/api/books/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Harry Potter"));

        this.mockMvc.perform(get("/book/delete/1"))
                .andDo(print())
                .andExpect(content().string(containsString("Book deleted successfully")));

        this.mockMvc.perform(get("/api/books/1"))
                .andDo(print())
                .andExpect(status().isNotFound());
    } 

}

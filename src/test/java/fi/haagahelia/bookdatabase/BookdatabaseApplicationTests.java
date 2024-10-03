package fi.haagahelia.bookdatabase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import fi.haagahelia.bookdatabase.web.BookController;

@SpringBootTest
class BookdatabaseApplicationTests {
	
	//This for testing the controller
	@Autowired
	private BookController controller;
	@Test
	void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}

}

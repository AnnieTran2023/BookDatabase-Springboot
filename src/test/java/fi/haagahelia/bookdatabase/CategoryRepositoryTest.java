package fi.haagahelia.bookdatabase;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fi.haagahelia.bookdatabase.domain.Category;
import fi.haagahelia.bookdatabase.domain.CategoryRepository;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByCategoryNameShouldReturnCategory() {
        List<Category> categories = repository.findByName("Fiction");

        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Fiction");
    }

}

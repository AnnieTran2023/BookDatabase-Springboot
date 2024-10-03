package fi.haagahelia.bookdatabase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import fi.haagahelia.bookdatabase.domain.AppUser;
import fi.haagahelia.bookdatabase.domain.AppUserRepository;

@DataJpaTest
public class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository repository;

    @Test
    public void findByUsernameShouldReturnUser() {
        AppUser user = repository.findByUsername("admin");

        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo("admin");
    }
}

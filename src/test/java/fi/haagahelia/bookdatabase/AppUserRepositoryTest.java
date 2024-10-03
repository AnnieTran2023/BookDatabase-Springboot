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

    @Test
    public void testCreateUser() {
        AppUser user = new AppUser("admin2", "password","ADMIN","admin@mail.com");
        repository.save(user);
        assertThat(user.getId()).isNotNull();
    }

    @Test
    public void testDeleteUser() {
        AppUser user = repository.findByUsername("user");
        repository.deleteById(user.getId());
        user = repository.findByUsername("user");
        assertThat(user).isNull();
    }
}

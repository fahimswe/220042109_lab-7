import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AdminUserTest {

    @Test
    public void testUpdateUser() {
        AdminUser adminUser = new AdminUser("1", "adminUser", "admin@example.com", "password123");
        assertDoesNotThrow(() -> adminUser.updateUser("2", "newDetails"));
    }
}

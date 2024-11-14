
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testAuthenticate() {
        User user = new RegularUser("1", "regularUser", "regular@example.com", "password123");
        assertTrue(user.authenticate("password123"));
        assertFalse(user.authenticate("wrongpassword"));
    }
}

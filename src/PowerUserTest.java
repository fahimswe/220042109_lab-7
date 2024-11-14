import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PowerUserTest {

    @Test
    public void testAddUser() {
        PowerUser powerUser = new PowerUser("2", "powerUser", "power@example.com", "password123");
        assertDoesNotThrow(() -> powerUser.addUser("3,newUser,new@example.com,password456,Regular"));
    }
}

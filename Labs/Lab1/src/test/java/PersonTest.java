import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {

  private Person person;

  @BeforeEach
  void setUp() {
    person = new Person("Ada", "ada@northeastern.edu", "360 Huntington Ave");
  }

  @Test
  void getName() {
    assertEquals("Ada", person.getName());
  }

  @Test
  void getEmail() {
    assertEquals("ada@northeastern.edu", person.getEmail());
  }

  @Test
  void getAddress() {
    assertEquals("360 Huntington Ave", person.getAddress());
  }
}

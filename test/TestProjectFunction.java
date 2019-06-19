import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Name: 
 * Date: 
 * Description: Tests used to verify API adherence for an immutable data type Project
 * using test driven design (TDD).
 *
 * API Requirements:
 *
 * public class Project {
 *     public Project(String string)          // construct a Project
 *     public int getProperty()               // fectch a property
 *     public int isTrue()                    // fetch a boolean
 *     public static void main(String[] args) // unit tests
 * }
 *
 * Corner Caases:
 *
 * Throw java.lang.IllegalArgumentException when constructor argument is null
 *
 */

@DisplayName(Values.SUITE_TITLE_PROJECT_FUNCTION)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestProjectFunction {

    @BeforeAll
    static void setup() {
        StdOut.println();
        StdOut.println(Values.SUITE_TITLE_PROJECT_FUNCTION + String.format(" %s", Values.dateTime()));
    }

    @Order(1)
    @DisplayName(Values.VERIFY_NULL_CONSTRUCTOR_ARGUMENT_THROWS_EXCEPTION)
    @Test void throw_exception_on_null_constructor_argument() {
        StdOut.printf(Values.TEST_FORMAT, Values.VERIFY_NULL_CONSTRUCTOR_ARGUMENT_THROWS_EXCEPTION);
        assertThrows(IllegalArgumentException.class, () -> {
            Project object = new Project(null);
            assertNotNull(object);
        });
        StdOut.println(Values.PASSED);
    }

    @Order(2)
    @DisplayName(Values.VERIFY_CONSTRUCTOR_ARGUMENT)
    @Test void get_value_returns_constructor_argument() {
        StdOut.printf(Values.TEST_FORMAT, Values.VERIFY_CONSTRUCTOR_ARGUMENT);
        Project objcet = new Project("value");
        String expected = "value";
        String actual = objcet.getValue();
        assertEquals(expected, actual);
        StdOut.println(Values.PASSED);
    }

    @Order(2)
    @DisplayName(Values.VERIFY_TRUE_METHOD)
    @Test void is_true_returns_true() {
        StdOut.printf(Values.TEST_FORMAT, Values.VERIFY_TRUE_METHOD);
        Project objcet = new Project("value");
        boolean actual = objcet.isTrue();
        assertTrue(actual);
        StdOut.println(Values.PASSED);
    }

}

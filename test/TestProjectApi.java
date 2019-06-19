import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Name: 
 * Date: 
 * Description: Tests used to create an empty API for an immutable data type Project
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
 */

@DisplayName(Values.SUITE_TITLE_PROJECT_API)
public class TestProjectApi {
    @BeforeAll
    static void setup() {
        StdOut.println();
        StdOut.println(Values.SUITE_TITLE_PROJECT_API + String.format(" %s", Values.dateTime()));
    }

    @DisplayName(Values.VERIFY_API_METHODS)
    @Test
    void verify_api_methods() {
        StdOut.printf(Values.TEST_FORMAT, Values.VERIFY_API_METHODS);
        List<String> expected = expectedMethods();
        List<String> actual = actualMethods();
        assertEquals(expected, actual);
        StdOut.println(Values.PASSED);
    }

    private List<String> expectedMethods() {
        List<String> expected = Arrays.asList("getValue", "isTrue");
        Collections.sort(expected);

        return expected;
    }

    private List<String> actualMethods() {
        return Spy.publicMethodNames(Project.class)
                  .stream()
                  .filter(s -> !s.equals("main"))
                  .sorted()
                  .collect(Collectors.toList());
    }
}

/**
 * Name:
 * Date:
 * Description: An Immutable object type Project.
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

public class Project {
    private String value;

    public Project(String string) {
        if (string == null)
            throw new IllegalArgumentException();

        value = string;
    }

    public String getValue() {
        return value;
    }

    public boolean isTrue() {
        return true;
    }
}

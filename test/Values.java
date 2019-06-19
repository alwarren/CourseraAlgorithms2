import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Name:
 * Date:
 * Description: Static values and helper methods for JUnit5 unit tests.
 */

public class Values {
    public static final String PASSED = "PASSED";
    public static final String TEST_FORMAT = "  %s => ";

    public static final String SUITE_TITLE_PROJECT_API = "Project API Tests";
    public static final String SUITE_TITLE_PROJECT_FUNCTION = "Project Functional Tests";

    public static final String VERIFY_NULL_CONSTRUCTOR_ARGUMENT_THROWS_EXCEPTION = "Null constructor argument throws required exception";
    public static final String VERIFY_API_METHODS = "Expected methods";

    public static final String VERIFY_CONSTRUCTOR_ARGUMENT = "Method getValue returns constructor argument";
    public static final String VERIFY_TRUE_METHOD = "Method isTrue returns true";

    public static String dateTime() {
        String pattern = "yyyy-MM-dd h:mm a";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }
}

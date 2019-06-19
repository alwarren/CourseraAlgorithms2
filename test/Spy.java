/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Spy {

    public static List<Method> publicMethods(Class<?> clazz) {
        List<Method> results = new ArrayList<>();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (!method.isSynthetic()) {
                int modifiers = method.getModifiers();
                if ((modifiers & Modifier.PUBLIC) == Modifier.PUBLIC) {
                    results.add(method);
                }
            }
        }

        return results;
    }

    public static List<String> publicMethodNames(Class<?> clazz) {
        List<String> results = new ArrayList<>();
        List<Method> methods = publicMethods(clazz);

        for (Method method : methods) results.add(method.getName());

        return results;
    }

    public static void main(String... args) {
        if (args.length == 0) return;
        try {
            Class<?> c = Class.forName(args[0]);
            int searchMods = 0x0;
            for (int i = 1; i < args.length; i++) {
                searchMods |= modifierFromString(args[i]);
            }

            Method[] methods = c.getDeclaredMethods();
            out.format("Methods in Class '%s' containing modifiers:  %s%n",
                       c.getName(),
                       Modifier.toString(searchMods));
            boolean found = false;
            for (Method f : methods) {
                int foundMods = f.getModifiers();
                // Require all of the requested modifiers to be present
                if ((foundMods & searchMods) == searchMods) {
                    out.format("%-8s [ synthetic=%-5b]%n",
                               f.getName(), f.isSynthetic());
                    found = true;
                }
            }

            if (!found) {
                out.format("No matching Methods%n");
            }

            // production code should handle this exception more gracefully
        } catch (ClassNotFoundException x) {
            // no op
        }
    }

    private static int modifierFromString(String s) {
        int m = 0x0;
        if ("public".equals(s))           m |= Modifier.PUBLIC;
        else if ("protected".equals(s))   m |= Modifier.PROTECTED;
        else if ("private".equals(s))     m |= Modifier.PRIVATE;
        else if ("static".equals(s))      m |= Modifier.STATIC;
        else if ("final".equals(s))       m |= Modifier.FINAL;
        else if ("transient".equals(s))   m |= Modifier.TRANSIENT;
        else if ("volatile".equals(s))    m |= Modifier.VOLATILE;
        return m;
    }
}

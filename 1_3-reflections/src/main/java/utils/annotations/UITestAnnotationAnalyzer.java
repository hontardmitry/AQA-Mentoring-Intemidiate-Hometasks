package utils.annotations;

import java.lang.reflect.Method;

public class UITestAnnotationAnalyzer {
    public void parse(Class<?> clazz) {
        Method[] methods = clazz.getMethods();
        boolean isUITest = false;

        for (Method method : methods) {
            if (method.isAnnotationPresent(UITest.class)) {
                isUITest = true;
            }
        }
    }
}

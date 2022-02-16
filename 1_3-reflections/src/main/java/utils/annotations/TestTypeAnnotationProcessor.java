package utils.annotations;

import utils.enums.TestTypes;

public class TestTypeAnnotationProcessor {
    public static boolean isTestUI(Class<?> clazz) {
        boolean isUITest = false;

            if (clazz.isAnnotationPresent(TestType.class)) {
                TestType annotation = clazz.getAnnotation(TestType.class);
                TestTypes type = annotation.value();
                isUITest = switch (type) {
                    case UI -> true;
                    case API -> false;
                };
            }
        return isUITest;
    }
}

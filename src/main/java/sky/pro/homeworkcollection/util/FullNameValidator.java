package sky.pro.homeworkcollection.util;

import org.apache.commons.lang3.StringUtils;
import sky.pro.homeworkcollection.exception.IllegalNameException;

public class FullNameValidator {
    public static void checkName(String... names) {
        for (String name : names) {
            if (!StringUtils.isAlpha(name)) {
                throw new IllegalNameException("В имени могут быть только буквы");

            }
        }
    }
}

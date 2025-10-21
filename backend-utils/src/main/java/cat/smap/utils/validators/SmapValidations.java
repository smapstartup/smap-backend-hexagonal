package cat.smap.utils.validators;

import java.util.regex.Pattern;

public class SmapValidations {

    public static boolean validateTargetByPattern(String target, String pattern) {
        return Pattern.compile(pattern)
                .matcher(target)
                .matches();
    }
}

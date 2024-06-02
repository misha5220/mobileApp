package helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDExtractor {
    public static String getID(String input){
        {
            Pattern pattern = Pattern.compile("ID: (\\S+)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                return matcher.group(1);
            } else {
                return null;
            }

        }
    }
}

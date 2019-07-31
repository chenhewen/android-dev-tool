import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppRegex {

    public static String parsePkgName(String input) {
        Pattern pattern = Pattern.compile("[\\S]+(?=\\/)");
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            return matcher.group(count);
        }
        return "";
    }

    public static String parseClassName(String input) {
        Pattern pattern = Pattern.compile("(?<=\\/)[^\\s}]+");
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            return matcher.group(count);
        }
        return "";
    }

    public static String parseApkPath(String input) {
        Pattern pattern = Pattern.compile("(?<=:)[\\S]+.apk");
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            return matcher.group(count);
        }
        return "";
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessUtil {

    public static String getResult(Process process) throws IOException {
        if (process == null) {
            return "";
        }

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        // Grab the results
        StringBuilder log = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            log.append(line).append("\n");
        }

        return log.toString();
    }
}

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileLoggerConfigurationLoader {

    public static String loadLogFileConfig(String fileName) {
        var sb = new StringBuilder();
        try (InputStream is = new FileInputStream(fileName)) {
            int symbol;
            while ((symbol = is.read()) != -1) {
                sb.append((char) symbol);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
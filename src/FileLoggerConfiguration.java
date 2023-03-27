import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLoggerConfiguration {

    /* Infolog file max size */
    public static int getInfoLogSize() {
        return 250;
    }

    /* Debuglog file max size */
    public static int getDebugLogSize() {
        return 400;
    }

    /* Time format in log files names */
    public static String getDateFormat() {
        return new SimpleDateFormat("dd.MM.yyyy-HH.mm.ss.SSSS").format(new Date());
    }

    /* Content of info log config file */
    public static String infoLogConfigFileContent() {
        return "FILE: " + infoLogFileCreation().getAbsoluteFile() +
                "\nLEVEL: INFO\nMAX-SIZE: " + getInfoLogSize() +
                "\nFORMAT: Infolog_dd.MM.yyyy-HH.mm.ss.SSSS.txt\n";
    }

    /* Content of debug log config file */
    public static String debugLogConfigFileContent() {
        return "FILE: " + debugLogFileCreation().getAbsoluteFile() +
                "\nLEVEL: DEBUG\nMAX-SIZE: " + getDebugLogSize() +
                "\nFORMAT: Debuglog_dd.MM.yyyy-HH.mm.ss.SSSS.txt\n";
    }

    /* Infolog file creation */
    public static File infoLogFileCreation() {
        String fileName = "Infolog_" + getDateFormat() + ".txt";
        return new File(fileName);
    }

    /* Debuglog file creation */
    public static File debugLogFileCreation() {
        String fileName = "Debuglog_" + getDateFormat() + ".txt";
        return new File(fileName);
    }

    /* Infolog config file creation */
    public static void infoLogConfigFile(String inputString) {
        byte[] buffer = inputString.getBytes();
        File file = new File("infologconfig.txt");
        try (FileOutputStream fout = new FileOutputStream(file)) {
            for (byte element : buffer) {
                fout.write(element);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* Debuglog config file creation */
    public static void debugLogConfigFile(String inputString) {
        byte[] buffer = inputString.getBytes();
        File file = new File("debuglogconfig.txt");
        try (FileOutputStream fout = new FileOutputStream(file)) {
            for (byte element : buffer) {
                fout.write(element);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
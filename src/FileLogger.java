import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileLogger {

    /* Write input string to infolog file(s) */
    public static void info(String inputString) {

        byte[] buffer = inputString.getBytes();

        /* Creation of multiple log files in case input string size > log file max size */
        while (buffer.length > FileLoggerConfiguration.getInfoLogSize()) {
            byte[] bufferPart = Arrays.copyOfRange(buffer, 0, FileLoggerConfiguration.getInfoLogSize());
            try (FileOutputStream fout = new FileOutputStream(FileLoggerConfiguration.infoLogFileCreation())) {
                for (byte element : bufferPart) {
                    fout.write(element);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            buffer = Arrays.copyOfRange(buffer, FileLoggerConfiguration.getInfoLogSize(), buffer.length);
        }

        try (FileOutputStream fout = new FileOutputStream(FileLoggerConfiguration.infoLogFileCreation())) {
            for (byte element : buffer) {
                fout.write(element);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* Call of info log config file creation method */
        FileLoggerConfiguration.infoLogConfigFile(FileLoggerConfiguration.infoLogConfigFileContent());

        /* Loading info from info log config file */
        var infoLogConfig = FileLoggerConfigurationLoader.loadLogFileConfig("infologconfig.txt");
        System.out.println(infoLogConfig);
    }

    /* Write input string to debuglog file(s) */
    public static void debug(String inputString) {

        byte[] buffer = inputString.getBytes();

        /* Creation of multiple log files in case input string size > log file max size */
        while (buffer.length > FileLoggerConfiguration.getDebugLogSize()) {
            byte[] bufferPart = Arrays.copyOfRange(buffer, 0, FileLoggerConfiguration.getDebugLogSize());
            try (FileOutputStream fout = new FileOutputStream(FileLoggerConfiguration.debugLogFileCreation())) {
                for (byte element : bufferPart) {
                    fout.write(element);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            buffer = Arrays.copyOfRange(buffer, FileLoggerConfiguration.getDebugLogSize(), buffer.length);
        }

        try (FileOutputStream fout = new FileOutputStream(FileLoggerConfiguration.debugLogFileCreation())) {
            for (byte element : buffer) {
                fout.write(element);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /* Call of debug log config file creation method */
        FileLoggerConfiguration.debugLogConfigFile(FileLoggerConfiguration.debugLogConfigFileContent());

        /* Loading info from debug log config file */
        var debugLogConfig = FileLoggerConfigurationLoader.loadLogFileConfig("debuglogconfig.txt");
        System.out.println(debugLogConfig);

        /* Call of info method as part of debug method */
        info(InputString.getInfoLogInput());
    }
}
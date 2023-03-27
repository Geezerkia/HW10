import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        loggerDemo();
    }

    static void loggerDemo() {
        var sc = new Scanner(System.in);
        System.out.println("Enter logging level - INFO or DEBUG: ");
        try {
            var loggingLevel = LoggingLevel.valueOf(sc.nextLine().toUpperCase());
            switch (loggingLevel) {
                case INFO -> FileLogger.info(InputString.getInfoLogInput());
                case DEBUG -> FileLogger.debug(InputString.getDebugLogInput());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong level! Enter again!");
        }
        sc.close();
    }
}
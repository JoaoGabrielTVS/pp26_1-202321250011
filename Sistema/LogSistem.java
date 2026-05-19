package Sistema;

public class LogSistem {
    private static LogSistem instance;
    private String file_path;
    private static String arquivo = "";

    private LogSistem(String file_path) {
        this.file_path = file_path;
    }

    public static LogSistem get_instance(String file) {
        if (instance == null) {
            instance = new LogSistem(file);
            instance.register_log("Init");
        }
        return instance;
    }

    public String get_file_path() {
        return file_path;
    }

    public void register_log(String msg) {
        arquivo += msg + System.lineSeparator();
    }

    public String get_log_register() {
        return arquivo;
    }
}
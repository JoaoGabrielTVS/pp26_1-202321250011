package Sistema;

public class LogSistem {

    private static LogSistem instance;
    private String file_path;
    private static String arquivo = "";

   
    private boolean mostrarTerminal = false;

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

    // Chame isso no main DEPOIS de toda configuração inicial
    // A partir daqui, tudo que for registrado também aparece no terminal
    public void ativarTerminal() {
        mostrarTerminal = true;
    }

    public String get_file_path() {
        return file_path;
    }

    public void register_log(String msg) {
        arquivo += msg + System.lineSeparator();

        if (mostrarTerminal) {
            System.out.println(msg);
        }
    }

    public String get_log_register() {
        return arquivo;
    }
}
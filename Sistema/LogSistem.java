package Sistema;

public class LogSistem {

    private static LogSistem instance;
    private String file_path;
    private static String arquivo = "";

    // Controla se o log imprime no terminal em tempo real
    // Começa FALSE para não poluir o terminal durante o setup
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
        // SEMPRE acumula no histórico (Log 2 — histórico completo)
        arquivo += msg + System.lineSeparator();

        // Só imprime em tempo real (Log 1) se o terminal estiver ativo
        if (mostrarTerminal) {
            System.out.println(msg);
        }
    }

    public String get_log_register() {
        return arquivo;
    }
}
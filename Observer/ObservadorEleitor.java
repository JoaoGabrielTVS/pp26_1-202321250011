package Observer;

import Sistema.LogSistem;

public interface ObservadorEleitor {

    // Passa o log para que a reação do eleitor também entre no histórico completo
    void atualizar(String mensagem, LogSistem log);

}
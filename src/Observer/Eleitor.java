package Observer;

import Debate.ColaboradorPolitico;
import Sistema.LogSistem;

public class Eleitor implements ObservadorEleitor {

    private String nome;
    private ColaboradorPolitico candidatoPreferido;

    public Eleitor(String nome, ColaboradorPolitico candidatoPreferido) {
        this.nome = nome;
        this.candidatoPreferido = candidatoPreferido;
    }

    @Override
    public void atualizar(String mensagem, LogSistem log) {
        // Agora passa pelo log: aparece em tempo real E no histórico final
        log.register_log("  Eleitor " + nome + ": " + mensagem);
    }

    public ColaboradorPolitico getCandidatoPreferido() {
        return candidatoPreferido;
    }
}
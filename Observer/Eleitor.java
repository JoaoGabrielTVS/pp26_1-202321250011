package Observer;

import Debate.ColaboradorPolitico;

public class Eleitor implements ObservadorEleitor {
    private String nome;
    private ColaboradorPolitico candidatoPreferido;

    public Eleitor(String nome, ColaboradorPolitico candidatoPreferido) {
        this.nome = nome;
        this.candidatoPreferido = candidatoPreferido;
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println("Eleitor " + nome + ": " + mensagem);
    }

    public ColaboradorPolitico getCandidatoPreferido() {
        return candidatoPreferido;
    }
}
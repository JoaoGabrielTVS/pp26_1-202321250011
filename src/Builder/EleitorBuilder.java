package Builder;

import Debate.ColaboradorPolitico;
import Observer.Eleitor;
import Sistema.LogSistem;

/**
 * Builder para construir um Eleitor passo a passo.
 *
 * Na sua UML, o Eleitor tem dois campos obrigatórios:
 *   - nome
 *   - candidatoPreferido
 *
 * O EleitorBuilder garante que nenhum campo seja esquecido
 * antes de chamar build(), e permite encadear as chamadas.
 *
 * Uso:
 *   Eleitor e = new EleitorBuilder()
 *       .setNome("João")
 *       .setCandidatoPreferido(caneta)
 *       .build();
 */
public class EleitorBuilder {

    private String nome;
    private ColaboradorPolitico candidatoPreferido;
    private Eleitor eleitor;

    /** Passo 1 — define o nome do eleitor. Retorna this para encadeamento. */
    public EleitorBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    /** Passo 2 — define o candidato preferido. Retorna this para encadeamento. */
    public EleitorBuilder setCandidatoPreferido(ColaboradorPolitico candidatoPreferido) {
        this.candidatoPreferido = candidatoPreferido;
        return this;
    }

    /** Getter do candidato preferido — conforme sua UML. */
    public ColaboradorPolitico getCandidatoPreferido() {
        return candidatoPreferido;
    }

    /**
     * Passo final — constrói e retorna o Eleitor.
     * Lança exceção se nome ou candidato não foram definidos.
     */
    public Eleitor build() {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalStateException("Nome do eleitor não definido.");
        }
        if (candidatoPreferido == null) {
            throw new IllegalStateException("Candidato preferido não definido.");
        }
        this.eleitor = new Eleitor(nome, candidatoPreferido);
        return this.eleitor;
    }
}
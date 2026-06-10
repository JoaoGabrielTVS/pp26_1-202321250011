package Builder;

import Debate.ColaboradorPolitico;
import Debate.Inquiridor;
import Debate.MediarDebate;

/**
 * Builder concreto para Inquiridor.
 *
 * Uso típico em MediarDebate.set_inquiridor():
 *
 *   BuilderInquiridor builder = new BuilderInquiridor();
 *   builder.definirColaborador(politico);   // clona via Prototype
 *   builder.definirMediator(this);          // associa o mediador
 *   builder.definirPapel(true);             // marca como inquiridor
 *   Inquiridor pronto = builder.getInquiridor();
 */
public class BuilderInquiridor extends InterfaceConstrutor {

    private Inquiridor inquiridor;

    /**
     * Passo 1 — clona o político usando Prototype e converte para Inquiridor.
     * Assim não perdemos os eleitores cadastrados no ColaboradorPolitico original.
     */
    @Override
    public void definirColaborador(ColaboradorPolitico colaborador) {
        // Cria um Inquiridor novo com nome e partido do colaborador original
        this.inquiridor = new Inquiridor(colaborador.get_nome(), colaborador.get_partido());
        // Copia os eleitores do colaborador original (Observer intacto)
        this.inquiridor.copiarEleitoresDe(colaborador);
    }

    /**
     * Passo 2 — associa o mediador ao Inquiridor construído.
     */
    @Override
    public void definirMediator(MediarDebate mediador) {
        if (inquiridor != null) {
            inquiridor.set_mediador(mediador);
        }
    }

    /**
     * Passo 3 — marca o papel do colaborador.
     * Para o Inquiridor, sempre será true.
     */
    @Override
    public void definirPapel(boolean ehInquiridor) {
        if (inquiridor != null) {
            inquiridor.set_inquiridor(ehInquiridor);
        }
    }

    /** Retorna o Inquiridor completamente montado. */
    public Inquiridor getInquiridor() {
        return inquiridor;
    }
}
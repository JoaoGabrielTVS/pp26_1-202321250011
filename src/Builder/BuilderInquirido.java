package Builder;

import Debate.ColaboradorPolitico;
import Debate.Inquirido;
import Debate.MediarDebate;

/**
 * Builder concreto para Inquirido.
 *
 * Uso típico em MediarDebate.set_inquirido():
 *
 *   BuilderInquirido builder = new BuilderInquirido();
 *   builder.definirColaborador(politico);   // cria Inquirido com dados do original
 *   builder.definirMediator(this);          // associa o mediador
 *   builder.definirPapel(false);            // marca como NÃO inquiridor
 *   Inquirido pronto = builder.getInquirido();
 */
public class BuilderInquirido extends InterfaceConstrutor {

    private Inquirido inquirido;

    /**
     * Passo 1 — cria o Inquirido com nome e partido do colaborador original
     * e copia os eleitores (Observer intacto).
     */
    @Override
    public void definirColaborador(ColaboradorPolitico colaborador) {
        this.inquirido = new Inquirido(colaborador.get_nome(), colaborador.get_partido());
        this.inquirido.copiarEleitoresDe(colaborador);
    }

    /**
     * Passo 2 — associa o mediador ao Inquirido construído.
     */
    @Override
    public void definirMediator(MediarDebate mediador) {
        if (inquirido != null) {
            inquirido.set_mediador(mediador);
        }
    }

    /**
     * Passo 3 — marca o papel.
     * Para o Inquirido, sempre será false.
     */
    @Override
    public void definirPapel(boolean ehInquiridor) {
        if (inquirido != null) {
            inquirido.set_inquiridor(ehInquiridor);
        }
    }

    /** Retorna o Inquirido completamente montado. */
    public Inquirido getInquirido() {
        return inquirido;
    }
}
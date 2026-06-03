package Builder;

import Debate.ColaboradorPolitico;
import Debate.Inquiridor;
import Debate.MediarDebate;


public class BuilderInquiridor extends InterfaceConstrutor {

    private Inquiridor inquiridor;

  
    @Override
    public void definirColaborador(ColaboradorPolitico colaborador) {
        // Cria um Inquiridor novo com nome e partido do colaborador original
        this.inquiridor = new Inquiridor(colaborador.get_nome(), colaborador.get_partido());
        // Copia os eleitores do colaborador original (Observer intacto)
        this.inquiridor.copiarEleitoresDe(colaborador);
    }

  
    @Override
    public void definirMediator(MediarDebate mediador) {
        if (inquiridor != null) {
            inquiridor.set_mediador(mediador);
        }
    }

   
    @Override
    public void definirPapel(boolean ehInquiridor) {
        if (inquiridor != null) {
            inquiridor.set_inquiridor(ehInquiridor);
        }
    }

    public Inquiridor getInquiridor() {
        return inquiridor;
    }
}
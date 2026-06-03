package Builder;

import Debate.ColaboradorPolitico;
import Debate.Inquirido;
import Debate.MediarDebate;


public class BuilderInquirido extends InterfaceConstrutor {

    private Inquirido inquirido;


    @Override
    public void definirColaborador(ColaboradorPolitico colaborador) {
        this.inquirido = new Inquirido(colaborador.get_nome(), colaborador.get_partido());
        this.inquirido.copiarEleitoresDe(colaborador);
    }

 
    @Override
    public void definirMediator(MediarDebate mediador) {
        if (inquirido != null) {
            inquirido.set_mediador(mediador);
        }
    }

 
    @Override
    public void definirPapel(boolean ehInquiridor) {
        if (inquirido != null) {
            inquirido.set_inquiridor(ehInquiridor);
        }
    }


    public Inquirido getInquirido() {
        return inquirido;
    }
}
package Builder;

import Debate.ColaboradorPolitico;
import Debate.MediarDebate;


public abstract class InterfaceConstrutor {

    public abstract void definirColaborador(ColaboradorPolitico colaborador);

    public abstract void definirMediator(MediarDebate mediador);

    public abstract void definirPapel(boolean ehInquiridor);
}
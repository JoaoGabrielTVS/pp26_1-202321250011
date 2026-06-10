package Debate;

import Sistema.LogSistem;
import State.InquiridorPerguntar;
import State.InquiridorState;


public class Inquiridor extends ColaboradorPolitico {

    private InquiridorState estado;

    public Inquiridor(String nome, String partido) {
        super(nome, partido);
        this.estado = new InquiridorPerguntar(microfone);
    }

    private Inquiridor(Inquiridor original) {
        super(original);
        this.estado = new InquiridorPerguntar(microfone);
    }

    @Override
    public Inquiridor clonar() {
        return new Inquiridor(this);
    }

    public void escolha_inquirido(ColaboradorPolitico politico) {
        if (mediador != null && politico != null) {
            mediador.set_inquirido(politico);
        }
    }

    public void perguntar(int tempo, LogSistem log) {
        notificarEleitores(log);
        log.register_log(get_nome() + " (" + get_partido() + ") está falando: PERGUNTA");
        estado = estado.perguntar(tempo, log);
        log.register_log(get_nome() + " encerrou a fala");
    }

    public void replica(int tempo, LogSistem log) {
        notificarEleitores(log);
        log.register_log(get_nome() + " (" + get_partido() + ") está falando: RÉPLICA");
        estado = estado.replica(tempo, log);
        log.register_log(get_nome() + " encerrou a fala");
    }
}
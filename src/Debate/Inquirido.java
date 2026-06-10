package Debate;

import Sistema.LogSistem;
import State.InquiridoResponder;
import State.InquiridoState;


public class Inquirido extends ColaboradorPolitico {

    private InquiridoState estado;

    public Inquirido(String nome, String partido) {
        super(nome, partido);
        this.estado = new InquiridoResponder(microfone);
    }

    private Inquirido(Inquirido original) {
        super(original);
        this.estado = new InquiridoResponder(microfone);
    }

    @Override
    public Inquirido clonar() {
        return new Inquirido(this);
    }

    public void responder(int tempo, LogSistem log) {
        notificarEleitores(log);
        log.register_log(get_nome() + " (" + get_partido() + ") está falando: RESPOSTA");
        estado = estado.responder(tempo, log);
        log.register_log(get_nome() + " encerrou a fala");
    }

    public void treplica(int tempo, LogSistem log) {
        notificarEleitores(log);
        log.register_log(get_nome() + " (" + get_partido() + ") está falando: TRÉPLICA");
        estado = estado.treplica(tempo, log);
        log.register_log(get_nome() + " encerrou a fala");
    }
}
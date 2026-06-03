package Debate;

import Sistema.LogSistem;
import Observer.ObservadorEleitor;
public class Inquirido extends ColaboradorPolitico {

    public Inquirido(String nome, String partido) {
        super(nome, partido);
    }

    public void responder(int tempo, LogSistem log) {
        log.register_log(get_nome() + " está falando: RESPOSTA");
        microfone.liga();
        log.register_log("Microfone aberto para resposta!");

        microfone.passa_tempo(tempo);

        microfone.desliga();
        log.register_log("Tempo de resposta finalizado! Microfone desligado");
        log.register_log(get_nome() + " encerrou a fala");
    }

    public void treplica(int tempo, LogSistem log) {
        log.register_log(get_nome() + " está falando: TRÉPLICA");
        microfone.liga();
        log.register_log("Microfone aberto para treplica!");

        microfone.passa_tempo(tempo);

        microfone.desliga();
        log.register_log("Tempo de treplica finalizado! Microfone desligado");
        log.register_log(get_nome() + " encerrou a fala");
    }
    
}
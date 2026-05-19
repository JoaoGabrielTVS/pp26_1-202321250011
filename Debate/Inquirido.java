package Debate;

import Sistema.LogSistem;
import Observer.ObservadorEleitor;
public class Inquirido extends ColaboradorPolitico {

    public Inquirido(String nome, String partido) {
        super(nome, partido);
    }

    public void responder(int tempo, LogSistem log) {
    	notificarEleitores();
        microfone.liga();
        log.register_log("Microfone aberto para resposta!");
        microfone.passa_tempo(tempo);
        microfone.desliga();
        log.register_log("Tempo de resposta finalizado! Microfone desligado");
    }

    public void treplica(int tempo, LogSistem log) {
    	notificarEleitores();
        microfone.liga();
        log.register_log("Microfone aberto para resposta!");
        microfone.passa_tempo(tempo);
        microfone.desliga();
        log.register_log("Tempo de resposta finalizado! Microfone desligado");
    }
    
}
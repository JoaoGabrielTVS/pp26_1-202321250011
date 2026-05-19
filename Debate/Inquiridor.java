package Debate;

import Sistema.LogSistem;

public class Inquiridor extends ColaboradorPolitico {

    public Inquiridor(String nome, String partido) {
        super(nome, partido);
    }

    public void escolha_inquirido(ColaboradorPolitico politico) {
        if (mediador != null && politico != null) {
            mediador.set_inquirido(politico);
        }
    }

    public void perguntar(int tempo, LogSistem log) {
    	notificarEleitores();
        microfone.liga();
        log.register_log("Microfone aberto para pergunta!");
        microfone.passa_tempo(tempo);
        microfone.desliga();
        log.register_log("Tempo de pergunta finalizado! Microfone desligado");
    }

    public void replica(int tempo, LogSistem log) {
    	notificarEleitores();
        microfone.liga();
        log.register_log("Microfone aberto para pergunta!");
        microfone.passa_tempo(tempo);
        microfone.desliga();
        log.register_log("Tempo de pergunta finalizado! Microfone desligado");
    }
    
}
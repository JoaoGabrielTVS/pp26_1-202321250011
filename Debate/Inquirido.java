package Debate;

import Sistema.LogSistem;

public class Inquirido extends ColaboradorPolitico {

    public Inquirido(String nome, String partido) {
        super(nome, partido);
    }

    public void responder(int tempo, LogSistem log) {
        log.register_log("\n-------------------------");
        microfone.liga();
        log.register_log("Microfone aberto para resposta!");

        // Observer: notifica eleitores ANTES de abrir o microfone
        notificarEleitores(log);

        log.register_log(get_nome() + " (" + get_partido() + ") está falando: RESPOSTA");
        

        microfone.passa_tempo(tempo);

        microfone.desliga();
        log.register_log(get_nome() + " encerrou a fala");
        log.register_log("Tempo de resposta finalizado! Microfone desligado");

        log.register_log("-------------------------");
    }

    public void treplica(int tempo, LogSistem log) {
        log.register_log("\n-------------------------");
        microfone.liga();
        log.register_log("Microfone aberto para treplica!");
        notificarEleitores(log);

        log.register_log(get_nome() + " (" + get_partido() + ") está falando: TRÉPLICA");
       

        microfone.passa_tempo(tempo);

        microfone.desliga();
        log.register_log(get_nome() + " encerrou a fala");
        log.register_log("Tempo de treplica finalizado! Microfone desligado");

        log.register_log("-------------------------");
    }
}
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
        log.register_log("\n-------------------------");
        microfone.liga();
        log.register_log("Microfone aberto para pergunta!");

        // Observer: notifica eleitores ANTES de abrir o microfone
        // O candidato é quem sabe que está falando — o microfone não sabe disso
        notificarEleitores(log);

        log.register_log(get_nome() + " (" + get_partido() + ") está falando: PERGUNTA");
       
        microfone.passa_tempo(tempo);

        microfone.desliga();
        log.register_log(get_nome() + " encerrou a fala");

        log.register_log("Tempo de pergunta finalizado! Microfone desligado");
        log.register_log("-------------------------");
    }

    public void replica(int tempo, LogSistem log) {
        log.register_log("\n-------------------------");
        microfone.liga();
        log.register_log("Microfone aberto para replica!");
        notificarEleitores(log);

        log.register_log(get_nome() + " (" + get_partido() + ") está falando: RÉPLICA");
       

        microfone.passa_tempo(tempo);

        microfone.desliga();
        log.register_log(get_nome() + " encerrou a fala");
        log.register_log("Tempo de replica finalizado! Microfone desligado");
        log.register_log("-------------------------");
    }
}
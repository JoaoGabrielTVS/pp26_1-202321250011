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
        log.register_log(get_nome() + " está falando: PERGUNTA");
        microfone.liga();
        log.register_log("Microfone aberto para pergunta!");

        microfone.passa_tempo(tempo);

        microfone.desliga();
        log.register_log("Tempo de pergunta finalizado! Microfone desligado");
        log.register_log(get_nome() + " encerrou a fala");
    }

    public void replica(int tempo, LogSistem log) {
        log.register_log(get_nome() + " está falando: RÉPLICA");
        microfone.liga();
        log.register_log("Microfone aberto para replica!");

        microfone.passa_tempo(tempo);

        microfone.desliga();
        log.register_log("Tempo de replica finalizado! Microfone desligado");
        log.register_log(get_nome() + " encerrou a fala");
    }
    
}
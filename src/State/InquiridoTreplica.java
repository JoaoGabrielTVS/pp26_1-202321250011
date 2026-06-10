package State;

import Debate.Microfone;
import Sistema.LogSistem;

public class InquiridoTreplica implements InquiridoState {

    private Microfone microfone;

    public InquiridoTreplica(Microfone microfone) {
        this.microfone = microfone;
    }

    @Override
    public InquiridoState responder(int tempo, LogSistem log) {
        log.register_log("[AVISO] Inquirido já realizou a resposta.");
        return this;
    }

    @Override
    public InquiridoState treplica(int tempo, LogSistem log) {
        log.register_log("\n-------------------------");
        microfone.liga();
        log.register_log("Microfone aberto para treplica!");
        microfone.passa_tempo(tempo);
        microfone.desliga();
        log.register_log("Tempo de treplica finalizado! Microfone desligado");
        log.register_log("-------------------------");
        return this;
    }
}
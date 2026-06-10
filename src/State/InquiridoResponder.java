package State;

import Debate.Microfone;
import Sistema.LogSistem;

public class InquiridoResponder implements InquiridoState {

    private Microfone microfone;

    public InquiridoResponder(Microfone microfone) {
        this.microfone = microfone;
    }

    @Override
    public InquiridoState responder(int tempo, LogSistem log) {
        log.register_log("\n-------------------------");
        microfone.liga();
        log.register_log("Microfone aberto para resposta!");
        microfone.passa_tempo(tempo);
        microfone.desliga();
        log.register_log("Tempo de resposta finalizado! Microfone desligado");
        log.register_log("-------------------------");
        return new InquiridoTreplica(microfone);
    }

    @Override
    public InquiridoState treplica(int tempo, LogSistem log) {
        log.register_log("[AVISO] Inquirido ainda não respondeu. Tréplica não permitida.");
        return this;
    }
}
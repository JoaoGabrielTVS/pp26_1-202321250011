package State;

import Debate.Microfone;
import Sistema.LogSistem;

public class InquiridorReplica implements InquiridorState {

    private Microfone microfone;
    
    public InquiridorReplica(Microfone microfone) {
        this.microfone = microfone;
    }

    @Override
    public InquiridorState perguntar(int tempo, LogSistem log) {
        log.register_log("[AVISO] Inquiridor já realizou a pergunta.");
        return this;
    }

    @Override
    public InquiridorState replica(int tempo, LogSistem log) {
        log.register_log("\n-------------------------");
        microfone.liga();
        log.register_log("Microfone aberto para replica!");
        microfone.passa_tempo(tempo);
        microfone.desliga();
        log.register_log("Tempo de replica finalizado! Microfone desligado");
        log.register_log("-------------------------");
        return this;
    }
}
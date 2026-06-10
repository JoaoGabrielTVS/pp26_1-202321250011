package State;

import Debate.Microfone;
import Sistema.LogSistem;

/**
 * Estado inicial do Inquiridor.
 * Responsabilidade única: controlar o microfone durante a pergunta.
 * NÃO sabe nada sobre DR — isso é responsabilidade do MediarDebate.
 */
public class InquiridorPerguntar implements InquiridorState {

    private Microfone microfone;

    public InquiridorPerguntar(Microfone microfone) {
        this.microfone = microfone;
    }

    @Override
    public InquiridorState perguntar(int tempo, LogSistem log) {
        log.register_log("\n-------------------------");
        microfone.liga();
        log.register_log("Microfone aberto para pergunta!");
        microfone.passa_tempo(tempo);
        microfone.desliga();
        log.register_log("Tempo de pergunta finalizado! Microfone desligado");
        log.register_log("-------------------------");
        return new InquiridorReplica(microfone);
    }

    @Override
    public InquiridorState replica(int tempo, LogSistem log) {
        log.register_log("[AVISO] Inquiridor ainda não perguntou. Réplica não permitida.");
        return this;
    }
}
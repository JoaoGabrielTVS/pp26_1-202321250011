package Debate;

import Sistema.ConfiguraTempo;
import Sistema.LogSistem;

public class MediarDebate extends MediadorBase {

    private Inquirido inquirido;
    private Inquiridor inquiridor;

    public void debate(ConfiguraTempo config, LogSistem log) {
        if (inquiridor == null || inquirido == null) {
            log.register_log("Não foi possível iniciar o debate: inquiridor ou inquirido não definido.");
            return;
        }

        log.register_log("Inicio debate");

        inquiridor.perguntar(config.get_temp_pergunta(), log);
        inquirido.responder(config.get_temp_resposta(), log);
        inquiridor.replica(config.get_temp_replica(), log);
        inquirido.treplica(config.get_temp_treplica(), log);

        // CORRIGIDO: apenas register_log aqui
        // O println foi removido — estava causando duplicação no terminal
        log.register_log("\nFim do Debate! Faça um novo sorteio e configure os tempos");
    }

    public void set_inquiridor(ColaboradorPolitico in) {
        this.inquiridor = new Inquiridor(in.get_nome(), in.get_partido());
        this.inquiridor.set_mediador(this);
        this.inquiridor.copiarEleitoresDe(in);
    }

    public void set_inquirido(ColaboradorPolitico inqui) {
        this.inquirido = new Inquirido(inqui.get_nome(), inqui.get_partido());
        this.inquirido.set_mediador(this);
        this.inquirido.copiarEleitoresDe(inqui);
    }

    public Inquiridor get_inquiridor() {
        return inquiridor;
    }

    public Inquirido get_inquirido() {
        return inquirido;
    }
}
package Debate;

import Builder.BuilderInquirido;
import Builder.BuilderInquiridor;
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

        log.register_log("\nFim do Debate! Faça um novo sorteio e configure os tempos");
    }

    
    public void set_inquiridor(ColaboradorPolitico in) {
        BuilderInquiridor builder = new BuilderInquiridor();
        builder.definirColaborador(in);   // Passo 1
        builder.definirMediator(this);    // Passo 2
        builder.definirPapel(true);       // Passo 3
        this.inquiridor = builder.getInquiridor();
    }

    
    public void set_inquirido(ColaboradorPolitico inqui) {
        BuilderInquirido builder = new BuilderInquirido();
        builder.definirColaborador(inqui); // Passo 1
        builder.definirMediator(this);     // Passo 2
        builder.definirPapel(false);       // Passo 3
        this.inquirido = builder.getInquirido();
    }

    public Inquiridor get_inquiridor() {
        return inquiridor;
    }

    public Inquirido get_inquirido() {
        return inquirido;
    }
}
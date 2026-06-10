package Debate;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import Builder.BuilderInquirido;
import Builder.BuilderInquiridor;
import Sistema.ConfiguraTempo;
import Sistema.LogSistem;


public class MediarDebate extends MediadorBase {

    private Inquirido inquirido;
    private Inquiridor inquiridor;

    private List<ColaboradorPolitico> todosPoliticos = new ArrayList<>();

    private Queue<ColaboradorPolitico> filaDR = new LinkedList<>();

    public static final int TEMPO_DR = 60;


    public void debate(ConfiguraTempo config, LogSistem log) {
        if (inquiridor == null || inquirido == null) {
            log.register_log("Não foi possível iniciar o debate: inquiridor ou inquirido não definido.");
            return;
        }

        log.register_log("Inicio debate");

        inquiridor.perguntar(config.get_temp_pergunta(), log);
        sortearBotaoDR(log);

        inquirido.responder(config.get_temp_resposta(), log);
        sortearBotaoDR(log);

        inquiridor.replica(config.get_temp_replica(), log);
        sortearBotaoDR(log);

        inquirido.treplica(config.get_temp_treplica(), log);
        sortearBotaoDR(log);

        log.register_log("\nFim do ciclo! Verificando solicitações de Direito de Resposta...");
    }

    
    private void sortearBotaoDR(LogSistem log) {
        if (todosPoliticos.isEmpty()) return;
        Random random = new Random();

        if (random.nextBoolean()) {
            int indice = random.nextInt(todosPoliticos.size());
            ColaboradorPolitico sorteado = todosPoliticos.get(indice);
            sorteado.ApertarBotao(log);
        }
    }

    
    public void registrarSolicitacaoDR(ColaboradorPolitico solicitante, LogSistem log) {
        if (!filaDR.contains(solicitante)) {
            filaDR.add(solicitante);
            log.register_log("[DR] Solicitação registrada! " + solicitante.get_nome()
                    + " — posição na fila: " + filaDR.size());
        } else {
            log.register_log("[DR] " + solicitante.get_nome() + " já está na fila de DR.");
        }
    }

    public boolean temSolicitacoesDR() {
        return !filaDR.isEmpty();
    }

    public Queue<ColaboradorPolitico> getFilaDR() {
        return new LinkedList<>(filaDR);
    }


    public void processarDireitos(boolean[] concessoes, LogSistem log) {
        if (filaDR.isEmpty()) return;

        log.register_log("\n====== DIREITO DE RESPOSTA ======");
        desabilitarDREmTodos(log);

        List<ColaboradorPolitico> solicitantes = new ArrayList<>(filaDR);
        filaDR.clear();

        for (int i = 0; i < solicitantes.size(); i++) {
            ColaboradorPolitico politico = solicitantes.get(i);

            if (i < concessoes.length && concessoes[i]) {
                log.register_log("\n[DR] CONCEDIDO para: "
                        + politico.get_nome() + " (" + politico.get_partido() + ")");
                politico.notificarEleitoresdeDR(log);
                politico.getMicrofone().liga();
                log.register_log("[DR] Microfone aberto para Direito de Resposta!");
                politico.getMicrofone().passa_tempo(TEMPO_DR);
                politico.getMicrofone().desliga();
                log.register_log("[DR] " + politico.get_nome() + " encerrou sua defesa.");
            } else {
                log.register_log("[DR] NEGADO para: "
                        + politico.get_nome() + " (" + politico.get_partido() + ")");
            }
            politico.getMicrofone().resetarBotao();
        }

        habilitarDREmTodos(log);
        log.register_log("====== FIM DO DR — Debate retoma fluxo normal ======\n");
    }


    public void setTodosPoliticos(List<ColaboradorPolitico> politicos) {
        this.todosPoliticos = new ArrayList<>(politicos);
    }

    private void desabilitarDREmTodos(LogSistem log) {
        log.register_log("[DR] Botão DR desabilitado durante as defesas.");
        for (ColaboradorPolitico p : todosPoliticos) {
            p.getMicrofone().setDrHabilitado(false);
        }
    }

    private void habilitarDREmTodos(LogSistem log) {
        log.register_log("[DR] Botão DR reabilitado.");
        for (ColaboradorPolitico p : todosPoliticos) {
            p.getMicrofone().setDrHabilitado(true);
        }
    }


    public void set_inquiridor(ColaboradorPolitico in) {
        BuilderInquiridor builder = new BuilderInquiridor();
        builder.definirColaborador(in);
        builder.definirMediator(this);
        builder.definirPapel(true);
        this.inquiridor = builder.getInquiridor();
    }

    public void set_inquirido(ColaboradorPolitico inqui) {
        BuilderInquirido builder = new BuilderInquirido();
        builder.definirColaborador(inqui);
        builder.definirMediator(this);
        builder.definirPapel(false);
        this.inquirido = builder.getInquirido();
    }

    public Inquiridor get_inquiridor() { return inquiridor; }
    public Inquirido  get_inquirido()  { return inquirido; }
}
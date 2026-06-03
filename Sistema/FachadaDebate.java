package Sistema;

import Debate.ColaboradorPolitico;
import Debate.MediarDebate;

public class FachadaDebate {
    private static FachadaDebate instance;
    private static ConfiguraTempo config;
    private static MediarDebate mediador;
    private static GerenciaPolitico gerenciador;
    private static LogSistem log;

    private FachadaDebate() {
    }

    public static FachadaDebate get_instance() {
        if (instance == null) {
            instance = new FachadaDebate();
            config = new ConfiguraTempo();
            mediador = new MediarDebate();
            gerenciador = new GerenciaPolitico();
            log = LogSistem.get_instance("debate.log");
            log.register_log("Instancia de log criada");
        }
        return instance;
    }

    public static void configuracao(int pergunta, int resposta, int replica, int treplica) {
        config.set_temp_pergunta(pergunta);
        log.register_log("tempo de pergunta setado " + pergunta);

        config.set_temp_resposta(resposta);
        log.register_log("tempo de resposta setado " + resposta);

        config.set_temp_replica(replica);
        log.register_log("tempo de replica setado " + replica);

        config.set_temp_treplica(treplica);
        log.register_log("tempo de treplica setado " + treplica);
    }

    public static void cadastrar_politicos(String nome, String partido, MediarDebate mediador) {
        gerenciador.criar_politico(nome, partido, mediador);
        log.register_log("Politico " + nome + " do partido " + partido + " foi cadastrado com sucesso!");
    }

    public static void sorteio_inquiridor() {
        ColaboradorPolitico escolhido = gerenciador.sortear_politico();

        if (escolhido == null) {
            log.register_log("Nenhum politico disponível para sorteio.");
            return;
        }

        mediador.set_inquiridor(escolhido);
        log.register_log("Sorteio inquiridor realizado com sucesso. Politico sorteado: "
                + escolhido.get_nome() + " do partido " + escolhido.get_partido());
    }

    public static void escolher_inquirido(String nome, String partido) {
        ColaboradorPolitico escolhido = gerenciador.obter_politico(nome, partido);

        if (escolhido == null) {
            log.register_log("Politico não encontrado: " + nome + " do partido " + partido);
            return;
        }

        if (mediador.get_inquiridor() == null) {
            log.register_log("Inquiridor ainda não foi definido.");
            return;
        }

        mediador.get_inquiridor().escolha_inquirido(escolhido);
        log.register_log("Inquirido escolhido foi " + escolhido.get_nome() + " do partido " + escolhido.get_partido());
    }
    
    public static void listar_politicos_disponiveis() {

        for (ColaboradorPolitico p :
                gerenciador.get_politicos()) {

            System.out.println(
                "- " + p.get_nome()
                + " | "
                + p.get_partido());
        }
    }
    
    public static boolean todos_foram_inquiridores() {

        for (ColaboradorPolitico p :
                gerenciador.get_politicos()) {

            if (!p.get_inquiridor()) {
                return false;
            }
        }

        return true;
    }
    

    public static void executar_debate(ConfiguraTempo config, LogSistem log) {
        mediador.debate(config, log);
    }

    public static ConfiguraTempo get_config() {
        return config;
    }
    public static GerenciaPolitico get_gerenciador() {
        return gerenciador;
    }
    public static LogSistem get_Log() {
        return log;
    }

    public static MediarDebate get_mediador() {
        return mediador;
    }

    public static void acessar_log() {
        System.out.println(log.get_log_register());
    }
}
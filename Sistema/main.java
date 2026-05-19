package Sistema;

import Debate.ColaboradorPolitico;
import Observer.Eleitor;

public class main {

    public static void main(String[] args) {

        // =========================
        // INICIALIZA SISTEMA
        // =========================
        FachadaDebate f = FachadaDebate.get_instance();

        // =========================
        // CONFIGURA TEMPOS
        // =========================
        f.configuracao(10, 15, 5, 5);

        // =========================
        // CADASTRO DOS POLÍTICOS
        // =========================
        f.cadastrar_politicos( "CanetaAzul","Republicanos",f.get_mediador());

        f.cadastrar_politicos(
                "Alberto",
                "Uniao",
                f.get_mediador());
        f.cadastrar_politicos(
                "Lula",
                "PL",
                f.get_mediador());
        f.cadastrar_politicos(
                "Bolsonaro",
                "PT",
                f.get_mediador());
        // =========================
        // OBTÉM OS POLÍTICOS
        // =========================
        ColaboradorPolitico canetaAzul = f.get_gerenciador().obter_politico("CanetaAzul", "Republicanos");

        ColaboradorPolitico alberto = f.get_gerenciador().obter_politico("Alberto", "Uniao");
        ColaboradorPolitico Lula = f.get_gerenciador().obter_politico("Lula", "PL");
        ColaboradorPolitico Bolsonaro = f.get_gerenciador().obter_politico("Bolsonaro", "PT");

        // =========================
        // CRIA ELEITORES (OBSERVER)
        // =========================
        Eleitor e1 = new Eleitor("Joao", canetaAzul);
        Eleitor e2 = new Eleitor("Maria", canetaAzul);
        Eleitor e3 = new Eleitor("Pedro", alberto);

        // =========================
        // REGISTRA ELEITORES
        // =========================
        canetaAzul.adicionarEleitor(e1);
        canetaAzul.adicionarEleitor(e2);

        alberto.adicionarEleitor(e3);

        // =========================
        // DEFINE INQUIRIDOR
        // =========================
        f.sorteio_inquiridor();

        // =========================
        // DEFINE INQUIRIDO
        // =========================
        f.escolher_inquirido(
                "Alberto",
                "Uniao");

        // =========================
        // EXECUTA DEBATE
        // =========================
        f.executar_debate(
                f.get_config(),
                f.get_Log());

        // =========================
        // MOSTRA LOG
        // =========================
        System.out.println("\n===== LOG DO SISTEMA =====\n");

        f.acessar_log();
    }
}
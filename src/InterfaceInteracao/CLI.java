package InterfaceInteracao;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import Debate.ColaboradorPolitico;
import Observer.Eleitor;
import Sistema.FachadaDebate;

public class CLI {

    private FachadaDebate f;

    public void RealizarOperacao() {
        Scanner sc = new Scanner(System.in);

        FachadaDebate f = FachadaDebate.get_instance();
        f.configuracao(10, 15, 5, 5);

        f.cadastrar_politicos("CanetaAzul", "Republicanos", f.get_mediador());
        f.cadastrar_politicos("Alberto",    "Uniao",        f.get_mediador());
        f.cadastrar_politicos("Roberto",    "PT",           f.get_mediador());

        ColaboradorPolitico caneta  = f.get_gerenciador().obter_politico("CanetaAzul", "Republicanos");
        ColaboradorPolitico alberto = f.get_gerenciador().obter_politico("Alberto",    "Uniao");
        ColaboradorPolitico roberto = f.get_gerenciador().obter_politico("Roberto",    "PT");

        Eleitor e1 = new Eleitor("Joao",  caneta);
        Eleitor e2 = new Eleitor("Maria", caneta);
        Eleitor e3 = new Eleitor("Pedro", alberto);
        Eleitor e4 = new Eleitor("Lucas", roberto);

        caneta.adicionarEleitor(e1);
        caneta.adicionarEleitor(e2);
        alberto.adicionarEleitor(e3);
        roberto.adicionarEleitor(e4);

        f.get_Log().ativarTerminal();

        while (!f.todos_foram_inquiridores()) {

            System.out.println("\n=========================");
            System.out.println("NOVO DEBATE");
            System.out.println("=========================");

            f.sorteio_inquiridor();

            System.out.println("\nEscolha o inquirido:");
            f.listar_politicos_disponiveis();

            System.out.print("\nDigite o nome do candidato: ");
            String nome = sc.nextLine();
            System.out.print("Digite o partido: ");
            String partido = sc.nextLine();

            f.escolher_inquirido(nome, partido);

            // Executa debate — DR é sorteado automaticamente durante as falas
            f.executar_debate(f.get_config(), f.get_Log());

            // ── APÓS CICLO COMPLETO: GERENTE DECIDE OS DRs ──
            if (f.temSolicitacoesDR()) {
                System.out.println("\n=== SOLICITAÇÕES DE DIREITO DE RESPOSTA ===");

                Queue<ColaboradorPolitico> fila = f.getFilaDR();
                List<ColaboradorPolitico> solicitantes = new ArrayList<>(fila);
                boolean[] concessoes = new boolean[solicitantes.size()];

                for (int i = 0; i < solicitantes.size(); i++) {
                    ColaboradorPolitico p = solicitantes.get(i);
                    System.out.print("Conceder DR para " + p.get_nome()
                            + " (" + p.get_partido() + ")? [S/N]: ");
                    String resposta = sc.nextLine().trim().toUpperCase();
                    concessoes[i] = resposta.equals("S");
                }

                f.processarDireitos(concessoes);

            } else {
                System.out.println("\n[DR] Nenhuma solicitação de DR neste ciclo.");
            }
        }

        System.out.println("\n==================================");
        System.out.println("TODOS OS DEBATES FORAM FINALIZADOS");
        System.out.println("==================================");
        System.out.println("\n===== LOG COMPLETO =====\n");
        f.acessar_log();

        sc.close();
    }
}
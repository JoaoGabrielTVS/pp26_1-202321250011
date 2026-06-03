package InterfaceInteracao;

import java.util.Scanner;

import Debate.ColaboradorPolitico;
import Observer.Eleitor;
import Sistema.FachadaDebate;

public class CLI {
	private FachadaDebate f;
	public void RealizarOperacao() {
		 Scanner sc = new Scanner(System.in);

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
	        f.cadastrar_politicos("CanetaAzul", "Republicanos", f.get_mediador());
	        f.cadastrar_politicos("Alberto", "Uniao", f.get_mediador());
	        f.cadastrar_politicos("Roberto", "PT", f.get_mediador());

	        // =========================
	        // OBTÉM POLÍTICOS
	        // =========================
	        ColaboradorPolitico caneta  = f.get_gerenciador().obter_politico("CanetaAzul", "Republicanos");
	        ColaboradorPolitico alberto = f.get_gerenciador().obter_politico("Alberto", "Uniao");
	        ColaboradorPolitico roberto = f.get_gerenciador().obter_politico("Roberto", "PT");

	        // =========================
	        // ELEITORES
	        // =========================
	        Eleitor e1 = new Eleitor("Joao",  caneta);
	        Eleitor e2 = new Eleitor("Maria", caneta);
	        Eleitor e3 = new Eleitor("Pedro", alberto);
	        Eleitor e4 = new Eleitor("Lucas", roberto);

	        caneta.adicionarEleitor(e1);
	        caneta.adicionarEleitor(e2);
	        alberto.adicionarEleitor(e3);
	        roberto.adicionarEleitor(e4);

	        // =========================
	        // ATIVA LOG EM TEMPO REAL
	        // Todo o setup acima ficou limpo no terminal.
	        // A partir daqui, tudo que for registrado no log também imprime.
	        // =========================
	        f.get_Log().ativarTerminal();

	        // =========================
	        // LOOP PRINCIPAL
	        // =========================
	        while (!f.todos_foram_inquiridores()) {

	            System.out.println("\n=========================");
	            System.out.println("NOVO DEBATE");
	            System.out.println("=========================");

	            // SORTEIA INQUIRIDOR
	            f.sorteio_inquiridor();

	            // ESCOLHA DO INQUIRIDO
	            System.out.println("\nEscolha o inquirido:");
	            f.listar_politicos_disponiveis();

	            System.out.print("\nDigite o nome do candidato: ");
	            String nome = sc.nextLine();

	            System.out.print("Digite o partido: ");
	            String partido = sc.nextLine();

	            // DEFINE INQUIRIDO
	            f.escolher_inquirido(nome, partido);

	            // EXECUTA DEBATE
	            f.executar_debate(f.get_config(), f.get_Log());
	        }

	        // =========================
	        // FINALIZAÇÃO
	        // =========================
	        System.out.println("\n==================================");
	        System.out.println("TODOS OS DEBATES FORAM FINALIZADOS");
	        System.out.println("==================================");

	        System.out.println("\n===== LOG COMPLETO (HISTÓRICO DE TODOS OS DEBATES) =====\n");

	        // Imprime o histórico completo — inclui setup + todos os ciclos
	        f.acessar_log();

	        sc.close();
		
	}
}

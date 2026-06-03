package Sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Debate.ColaboradorPolitico;
import Debate.MediarDebate;

public class GerenciaPolitico {
    private List<ColaboradorPolitico> politicos;
    private static int quant_politicos = 0;

    public GerenciaPolitico() {
        this.politicos = new ArrayList<>(); // não pode recriar a cada cadastro
    }
    public List<ColaboradorPolitico> get_politicos() {
        return politicos;
    }

    public void criar_politico(String nome, String partido, MediarDebate mediador) {
        ColaboradorPolitico novo_politico = new ColaboradorPolitico(nome, partido);
        novo_politico.set_mediador(mediador);
        politicos.add(novo_politico);
        quant_politicos++;
    }

    public ColaboradorPolitico obter_politico(String nome, String partido) {
        for (ColaboradorPolitico politico : politicos) {
            if (politico.get_nome().equals(nome) && politico.get_partido().equals(partido)) {
                return politico;
            }
        }
        return null;
    }

    public ColaboradorPolitico sortear_politico() {
        if (politicos.isEmpty()) {
            return null;
        }

        Random random = new Random();
        ColaboradorPolitico politico;

        do {
            int indice = random.nextInt(politicos.size());
            politico = politicos.get(indice);
        } while (politico.get_inquiridor() && quant_politicos >= 2);

        if (quant_politicos >= 2) {
            politico.set_inquiridor(true);
            quant_politicos--;
        } else {
            for (ColaboradorPolitico p : politicos) {
                if (!p.get_inquiridor()) {
                    p.set_inquiridor(true);
                    return p;
                }
            }
        }

        return politico;
    }
}
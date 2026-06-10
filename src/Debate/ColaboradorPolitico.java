package Debate;

import java.util.ArrayList;
import java.util.List;

import Observer.ObservadorEleitor;
import Prototype.PrototypeColaborador;
import Sistema.LogSistem;


public class ColaboradorPolitico implements PrototypeColaborador {

    private String nome;
    private String partido;
    private boolean inquiridor;
    protected Microfone microfone;
    protected MediarDebate mediador;

    private List<ObservadorEleitor> eleitores;

    public ColaboradorPolitico(String nome, String partido) {
        this.nome = nome;
        this.partido = partido;
        this.inquiridor = false;
        this.microfone = new Microfone();
        this.eleitores = new ArrayList<>();
    }

    protected ColaboradorPolitico(ColaboradorPolitico original) {
        this.nome       = original.nome;
        this.partido    = original.partido;
        this.inquiridor = original.inquiridor;
        this.microfone  = new Microfone();
        this.eleitores  = new ArrayList<>(original.eleitores);
        this.mediador   = null;
    }

    @Override
    public ColaboradorPolitico clonar() {
        return new ColaboradorPolitico(this);
    }


    public void ApertarBotao(LogSistem log) {
        if (mediador == null) return;

        boolean clicouComSucesso = microfone.Ativar_Botao();

        if (clicouComSucesso) {
            log.register_log("[DR] " + nome + " (" + partido + ") pressionou o botão DR!");
            mediador.registrarSolicitacaoDR(this, log);
        } else {
            log.register_log("[DR] " + nome + " tentou pressionar DR, mas o botão está desabilitado.");
        }
    }

    // ── Observer ────────────────────────────────────────────

    public void adicionarEleitor(ObservadorEleitor eleitor) {
        eleitores.add(eleitor);
    }

    public void removerEleitor(ObservadorEleitor eleitor) {
        eleitores.remove(eleitor);
    }

    protected void notificarEleitores(LogSistem log) {
        for (ObservadorEleitor eleitor : eleitores) {
            eleitor.atualizar("SEU CANDIDATO ESTÁ FALANDO: " + nome, log);
        }
    }

    public void notificarEleitoresdeDR(LogSistem log) {
        for (ObservadorEleitor eleitor : eleitores) {
            eleitor.atualizar("SEU CANDIDATO ESTÁ EXERCENDO DIREITO DE RESPOSTA: " + nome, log);
        }
    }

    public void copiarEleitoresDe(ColaboradorPolitico outro) {
        this.eleitores.addAll(outro.eleitores);
    }

    // ── Getters / Setters ────────────────────────────────────

    public void set_mediador(MediarDebate mediador) {
        this.mediador = mediador;
    }

    public void set_inquiridor(boolean politico) {
        this.inquiridor = politico;
    }

    public Microfone getMicrofone() {
        return microfone;
    }

    public String get_nome()          { return nome; }
    public String get_partido()       { return partido; }
    public boolean get_inquiridor()   { return inquiridor; }
}
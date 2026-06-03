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
        this.nome      = original.nome;
        this.partido   = original.partido;
        this.inquiridor = original.inquiridor;
        this.microfone = new Microfone();                        // novo microfone
        this.eleitores = new ArrayList<>(original.eleitores);   // copia a lista
        this.mediador  = null;                                   // será atribuído depois
    }

   
    @Override
    public ColaboradorPolitico clonar() {
        return new ColaboradorPolitico(this);
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

    public void copiarEleitoresDe(ColaboradorPolitico outro) {
        this.eleitores.addAll(outro.eleitores);
    }

    // ── Getters / Setters ───────────────────────────────────

    public void set_mediador(MediarDebate mediador) {
        this.mediador = mediador;
    }

    public void set_inquiridor(boolean politico) {
        this.inquiridor = politico;
    }

    public String get_nome()      { return nome; }
    public String get_partido()   { return partido; }
    public boolean get_inquiridor() { return inquiridor; }
}
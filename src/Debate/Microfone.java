package Debate;

import Sistema.LogSistem;


public class Microfone {

    public boolean MicroAtivo;
    public boolean Botao_Estado = true; // botão DR começa habilitado

    public void liga() {
        this.MicroAtivo = true;
    }

    public void desliga() {
        this.MicroAtivo = false;
    }

    public void passa_tempo(int tempo) {
        while (tempo != 0) {
            tempo--;
        }
    }

 
    public boolean Ativar_Botao() {
        return Botao_Estado;
    }

   
    public void setDrHabilitado(boolean habilitado) {
        this.Botao_Estado = habilitado;
    }

    public void resetarBotao() {
        this.Botao_Estado = true;
    }
}
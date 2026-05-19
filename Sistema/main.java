package Sistema;

import java.util.Scanner;

import Debate.ColaboradorPolitico;
import InterfaceInteracao.CLI;
import InterfaceInteracao.GUI;
import Observer.Eleitor;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Escolha por onde acessar interface GUI ou CLI");
        CLI cli = new CLI();
        String escolha = sc.nextLine();
        if(escolha == "CLI")
        	cli.RealizarOperacao();
        else
        	cli.RealizarOperacao();
        	
        
        
        sc.close();
    }
}
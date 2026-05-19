package Debate;

public class Microfone {
	
	public boolean MicroAtivo;
	
	public void liga() {
		this.MicroAtivo = true;
		
	}
	public void desliga() {
		this.MicroAtivo = false;
	}
	public void passa_tempo(int tempo) {
		while(tempo!=0) {
			tempo -- ;
		}
	}

}

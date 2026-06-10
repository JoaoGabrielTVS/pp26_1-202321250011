package Sistema;

public class ConfiguraTempo {
	private int tempo_pergunta; 
	private int tempo_resposta; 

	private int tempo_replica; 

	private int tempo_treplica; 

	 public ConfiguraTempo() {
		 
	 }
	 
	 public void set_temp_pergunta(int t) {
		 tempo_pergunta = t;
	 }
	 public int get_temp_pergunta() {
		return tempo_pergunta;
		 
	 	}
	 
	 public void set_temp_resposta(int t) {
			 tempo_resposta = t;
		 }
		 public int get_temp_resposta() {
			return tempo_resposta;
			 
		 }
	 public void set_temp_replica(int t) {
			 tempo_replica = t;
		 }
		 public int get_temp_replica() {
			return tempo_replica;
			 
		 }
	 public void set_temp_treplica(int t) {
			 tempo_treplica = t; 
		 }
		 public int get_temp_treplica() {
			return tempo_treplica;
			 
		 }
}
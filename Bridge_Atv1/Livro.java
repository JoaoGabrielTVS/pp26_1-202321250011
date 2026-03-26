package main.Bridge_Atv1;

public class Livro extends Publicacao{
	public Livro(Implementador imp ) {
		this.imp = imp;
	}
	
	public String getISBN() {
		
		return  "ISB";
	}
	@Override
	public String getTitulo() {
			
			return  "Titulo";
		}
	@Override
	public String getAutor() {
		
		return  "Tolkien";
	}
	

	
}

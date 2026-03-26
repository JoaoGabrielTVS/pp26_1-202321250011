package main.Bridge_Atv1;

public abstract class Publicacao{
	protected Implementador imp;
	
	public String obterDados() {
	
		return imp.getDados(this);
	}
	public abstract String getTitulo();
	public abstract String getAutor();
	

	
	
}











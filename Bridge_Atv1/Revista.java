package main.Bridge_Atv1;

public class Revista extends Publicacao{
	public Revista(Implementador imp) {
		this.imp = imp;
	}
	public String getArtigo() {
		return "Artigo";
	}
	@Override
	public String getTitulo() {
		// TODO Auto-generated method stub
		return "titulo";
	}

	@Override
	public String getAutor() {
		// TODO Auto-generated method stub
		return "autor";
	}
	

}

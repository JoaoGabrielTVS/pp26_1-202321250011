package main.Bridge_Atv1;

public class main {
	public static void main(String[] args) {
		
		
		
		Livro  livro1 = new  Livro(new PublicacaoImplXML());
		System.out.println(livro1.getAutor());
		System.out.println(livro1.getTitulo());
		System.out.println(livro1.obterDados());
		System.out.println(livro1.getISBN());

		
		Revista artigo = new Revista(new PublicacaoImplXML());		
		System.out.println(artigo.getAutor());
		System.out.println(artigo.getTitulo());
		System.out.println(artigo.obterDados());
		System.out.println(artigo.getArtigo());

		
		
	}
}

package br.com.fametro.disciplina.util;

public final class GeradorId {
	private static int id = 0;
	public GeradorId() {
		
	}
	
	public static int gerarId(){
		id++;
		return id;
	}
	public static int gerarMatricula(){
		return (int)  (Math.random()*999999999);
	}
}

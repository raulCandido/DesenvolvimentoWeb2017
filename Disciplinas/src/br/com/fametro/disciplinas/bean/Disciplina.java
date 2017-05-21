package br.com.fametro.disciplinas.bean;

public class Disciplina {

	private int id;
	private String nomeDisciplina;
	private String CargaHoraria;
	private String Material;
	private String Livros;
	private String Ementa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisciplina() {
		return nomeDisciplina;
	}

	public void setDisciplina(String disciplina) {
		this.nomeDisciplina = disciplina;
	}

	public String getCargaHoraria() {
		return CargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		CargaHoraria = cargaHoraria;
	}

	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		Material = material;
	}

	public String getLivros() {
		return Livros;
	}

	public void setLivros(String livros) {
		Livros = livros;
	}

	public String getEmenta() {
		return Ementa;
	}

	public void setEmenta(String ementa) {
		Ementa = ementa;
	}

}

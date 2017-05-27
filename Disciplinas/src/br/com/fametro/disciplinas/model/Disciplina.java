package br.com.fametro.disciplinas.model;

public class Disciplina {

	private int id;
	private String nomeDisciplina;
	private int CargaHoraria;
	private String Material;
	private String Livros;
	private String Ementa;

	public int getId() {
		return id;
	}
	public Disciplina(String nomeDisciplina, int cargaHoraria, String ementa) {
		setNomeDisciplina(nomeDisciplina);
		setCargaHoraria(cargaHoraria);
		setEmenta(ementa);
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

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public int getCargaHoraria() {
		return CargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		CargaHoraria = cargaHoraria;
	}

}

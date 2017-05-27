package br.com.fametro.disciplinas.exception;

import java.util.ArrayList;
import java.util.List;

public final class Erro {
	private final List<String> erros;

	public Erro() {
		erros = new ArrayList<>();
	}

	public Erro(String msg) {
		erros = new ArrayList<>();
		erros.add(msg);
	}

	public void addErro(String msg) {
		erros.add(msg);
	}

	public List<String> getErros() {
		return erros;
	}

	public boolean isExisteErro() {
		return !erros.isEmpty();
	}
}

package com.gcb.testbackend.viacep;

public class Endereco {
	String complemento;
	String bairro;
	String logradouro;
	String localidade;
	String uf;

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public String getUf() {
		return uf;
	}

	@Override
	public String toString() {
		return "Endereco{" + "logradouro=" + logradouro + ", bairro=" + bairro + ", localidade=" + localidade + '}';
	}
}

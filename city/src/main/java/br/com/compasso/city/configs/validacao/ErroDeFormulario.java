package br.com.compasso.city.configs.validacao;

public class ErroDeFormulario {
	private String  campo;
	private String  erro;
	
	public ErroDeFormulario(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}
	
	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}

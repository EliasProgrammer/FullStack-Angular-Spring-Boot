package com.workproject.algamoney.api.resource.exception;

import java.io.Serializable;

/**
 * Classe para para armazezar o Campo e a Mensagem de validação do Bean validation.
 * @author Elias
 *
 */
public class FieldMessage implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 2083518955380208793L;
	
	private String nomeCampo;
	private String mensagem;

	
	public FieldMessage() {	}
	
	public FieldMessage(String nomeCampo, String mensagem) {
		super();
		this.nomeCampo = nomeCampo;
		this.mensagem = mensagem;
	}

	public String getNomeCampo() {
		return nomeCampo;
	}


	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}

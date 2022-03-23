package com.dbc.pessoaapi.exceptions;

public class RegraDeNegocioException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4289109216519725837L;

	public RegraDeNegocioException(String mensagem){
        super(mensagem);
    }
}

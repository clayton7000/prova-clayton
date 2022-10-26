package com.apivenda.demo.exception;

public class ClienteNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);

    }

    public ClienteNaoEncontradoException(Integer clienteId) {
        this(String.format("Cliente não encontrado %d", clienteId));
    }
}

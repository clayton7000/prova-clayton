package com.apivenda.demo.exception;

public class ProdutoNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public ProdutoNaoEncontradoException(String mensagem) {
        super(mensagem);

    }

    public ProdutoNaoEncontradoException(Integer produtoId) {
        this(String.format("Não existe Produto cadastrado %d", produtoId));
    }
}

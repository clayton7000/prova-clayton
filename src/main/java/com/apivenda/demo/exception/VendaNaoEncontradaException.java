package com.apivenda.demo.exception;

public class VendaNaoEncontradaException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public VendaNaoEncontradaException(String mensagem) {
        super(mensagem);

    }

    public VendaNaoEncontradaException(Integer vendasId) {
        this(String.format("Venda não encontrada %d", vendasId));
    }
}

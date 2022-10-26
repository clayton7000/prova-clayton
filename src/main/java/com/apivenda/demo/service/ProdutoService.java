package com.apivenda.demo.service;

import com.apivenda.demo.exception.ProdutoNaoEncontradoException;
import com.apivenda.demo.model.Produto;
import com.apivenda.demo.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Produto getById(Integer produtoId) {
        Optional<Produto> objProduto = produtoRepository.findById(produtoId);
        return objProduto.orElseThrow(() -> new ProdutoNaoEncontradoException(produtoId));

    }

    public Produto getByAll(Integer produtoId) {
        Optional<Produto> objProduto = produtoRepository.findById(produtoId);
        return objProduto.orElseThrow(() -> new ProdutoNaoEncontradoException(produtoId));

    }

    @Transactional
    public Produto insert(Produto produto) {
        return produtoRepository.save(produto);
    }
    @Transactional
    public Produto update(Integer produtoId, Produto produto) {
        Produto produtoAtual = getById(produtoId);
        produtoAtual.setNome(produto.getNome());
        produtoAtual.setValor(produto.getValor());
        return produtoRepository.save(produto);
    }
    
    @Transactional
    public void delete(Integer produtoId) {
        getById(produtoId);
        produtoRepository.deleteById(produtoId);
    }

}

package com.apivenda.demo.service;

import com.apivenda.demo.exception.VendaNaoEncontradaException;
import com.apivenda.demo.model.Produto;
import com.apivenda.demo.model.Venda;
import com.apivenda.demo.repository.ProdutoRepository;
import com.apivenda.demo.repository.VendaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteService clienteService;

    public List<Venda> getAll() {
        return vendaRepository.findAll();
    }

    public Venda getById(Integer vendasId) {
        Optional<Venda> objVendas = vendaRepository.findById(vendasId);
        return objVendas.orElseThrow(() -> new VendaNaoEncontradaException(vendasId));
    }

    @Transactional
    public Venda insert(Venda venda) {

        if (venda.getProduto() != null && !venda.getProduto().isEmpty()) {
            List<Produto> produtos = new ArrayList<Produto>();

            for (Produto produto : venda.getProduto()) {
                produtos.add(produtoRepository.save(produto));

            }

            venda.setProduto(produtos);
        }
        return vendaRepository.save(venda);
    }

    @Transactional
    public Venda update(Integer vendaId, Venda venda) {
        Venda vendasAtual = getById(vendaId);

        vendasAtual.setDataEntrega(venda.getDataEntrega());

        return vendaRepository.save(venda);

    }
    
    @Transactional
    public void delete(Integer vendasId) {
        getById(vendasId);
        vendaRepository.deleteById(vendasId);
    }

}

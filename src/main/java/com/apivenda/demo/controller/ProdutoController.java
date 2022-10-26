package com.apivenda.demo.controller;

import com.apivenda.demo.model.Produto;
import com.apivenda.demo.service.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAll() {
        return produtoService.getAll();
    }

    @GetMapping(value = "/{produtoId}")
    public ResponseEntity<Produto> getById(@PathVariable Integer produtoId) {
        Produto produto = produtoService.getById(produtoId);
        return ResponseEntity.ok().body(produto);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto insert(@RequestBody Produto produto) {
        return produtoService.insert(produto);
    }

    @PutMapping(value = "/{produtoId}")
    public Produto update(@PathVariable Integer produtoId, @RequestBody Produto produto) {
        return produtoService.update(produtoId, produto);
    }

    @DeleteMapping(value = "/{produtoId}")
    public ResponseEntity<Void> delete(@PathVariable Integer produtoId) {
        produtoService.delete(produtoId);
        return ResponseEntity.noContent().build();
    }
}

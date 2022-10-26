package com.apivenda.demo.controller;

import com.apivenda.demo.model.Venda;
import com.apivenda.demo.service.VendaService;
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
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> getAll() {
        return vendaService.getAll();
    }

    @GetMapping(value = "/{vendaId}")
    public ResponseEntity<Venda> getById(@PathVariable Integer vendaId) {
        Venda venda = vendaService.getById(vendaId);
        return ResponseEntity.ok().body(venda);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Venda insert(@RequestBody Venda venda) {
        return vendaService.insert(venda);
    }

    @PutMapping(value = "/{vendaId}")
    public Venda update(@PathVariable Integer vendaId, @RequestBody Venda venda) {
        return vendaService.update(vendaId, venda);
    }

    @DeleteMapping(value = "/{vendaId}")
    public ResponseEntity<Void> delete(@PathVariable Integer vendaId) {
        vendaService.delete(vendaId);
        return ResponseEntity.noContent().build();
    }
}

package com.apivenda.demo.controller;

import com.apivenda.demo.model.Cliente;
import com.apivenda.demo.service.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAll() {
        return clienteService.getAll();
    }

    @GetMapping(value = "/{clienteId}")
    public ResponseEntity<Cliente> getById(@PathVariable Integer clienteId) {
        Cliente cliente = clienteService.getById(clienteId);
        return ResponseEntity.ok().body(cliente);

    }

    @PostMapping    
    public Cliente insert(@RequestBody Cliente cliente) {
        return clienteService.insert(cliente);
    }

    @PutMapping(value = "/{clienteId}")
    public Cliente update(@PathVariable Integer clienteId, @RequestBody Cliente cliente) {
        return clienteService.update(clienteId, cliente);
    }

    @DeleteMapping(value = "/{clienteId}")
    public ResponseEntity<Void> delete(@PathVariable Integer clienteId) {
        clienteService.delete(clienteId);
        return ResponseEntity.noContent().build();
    }
}

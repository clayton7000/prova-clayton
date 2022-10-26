package com.apivenda.demo.service;

import com.apivenda.demo.exception.ClienteNaoEncontradoException;
import com.apivenda.demo.model.Cliente;
import com.apivenda.demo.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente getById(Integer clienteId) {
        Optional<Cliente> objCliente = clienteRepository.findById(clienteId);
        return objCliente.orElseThrow(() -> new ClienteNaoEncontradoException(clienteId));
    }

    @Transactional
    public Cliente insert(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente update(Integer clienteId, Cliente cliente) {
        Cliente clienteAtual = getById(clienteId);
        clienteAtual.setNome(cliente.getNome());
        clienteAtual.setCpf(cliente.getCpf());
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void delete(Integer clienteId) {
        getById(clienteId);
        clienteRepository.deleteById(clienteId);
    }   

}

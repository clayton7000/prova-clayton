/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apivenda.demo.repository;

import com.apivenda.demo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author clayt
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}

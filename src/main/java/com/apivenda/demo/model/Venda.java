package com.apivenda.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(updatable = false)
    @NotNull
    private LocalDate dataCompra;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEntrega;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "venda_produto", uniqueConstraints = @UniqueConstraint(columnNames = {"venda_id",
        "produto_id"}, name = "unique_produto_venda"), joinColumns = @JoinColumn(name = "venda_id", referencedColumnName = "id", table = "venda"),
            inverseJoinColumns = @JoinColumn(name = "produto_id", referencedColumnName = "id", table = "produto"))
    private List<Produto> produto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public LocalDate getDataCompra() {
        return dataCompra;
    }
    
    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
    
    public Venda() {
        
        this.setDataCompra(LocalDate.now());
        this.setDataEntrega(prazoEntrega());

    }

    public LocalDate prazoEntrega() {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(Date.from(this.getDataCompra().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        gc.add(Calendar.DAY_OF_MONTH, 10);

        Date dataUtil = gc.getTime();
        LocalDate dataEntrega = dataUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return dataEntrega;
    }  

}

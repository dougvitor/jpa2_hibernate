package br.com.caelum.financas.modelo;

import javax.persistence.*;
import java.util.List;

/**
 * Created by leonardocordeiro on 24/02/17.
 */

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable=false)
    private String titular;
    
    @Column(nullable=false)
    private String banco;
    
    @Column(nullable=false)
    private String agencia;
    
    @Column(nullable=false)
    private String numero;
    
    @OneToOne(mappedBy="conta")
    @JoinColumn(unique=true)
    private Cliente cliente;

    @OneToMany(mappedBy = "conta")
    private List<Movimentacao> movimentacoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void setMovimentacoes(List<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}

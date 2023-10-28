package nf.notafiscalprojeto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notafiscal")
    private long id;

    @Column(name = "numero_nota")
    @NotNull
    private String numeroNota;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_emissao")
    @NotNull
    private LocalDate dataEmissao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_de_vencimento")
    @NotNull
    private LocalDate dataDeVencimento;

    @Column(name = "valor_nota")
    @NotNull
    private double valorNota;

    @Column(name = "status")
    @NotNull
    private String status;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @Column(name = "forma_de_pagamento")
    @NotNull
    private String formaDePagamento;

    public NotaFiscal() {}

    public NotaFiscal(String numeroNota, LocalDate dataEmissao, LocalDate dataDeVencimento, double valorNota, String status, String formaDePagamento, Fornecedor fornecedor) {
        this.numeroNota = numeroNota;
        this.dataEmissao = dataEmissao;
        this.dataDeVencimento = dataDeVencimento;
        this.valorNota = valorNota;
        this.status = status;
        this.fornecedor = fornecedor;


        this.formaDePagamento = formaDePagamento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(String numeroNota) {
        this.numeroNota = numeroNota;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public double getValorNota() {
        return valorNota;
    }

    public void setValorNota(double valorNota) {
        this.valorNota = valorNota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }


}

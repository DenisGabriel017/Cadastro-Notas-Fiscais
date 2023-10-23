package nf.notafiscalprojeto.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notafiscal")
    private long id;
    private String numeroNota;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_emissao")
    private LocalDate dataEmissao;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_de_vencimento")
    private LocalDate dataDeVencimento;
    @Column(name = "valor_nota")
    private double valorNota;
    @Column(name = "status")
    private String status;
    private String fornecedor;
    private String formaDePagamento;
    public NotaFiscal(){

    }
    public NotaFiscal(String numeroNota, LocalDate dataEmissao, LocalDate dataDeVencimento, double valorNota, String status, String fornecedor, String formaDePagamento) {
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

    public LocalDate getDataEmissão() {
        return dataEmissao;
    }

    public void setDataEmissão(LocalDate dataEmissão) {
        this.dataEmissao = dataEmissão;
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

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
}

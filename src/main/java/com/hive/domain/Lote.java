package com.hive.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "lote")
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estoque", nullable = false)
    private Estoque estoque;

    @Column(name = "tipo_item")
    private String tipoItem;

    private Integer quantidade;

    @Column(name = "dt_entrada")
    private LocalDate dtEntrada;

    @Column(name = "dt_validade")
    private LocalDate dtValidade;

    private String descricao;

    public Lote() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estoque getEstoque() { return estoque; }
    public void setEstoque(Estoque estoque) { this.estoque = estoque; }

    public String getTipoItem() { return tipoItem; }
    public void setTipoItem(String tipoItem) { this.tipoItem = tipoItem; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public LocalDate getDtEntrada() { return dtEntrada; }
    public void setDtEntrada(LocalDate dtEntrada) { this.dtEntrada = dtEntrada; }

    public LocalDate getDtValidade() { return dtValidade; }
    public void setDtValidade(LocalDate dtValidade) { this.dtValidade = dtValidade; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}

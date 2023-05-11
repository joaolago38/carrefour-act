package br.com.carrefour.lancamento.modelo;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "lancamento")
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "descricaoLancamento")
    private String descricaoLancamento;
    @Column(name = "tipoLancamento")
    private String tipoLancamento;
    @Column(name = "datalancamento")
    private String dataLancamento;
    @Column(name = "horarioLancamento")
    private String horarioLacmento;

    public Lancamento(Integer id, String descricaoLancamento, String tipoLancamento, String dataLancamento, String horarioLacmento) {
        this.id = id;
        this.descricaoLancamento = descricaoLancamento;
        this.tipoLancamento = tipoLancamento;
        this.dataLancamento = dataLancamento;
        this.horarioLacmento = horarioLacmento;
    }

    public Lancamento(){

    }
}

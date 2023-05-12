package br.com.carrefour.lancamento.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LancamentoDTO {
    private Integer id;
    private String descricaoLancamento;
    private String tipoLancamento;
    private String dataLancamento;
    private String horarioLancamento;
    private Integer valorLancado;
    private Integer valorConsolidado;

}

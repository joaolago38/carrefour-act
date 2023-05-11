package br.com.carrefour.lancamento.modelo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private String descricãoLancamento;
    @Column(name = "tipoLancamento")
    private String tipoLancamento;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "data_lancamento")
    private LocalDateTime dataLancamento;

    private String horarioLançamento;

    public Lancamento(Integer id,
                      String descricãoLancamento,
                      String tipoLancamento,
                      LocalDateTime dataLancamento,
                      String horarioLançamento) {
        this.id = id;
        this.descricãoLancamento = descricãoLancamento;
        this.tipoLancamento = tipoLancamento;
        this.dataLancamento = dataLancamento;
        this.horarioLançamento = horarioLançamento;
    }

    public Lancamento(){

    }
}

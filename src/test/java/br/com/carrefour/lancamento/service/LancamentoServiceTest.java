package br.com.carrefour.lancamento.service;

import br.com.carrefour.lancamento.modelo.Lancamento;
import br.com.carrefour.lancamento.repository.LancamentoRepository;
import br.com.carrefour.lancamento.serivce.LancamentoService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LancamentoServiceTest {
    @Mock
    private LancamentoRepository lancamentoRepository;

    @InjectMocks
    private LancamentoService lancamentoService;

    @Test
    @DisplayName("Salvando um Lancamento")
    public void quandoSalvaUmLancamento() {
        Lancamento lancamento = Lancamento.builder().descricaoLancamento("lancamento de credito")
                .dataLancamento("02/03/2023").tipoLancamento("credito").id(2).build();
        when(lancamentoRepository.save(ArgumentMatchers.any(Lancamento.class))).thenReturn(lancamento);
        Lancamento created = lancamentoService.save(lancamento);
        assertThat(created.getId()).isSameAs(lancamento.getId());
        verify(lancamentoRepository).save(lancamento);
    }

    @Test
    @DisplayName("buscando  um Lancamento por id")
    public void quandoBuscaLancamentoPorID(){
        Lancamento lancamento = Lancamento.builder().descricaoLancamento("lancamento de credito")
                .dataLancamento("02/03/2023").tipoLancamento("credito").id(2).build();
        when(lancamentoRepository.findById(lancamento.getId())).thenReturn(Optional.of(lancamento));
        Optional<Lancamento> lancamentoEsperado = lancamentoService.findById(2);
        assertThat(lancamentoEsperado).isSameAs(lancamentoEsperado);
        verify(lancamentoRepository).findById(2);

    }





}

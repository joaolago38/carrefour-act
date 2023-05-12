package br.com.carrefour.lancamento.serivce;

import br.com.carrefour.lancamento.modelo.Lancamento;
import br.com.carrefour.lancamento.repository.LancamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {

    final LancamentoRepository lancamentoRepository;

    public LancamentoService(LancamentoRepository lancamentoRepository) {
        this.lancamentoRepository = lancamentoRepository;
    }

    @Transactional
    public Lancamento save(Lancamento lancamento) {

        return lancamentoRepository.save(lancamento);
    }

    public Optional<Lancamento> findById(Integer id) {
        return lancamentoRepository.findById(id);
    }


    public List<Lancamento> buscaLancamentoCreditoPorData(String dataLancamento){

        Integer somaValorConsolidado = 0;
        Integer somarLalmentosCreditos = 0;
        Integer somarLalmentosDebitos = 0;

        List<Lancamento> lancamentos = lancamentoRepository.buscaLancamentoCreditoPorData(dataLancamento);
        for(Lancamento tipoLancamento : lancamentos ){
            if(tipoLancamento.getTipoLancamento().equals("credito")){
                somarLalmentosCreditos += somarLalmentosCreditos + tipoLancamento.getValorLancado();

            }
            if(tipoLancamento.getTipoLancamento().equals("debito")){
                somarLalmentosDebitos += somarLalmentosDebitos + tipoLancamento.getValorLancado();


            }
            somaValorConsolidado = somarLalmentosCreditos + somarLalmentosDebitos;
            tipoLancamento.setValorConsolidado(somaValorConsolidado);

        }
        return lancamentos;
    }

}

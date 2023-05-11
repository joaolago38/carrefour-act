package br.com.carrefour.lancamento.serivce;

import br.com.carrefour.lancamento.modelo.Lancamento;
import br.com.carrefour.lancamento.repository.LancamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}

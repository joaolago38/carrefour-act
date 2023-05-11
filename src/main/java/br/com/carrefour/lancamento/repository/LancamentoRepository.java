package br.com.carrefour.lancamento.repository;

import br.com.carrefour.lancamento.modelo.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LancamentoRepository extends JpaRepository<Lancamento, Integer > {

}

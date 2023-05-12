package br.com.carrefour.lancamento.repository;

import br.com.carrefour.lancamento.modelo.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface LancamentoRepository extends JpaRepository<Lancamento, Integer > {

    @Query(value = "SELECT u FROM Lancamento u WHERE u.dataLancamento= dataLancamento")
    List<Lancamento> buscaLancamentoCreditoPorData(String dataLancamento);


}

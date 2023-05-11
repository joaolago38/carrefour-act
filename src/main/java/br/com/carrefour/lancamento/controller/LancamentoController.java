package br.com.carrefour.lancamento.controller;

import br.com.carrefour.lancamento.dto.LancamentoDTO;
import br.com.carrefour.lancamento.modelo.Lancamento;
import br.com.carrefour.lancamento.serivce.LancamentoService;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/lancamento")
public class LancamentoController {

    final LancamentoService lancamentoService;

    private final AtomicLong counter = new AtomicLong();

    private final MeterRegistry registry;

    public LancamentoController(LancamentoService lancamentoService, MeterRegistry registry) {
        this.lancamentoService = lancamentoService;
        this.registry = registry;
    }

    @RequestMapping(method =  RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<Object> saveLancamento(@RequestBody @Valid LancamentoDTO lancamentoDTO) {
        var valorLancamento = lancamentoService.findById(lancamentoDTO.getId());
        if (valorLancamento.isPresent()) {

            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Lançamento já efetuado!");
        }
        var lancamentoValor = new Lancamento();
        BeanUtils.copyProperties(lancamentoDTO, lancamentoValor);
        registry.counter("lancamento.counter").increment();
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoService.save(lancamentoValor));
    }

    @GetMapping("/{id}")
    @Timed(value = "greeting.time", description = "Tempo de retorno Lancamento",
            percentiles = {0.5, 0.90})
    public ResponseEntity<Object> buscaPorLancamentoId(@PathVariable(value = "id") Integer id) {
        Optional<Lancamento> lancamento = lancamentoService.findById(id);

        if (lancamento.isPresent()) {
            return new ResponseEntity<>(lancamento.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

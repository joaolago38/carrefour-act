//package br.com.carrefour.lancamento.controller;
//
//import br.com.carrefour.lancamento.modelo.Lancamento;
//import br.com.carrefour.lancamento.serivce.LancamentoService;
//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.time.LocalDateTime;
//
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(LancamentoController.class)
//public class LancamentoControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private LancamentoService lancamentoService;
//
//    @Test
//    @DisplayName("Salva um novo Lançamento")
//    public void salvandoUmNovoLancamentod() throws Exception {
//        Lancamento lancamento = Lancamento.builder().descricãoLancamento("lancamento de credito")
//                .dataLancamento(LocalDateTime.now()).tipoLancamento("credito").id(2).build();
//        given(lancamentoService.save(lancamento)).willReturn(lancamento);
//        mockMvc.perform(post("/lancamento")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(br.com.carrefour.lancamento.util.JsonUtil.toJson(lancamento)))
//                .andExpect(status().isCreated());
//
//    }
//
//}
//

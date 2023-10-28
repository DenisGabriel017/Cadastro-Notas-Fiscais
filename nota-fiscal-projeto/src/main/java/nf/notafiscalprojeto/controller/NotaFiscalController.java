package nf.notafiscalprojeto.controller;

import nf.notafiscalprojeto.exceptions.FornecedorNotFoundExcepetion;
import nf.notafiscalprojeto.model.Fornecedor;
import nf.notafiscalprojeto.model.NotaFiscal;
import nf.notafiscalprojeto.repository.NotaFiscalRepository;
import nf.notafiscalprojeto.service.NotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/notasfiscais")
public class NotaFiscalController {

    @Autowired
    public NotaFiscalService notaFiscalService;

    @PostMapping("/criar-nota")
    public ResponseEntity<NotaFiscal> criarNotaFiscal(@RequestBody NotaFiscal notaFiscal){
        if(notaFiscal == null  || notaFiscal.getNumeroNota() == null || notaFiscal.getDataEmissao() == null){
            return ResponseEntity.badRequest().body(null);
        }
        NotaFiscal novaNotaFiscal = notaFiscalService.criarNotaFiscal(notaFiscal);

        if(novaNotaFiscal != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(novaNotaFiscal);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/mostrar-notas/{id}")
    public ResponseEntity<NotaFiscal> lerNotaFiscal (@PathVariable Long id){
        NotaFiscal notaFiscal = notaFiscalService.buscarNotaFiscalPorId(id);

        if (notaFiscal != null){
            return ResponseEntity.ok(notaFiscal);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/atualizarnota/{id}")
    public ResponseEntity<NotaFiscal> atualizarNotaFiscal(@PathVariable Long id, @RequestBody NotaFiscal notaFiscal){
        NotaFiscal notaExistente = notaFiscalService.buscarNotaFiscalPorId(id);

        if (notaFiscal != null){
            notaExistente.setNumeroNota(notaFiscal.getNumeroNota());
            notaExistente.setDataEmissao(notaFiscal.getDataEmissao());
            notaExistente.setStatus(notaFiscal.getStatus());
            notaExistente.setFormaDePagamento(notaFiscal.getFormaDePagamento());


            NotaFiscal notaFiscalAtualizada = notaFiscalService.atualizarNotaFiscal(notaExistente);

            return  ResponseEntity.ok(notaFiscalAtualizada);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/apagar-nota/{id}")
    public ResponseEntity<Void> excluirNotaFiscal(@PathVariable Long id){
        NotaFiscal notaExistente = notaFiscalService.buscarNotaFiscalPorId(id);

        if (notaExistente!= null){
            notaFiscalService.excluirNotaFiscal(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/buscar-por-fornecedor")
    public List<NotaFiscal> findByFornecedorNome(@RequestParam String fornecedor){
        List<NotaFiscal> notaFiscal = notaFiscalService.findByPorNomeFornecedor(fornecedor);

        if (notaFiscal != null){
            return ResponseEntity.ok(notaFiscal).getBody();
        }
            throw new FornecedorNotFoundExcepetion("Nenhuma nota foi encontrada para esse fornecedor");
    }
}


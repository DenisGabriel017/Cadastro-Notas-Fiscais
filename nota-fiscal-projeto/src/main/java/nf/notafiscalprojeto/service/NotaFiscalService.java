package nf.notafiscalprojeto.service;

import nf.notafiscalprojeto.model.NotaFiscal;
import nf.notafiscalprojeto.repository.NotaFiscalRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotaFiscalService {
    private final NotaFiscalRepository notaFiscalRepository;

    public NotaFiscalService(NotaFiscalRepository notaFiscalRepository) {
        this.notaFiscalRepository = notaFiscalRepository;
    }

    public NotaFiscal criarNotaFiscal(NotaFiscal notaFiscal){
        if(notaFiscal == null || notaFiscal.getNumeroNota() == null || notaFiscal.getDataEmissão() == null){
            throw new IllegalArgumentException("Os campos obrigatórios da nota fiscal não foram fornecidos ");
        }
        System.out.println("Nota criada com sucesso!");
        NotaFiscal novaNotaFiscal = (NotaFiscal) notaFiscalRepository.save(notaFiscal);
        return novaNotaFiscal;

    }

    public NotaFiscal buscarNotaFiscalPorId(Long id){
        Optional<NotaFiscal> notaFiscalOptional = notaFiscalRepository.findById(id);
        if (notaFiscalOptional.isPresent()) {
            return notaFiscalOptional.get();
        }
        return null;

    }

    public NotaFiscal atualizarNotaFiscal(NotaFiscal notaFiscal){
        Long notaFiscalId = notaFiscal.getId();
        if (notaFiscalId == null) {
            return null;
        }
        if (!notaFiscalRepository.existsById(notaFiscalId)) {
            return null;
        }
        NotaFiscal notaFiscalAtulizada = (NotaFiscal) notaFiscalRepository.save(notaFiscal);

        return notaFiscalAtulizada;
    }

    public NotaFiscal excluirNotaFiscal(Long id){
        if (notaFiscalRepository.existsById(id)){
            notaFiscalRepository.deleteById(id);
        }

        System.out.println("Nota excluida com sucesso!");
        return null;

    }

}

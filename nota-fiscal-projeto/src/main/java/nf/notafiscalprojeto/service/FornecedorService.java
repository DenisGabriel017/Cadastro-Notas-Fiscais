package nf.notafiscalprojeto.service;

import nf.notafiscalprojeto.model.NotaFiscal;
import nf.notafiscalprojeto.model.Fornecedor;
import nf.notafiscalprojeto.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    private FornecedorRepository fornecedorRepository;

    @Autowired
    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public Fornecedor criarFornecedor(NotaFiscal notaFiscal) {
        if (notaFiscal.getFornecedor() != null) {
            Fornecedor fornecedor = notaFiscal.getFornecedor();
            Fornecedor fornecedorExistente = fornecedorRepository.findByCnpj(fornecedor.getCnpj());
            if (fornecedorExistente != null) {
                fornecedorExistente.setNome(fornecedor.getNome());
                return fornecedorRepository.save(fornecedorExistente);
            } else {
                return fornecedorRepository.save(fornecedor);
            }
        } else {
            throw new IllegalArgumentException("A NotaFiscal não contém informações do fornecedor.");
        }
    }
}

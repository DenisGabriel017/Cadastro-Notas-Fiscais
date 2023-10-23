package nf.notafiscalprojeto.repository;

import nf.notafiscalprojeto.NotaFiscalProjetoApplication;
import nf.notafiscalprojeto.model.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {

    NotaFiscal findByNumeroNota(String numeroNota);
    List<NotaFiscal> findByStatus(String status);



}

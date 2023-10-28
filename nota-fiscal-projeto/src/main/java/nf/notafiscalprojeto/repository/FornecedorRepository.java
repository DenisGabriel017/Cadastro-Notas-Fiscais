package nf.notafiscalprojeto.repository;

import nf.notafiscalprojeto.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    Fornecedor findByCnpj(String cpnj);

}

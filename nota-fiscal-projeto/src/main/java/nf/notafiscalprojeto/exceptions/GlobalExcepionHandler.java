package nf.notafiscalprojeto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExcepionHandler {

    @ExceptionHandler(FornecedorNotFoundExcepetion.class)
    public ResponseEntity<String>handleFornecedorFoundException(FornecedorNotFoundExcepetion ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

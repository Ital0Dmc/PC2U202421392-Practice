// CAMBIAR: fitclub por el nombre del caso (pe.com.<caso>.platform.u202421392)
package pe.com.aseguramed.platform.u202421392.shared.interfaces.rest;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
// CAMBIAR: fitclub por el caso, fitness por el BC y Membership por el aggregate
import pe.com.fitclub.platform.u202421392.fitness.domain.exceptions.MembershipAlreadyExistsException;
// CAMBIAR: fitclub por el nombre del caso
import pe.com.fitclub.platform.u202421392.shared.interfaces.rest.resources.MessageResource;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // CAMBIAR: Membership por el aggregate (en las 2 líneas de abajo)
    @ExceptionHandler(MembershipAlreadyExistsException.class)
    public ResponseEntity<MessageResource> handleAlreadyExists(MembershipAlreadyExistsException ex) {
        return buildResponse(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<MessageResource> handleBusinessRule(RuntimeException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageResource> handleValidation(MethodArgumentNotValidException ex) {
        return buildResponse(HttpStatus.BAD_REQUEST, "request.error.required.fields");
    }

    private ResponseEntity<MessageResource> buildResponse(HttpStatus status, String key) {
        var message = messageSource.getMessage(key, null, key, LocaleContextHolder.getLocale());
        return ResponseEntity.status(status).body(new MessageResource(message));
    }
}
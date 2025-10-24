package cat.smap.web.responses;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;

public enum ApiMessages {

    ITEM_CREATED(
            HttpStatus.CREATED,
            "El nou registre s'ha creat satisfactòriament."
    ),

    ITEM_UPDATED(
            HttpStatus.OK,
            "El registre s'ha actualitzat satisfactòriament."
    ),

    ITEM_DELETED(
            HttpStatus.OK,
            "El registre s'ha eliminat satisfactòriament."
    ),

    ITEM_SOFT_DELETED_OK(
            HttpStatus.OK,
            "L'esborrat lògic s'ha aplicat satisfactòriament al registre sol·licitat."
    ),

    ITEM_SOFT_DELETED_KO(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "L'esborrat lògic no s'ha pogut aplicar al registre sol·licitat."
    ),

    ITEM_NOT_FOUND(
            HttpStatus.NOT_FOUND,
            "No s'ha trobat cap registre coincident amb els vostres criteris: [%s] -> %s"
    ),

    ITEM_NOT_CREATED(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "No s'ha pogut crear el registre."
    ),

    ITEM_NOT_UPDATED(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "No s'ha pogut actualitzar el registre."
    ),

    ITEM_NOT_DELETED(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "No s'ha pogut eliminar el registre."
    ),

    ERROR(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "Error des del servidor"
    ),

    SUCCESS(
         HttpStatus.OK,
         "success"
    ),

    ;

    private final HttpStatus status;
    private final String message;

    ApiMessages(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}

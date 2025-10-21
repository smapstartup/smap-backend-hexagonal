package cat.smap.web.responses;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;

public enum ApiMessages {

    ITEM_FOUND(HttpStatus.OK, "S'ha recuperat un ítem."),
    ITEM_NOT_FOUND(HttpStatus.OK, "No s'ha pogut recuperar l'ítem."),
    ITEM_CREATED(HttpStatus.CREATED, "S'ha registrat un nou ítem."),
    ITEM_NOT_CREATED(HttpStatus.CREATED, "No s'ha pogut registrar el nou ítem."),
    ITEM_UPDATED(HttpStatus.OK, "S'ha actualitzat el ítem."),
    ITEM_NOT_UPDATED(HttpStatus.CREATED, "No s'ha pogut actualitzar l'ítem."),
    ITEM_DELETED(HttpStatus.OK, "L'ítem s'ha eliminat."),
    ITEM_NOT_DELETED(HttpStatus.CREATED, "L'ítem no s'ha pogut eliminar."),
    GENERIC_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Ha ocorregut un error al servidor."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "Error. Manca autorització per resoldre aquesta sol·licitud."),
    SOURCE_LOCKED(HttpStatus.LOCKED, "El recurs sol·licitat es troba bloquejat per un altre usuari."),
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

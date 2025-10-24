package cat.smap.web.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

public class ApiResponse<T> {

    private final HttpStatus status;
    private int code;
    private final Instant data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String missatge;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final String error;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T item;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final List<T> items;



    /**
     * Constructors privats.
     * Accessibles només via mètodes factory.
     */

    // Constructor per un únic ítem
    // Create, Update, Delete, SoftDelete
    private ApiResponse(HttpStatus status, String missatge, String error, T item, List<T> items) {
        this.status = status;
        this.code = status.value();
        this.data = Instant.now();
        this.missatge = missatge;
        this.error = error;
        this.item = item;
        this.items = items;
    }

    public static <T> ApiResponse<T> itemFound(T item) {
        return new ApiResponse<>(
                ApiMessages.SUCCESS.getStatus(),
                null,
                null,
                item,
                null
        );
    }

    public static <T> ApiResponse<T> itemNotFound(String key, String value) {
        return new ApiResponse<>(
                ApiMessages.ITEM_NOT_FOUND.getStatus(),
                null,
                ApiMessages.ITEM_NOT_FOUND.getMessage().formatted(key, value),
                null,
                null
        );
    }

    public static <T> ApiResponse<T> itemCreateSuccess(T item) {
        return new ApiResponse<>(
                ApiMessages.ITEM_CREATED.getStatus(),
                ApiMessages.ITEM_CREATED.getMessage(),
                null,
                item,
                null
        );
    }

    public static <T> ApiResponse<T> itemCreateError(T item, String error) {
        return new ApiResponse<>(
                ApiMessages.ITEM_NOT_CREATED.getStatus(),
                ApiMessages.ITEM_NOT_CREATED.getMessage(),
                error,
                item,
                null
        );
    }

    public static <T> ApiResponse<T> itemUpdateSuccess(T item) {
        return new ApiResponse<>(
                ApiMessages.ITEM_UPDATED.getStatus(),
                ApiMessages.ITEM_UPDATED.getMessage(),
                null,
                item,
                null
        );
    }

    public static <T> ApiResponse<T> itemUpdateError(T item) {
        return new ApiResponse<>(
                ApiMessages.ITEM_NOT_UPDATED.getStatus(),
                null,
                ApiMessages.ITEM_NOT_UPDATED.getMessage(),
                item,
                null
        );
    }

    public static <T> ApiResponse<T> itemDeleteSuccess(T item) {
        return new ApiResponse<>(
                ApiMessages.ITEM_DELETED.getStatus(),
                ApiMessages.ITEM_DELETED.getMessage(),
                null,
                item,
                null
        );
    }

    public static <T> ApiResponse<T> itemDeleteError(T item) {
        return new ApiResponse<>(
                ApiMessages.ITEM_NOT_DELETED.getStatus(),
                null,
                ApiMessages.ITEM_NOT_DELETED.getMessage(),
                item,
                null
        );
    }

    public static <T> ApiResponse<T> itemSoftDeleteSuccess(T item) {
        return new ApiResponse<>(
                ApiMessages.ITEM_SOFT_DELETED_OK.getStatus(),
                ApiMessages.ITEM_SOFT_DELETED_OK.getMessage(),
                null,
                item,
                null
        );
    }

    public static <T> ApiResponse<T> itemSoftDeleteError(T item) {
        return new ApiResponse<>(
                ApiMessages.ITEM_SOFT_DELETED_KO.getStatus(),
                null,
                ApiMessages.ITEM_SOFT_DELETED_KO.getMessage(),
                item,
                null
        );
    }

    public static <T> ApiResponse<T> itemsListSuccess(List<T> items) {
        return new ApiResponse<>(
            ApiMessages.SUCCESS.getStatus(),
            null,
            null,
            null,
            items
        );
    }

    public static <T> ApiResponse<T> itemsListError(List<T> items) {
        return new ApiResponse<>(
                ApiMessages.ERROR.getStatus(),
                null,
                ApiMessages.ERROR.getMessage(),
                null,
                items
        );
    }

    public static ApiResponse<?> of(HttpStatus status, String message) {
        return new ApiResponse<>(
                status,
                null,
                message,
                null,
                null
        );
    }

    public HttpStatus getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public Instant getData() {
        return data;
    }

    public String getMissatge() {
        return missatge;
    }

    public String getError() {
        return error;
    }

    public T getItem() {
        return item;
    }

    public List<T> getItems() {
        return items;
    }
}

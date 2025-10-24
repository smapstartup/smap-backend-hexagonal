package cat.smap.web.controllers;

import cat.smap.application.requests.users.UserCreateDto;
import cat.smap.application.requests.users.UserToDeleteDto;
import cat.smap.application.requests.users.UserUpdateDto;
import cat.smap.application.responses.users.UserResponseDto;
import cat.smap.domain.services.UserService;
import cat.smap.web.responses.ApiMessages;
import cat.smap.web.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Tag(name = "Usuaris", description = "Punts finals per operacions CRUD de usuaris")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<UserResponseDto>> createUser(
            @RequestBody UserCreateDto dto
    ) {
        try {
            UserResponseDto created = userService.createUser(dto);
            return ResponseEntity
                    .status(ApiMessages.ITEM_CREATED.getStatus())
                    .body(ApiResponse.itemCreateSuccess(created));
        } catch ( IllegalArgumentException ex ) {
            return ResponseEntity
                    .status(ApiMessages.ITEM_NOT_CREATED.getStatus())
                    .body(ApiResponse.itemCreateError(null, ex.getMessage()));
        }
    }

    @PatchMapping( path = "/edit",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<UserResponseDto>> patchUser(
            @RequestBody UserUpdateDto dto
    ){
        try {
            UserResponseDto updated = userService.patchUser(dto);
            return ResponseEntity
                    .status(ApiMessages.ITEM_UPDATED.getStatus())
                    .body(ApiResponse.itemUpdateSuccess(updated));
        } catch (Exception e) {
            return ResponseEntity
                    .status(ApiMessages.ITEM_NOT_UPDATED.getStatus())
                    .body(ApiResponse.itemUpdateError(null));
        }
    }

    @PutMapping(path = "/update",
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<UserResponseDto>> putUser(
            @RequestBody UserUpdateDto dto
    ){
        try {
            UserResponseDto updated = userService.putUser(dto);
            return ResponseEntity
                    .status(ApiMessages.ITEM_UPDATED.getStatus())
                    .body(ApiResponse.itemUpdateSuccess(updated));
        } catch (Exception e) {
            return ResponseEntity
                    .status(ApiMessages.ITEM_NOT_UPDATED.getStatus())
                    .body(ApiResponse.itemUpdateError(null));
        }

    }

    @GetMapping(path = "/find-by-id/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<UserResponseDto>> getUserById(
            @PathVariable UUID id
    ){
        try {
            UserResponseDto found = userService.findById(id);
            return ResponseEntity
                    .status(ApiMessages.SUCCESS.getStatus())
                    .body(ApiResponse.itemFound(found));
        } catch ( Exception ex ) {
            return ResponseEntity
                    .status(ApiMessages.ERROR.getStatus())
                    .body(ApiResponse.itemNotFound("UUID", id.toString()));
        }
    }

    @PatchMapping(path = "/soft-delete",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<UserResponseDto>> disableUser(
            @RequestBody UserToDeleteDto dto
    ){
        try {
            UserResponseDto updated = userService.softDelete(dto);
            return ResponseEntity
                    .status(ApiMessages.ITEM_SOFT_DELETED_OK.getStatus())
                    .body(ApiResponse.itemSoftDeleteSuccess(updated));
        } catch ( Exception ex ) {
            return ResponseEntity
                    .status(ApiMessages.ITEM_SOFT_DELETED_KO.getStatus())
                    .body(ApiResponse.itemSoftDeleteError(null));
        }
    }

    @DeleteMapping( path = "/delete",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<UserResponseDto>> deleteUser(
            @RequestBody UserToDeleteDto dto
    ){
        try {
            UserResponseDto deleted = userService.deleteUser(dto);
            return ResponseEntity
                    .status(ApiMessages.ITEM_DELETED.getStatus())
                    .body(ApiResponse.itemDeleteSuccess(deleted));
        } catch (Exception e) {
            return ResponseEntity
                    .status(ApiMessages.ITEM_NOT_DELETED.getStatus())
                    .body(ApiResponse.itemDeleteError(null));
        }
    }

    @GetMapping( path = "/find-all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<UserResponseDto>> getAllUsers(){
        try {
            List<UserResponseDto> users = userService.findAll();
            return ResponseEntity
                    .status(ApiMessages.SUCCESS.getStatus())
                    .body(ApiResponse.itemsListSuccess(users));
        } catch ( Exception ex ) {
            return ResponseEntity
                    .status(ApiMessages.ERROR.getStatus())
                    .body(ApiResponse.itemsListError(new ArrayList<>()));
        }
    }

}

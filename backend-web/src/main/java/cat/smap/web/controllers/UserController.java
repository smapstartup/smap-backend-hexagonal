package cat.smap.web.controllers;

import cat.smap.application.requests.UserCreateDto;
import cat.smap.application.requests.UserToDeleteDto;
import cat.smap.application.requests.UserUpdateDto;
import cat.smap.application.responses.UserResponseDto;
import cat.smap.domain.services.UserService;
import cat.smap.utils.exceptions.NotFoundException;
import cat.smap.web.responses.ApiMessages;
import cat.smap.web.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        UserResponseDto created = userService.createUser(dto);
        return ResponseEntity
                .status(ApiMessages.ITEM_CREATED.getStatus())
                .body(ApiResponse.of(
                        ApiMessages.ITEM_CREATED.getStatus(),
                        ApiMessages.ITEM_CREATED.getMessage(),
                        created
                ));
    }

    @PatchMapping( path = "/edit",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<UserResponseDto>> patchUser(
            @RequestBody UserUpdateDto dto
    ){
        UserResponseDto updated = userService.patchUser(dto);
        return ResponseEntity
                .status(ApiMessages.ITEM_UPDATED.getStatus())
                .body(ApiResponse.of(
                        ApiMessages.ITEM_UPDATED.getStatus(),
                        ApiMessages.ITEM_UPDATED.getMessage(),
                        updated
                ));
    }

    @PutMapping(path = "/update",
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<UserResponseDto>> putUser(
            @RequestBody UserUpdateDto dto
    ){
        UserResponseDto updated = userService.putUser(dto);
        return ResponseEntity
                .status(ApiMessages.ITEM_UPDATED.getStatus())
                .body(ApiResponse.of(
                        ApiMessages.ITEM_UPDATED.getStatus(),
                        ApiMessages.ITEM_UPDATED.getMessage(),
                        updated
                ));
    }

    @GetMapping(path = "/find-by-uuid/{uuid}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<UserResponseDto>> getUserByUuid(@PathVariable UUID uuid){

        try {
            UserResponseDto found = userService.findByUuid(uuid);
            return ResponseEntity
                    .status(ApiMessages.ITEM_FOUND.getStatus())
                    .body(ApiResponse.of(
                            ApiMessages.ITEM_FOUND.getStatus(),
                            ApiMessages.ITEM_FOUND.getMessage(),
                            found)
                    );
        } catch ( NotFoundException ex ) {
            return ResponseEntity
                    .status(ApiMessages.ITEM_NOT_FOUND.getStatus())
                    .body(ApiResponse.of(
                            ApiMessages.ITEM_NOT_FOUND.getStatus(),
                            ex.getMessage(),
                            null)
                    );
        }
    }

    @PatchMapping(path = "/soft-delete",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<UserResponseDto>> disableUser(
            @RequestBody UserToDeleteDto dto
    ){
        UserResponseDto updated = userService.softDelete(dto);
        return ResponseEntity
                .status(ApiMessages.ITEM_UPDATED.getStatus())
                .body(ApiResponse.of(
                        ApiMessages.ITEM_UPDATED.getStatus(),
                        ApiMessages.ITEM_UPDATED.getMessage(),
                        updated
                ));
    }

    @DeleteMapping( path = "/delete",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<UserResponseDto>> deleteUser(
            @RequestBody UserToDeleteDto dto
    ){
        UserResponseDto updated = userService.deleteUser(dto);
        return ResponseEntity
                .status(ApiMessages.ITEM_UPDATED.getStatus())
                .body(ApiResponse.of(
                        ApiMessages.ITEM_UPDATED.getStatus(),
                        ApiMessages.ITEM_UPDATED.getMessage(),
                        updated
                ));
    }

    @GetMapping( path = "/find-all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponse<List<UserResponseDto>>> getAllUsers(){
        List<UserResponseDto> users = userService.findAll();

        return ResponseEntity
                .status(ApiMessages.ITEMS_FOUND.getStatus())
                .body(ApiResponse.of(
                        ApiMessages.ITEMS_FOUND.getStatus(),
                        ApiMessages.ITEMS_FOUND.getMessageNumericParam(users.size()),
                        users
                ));
    }

}

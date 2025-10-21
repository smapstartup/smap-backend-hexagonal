package cat.smap.web.controllers;

import cat.smap.application.requests.UserCreateDto;
import cat.smap.application.responses.UserResponseDto;
import cat.smap.domain.services.UserService;
import cat.smap.utils.exceptions.NotFoundException;
import cat.smap.web.responses.ApiMessages;
import cat.smap.web.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Tag(name = "Usuaris", description = "Punts finals per operacions CRUD de usuaris")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Tag(
            name="createUser",
            description="Punt final per crear un nou registre d'usuari a la Base de Dades."
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

    @GetMapping(path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Tag(
            name = "getUserById",
            description = "Cerca a la Base de Dades un usuari amb l'Id indicat"
    )
    public ResponseEntity<ApiResponse<UserResponseDto>> getUserById(@PathVariable Long id){

        try {
            UserResponseDto found = userService.findById(id);
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

}

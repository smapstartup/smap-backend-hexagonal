# Package domain/mappers/services
Package per classes mapper (mapstruct) per transferir dades d'entrada des del Service al Repository  

Ex:
````java
UserEntity toEntity(User model);
````

i per transferir dades de sortida del Service al Dto  

Ex:
````java
UserResponseDto toDto(User model);
````


# Package utils/contracts
Package per interficies que definiran contractes que hagin de complir múltiples classes per la seva naturalesa.

Exemple:

Dins una col·lecció d'objectes, podem necessitar identificar un com a principal.

`````java
public interface Principal {
    boolean isMain();
    void setMain(boolean main);
}
````` 
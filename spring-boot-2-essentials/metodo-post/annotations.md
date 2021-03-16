# Método POST

### Exemplo

```java
@PostMapping
public ResponseEntity<Anime> save(
        @RequestBody Anime anime // Mapeamento automático pelo Jaskson
) {
    
}
```

### Jackson

* JSON -> Objeto da aplicação OU JSON <- Objeto da aplicação

* Mapeamento
    * A conversão ocorre caso todos os atributos do objeto JSON combinarem com um objeto da aplicação.
    * É feita com base no nome dos atributos do objeto da aplicação.
    
    <br>

    * Exemplo com o nome do atributo
        ```json
        {
          "id": 1,
          "name": "Boku No Hero"
        }
        ```
        ```java
        @Getter
        @Setter
        public class Anime {

            private Long id;
            private String name;
            
            // OBS: é necessário ter os getter e setters 
            // para que o Jackson possa fazer o mapeamento
        }
        ```

  * Exemplo com um nome customizado
      ```json
      {
        "id": 1,
        "name": "Boku No Hero"
      }
      ```
      ```java
      @Getter
      @Setter
      public class Anime {

          private Long id;
          @JsonProperty("name")
          private String animeName;
          
          // OBS: é necessário ter os getter e setters 
          // para que o Jackson possa fazer o mapeamento
      }
      ```


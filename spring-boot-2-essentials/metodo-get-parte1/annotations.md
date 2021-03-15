# Método GET Parte 1

### Convenções

* O caminho até recurso(/controller) é no plural.
* Exemplo
    ```java
    @RestController
    @RequestMapping(path = "animes")
    public class AnimeResource {
        // TODO
    }
    ```
  
### Estruturação de um projeto Spring

* _Controller_/_Resource_: endpoints
* _Repository_: acesso ao banco de dados
* _Service_: regras de negócio
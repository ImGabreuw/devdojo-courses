# Criando projeto na pedreiragem pt. 02

### _@GetMapping_ 

* Indicação que o método é um endpoint GET

* Parâmetros
    * path = caminho do endpoint

### _@RequestMapping_ (DESUSO)
    ```java
    @RequestMapping(
            method = RequestMethod.GET, // <=> @GetMapping
            path = "list" // <=> http://localhost:8080/list
    )
    // método
    ```

### _@ComponentScan_

* Em geral é usado em classes de configurações 

* Indicação de quais pacotes devem ser scaneados, e assim configuradas pelo Spring.

* Parâmetros
    * basePackages = caminho do novo pacote base para ser scaneado

* Exemplo
    ```java
    @EnableAutoConfiguration
    @ComponentScan(basePackages = "me.gabreuw.criandoprojetonapedreiragempt01")
    public class ApplicationStarter {

        public static void main(String[] args) {
            SpringApplication.run(ApplicationStarter.class, args);
        }

    }
    ```
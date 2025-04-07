##API RESTful desenvolvida em Java 17, simulando um cadastro de pedidos.

##Diagrama de Classe

 ```mermaid
 classDiagram
    class Pedido {
        - Long id
        - String cliente
        - String descricao
        - LocalDate data
    }

    class PedidoService {
        - List~Pedido~ pedidos
        + adicionar(pedido: Pedido): void
        + listar(): List~Pedido~
    }

    class PedidoController {
        - PedidoService pedidoService
        + criarPedido(pedido: Pedido): void
        + listarPedidos(): List~Pedido~
    }

    PedidoController --> PedidoService
    PedidoService --> Pedido
```mermaid

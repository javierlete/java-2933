# Prueba turismo java

Proyecto de ejemplo (paquetes turísticos) con la misma arquitectura que `backend-Postdegree`
(Models / Dtos / Mappers con MapStruct / Inyeciones (Repositories + Services) / ServicesImp / Controllers).

Su objetivo es **reproducir el problema de los JSON recursivos en relaciones bidireccionales**. No trae ninguna solución.

## Cómo correrlo

```
./mvnw spring-boot:run
```

Usa H2 en memoria y carga datos de prueba al arrancar (`ServicesImp/Inicializacion/DataInitializationService`).
Base URL: `http://localhost:8001/prueba_turismo/api`

## Endpoints para ver el error

| Endpoint | Qué pasa |
|---|---|
| `GET /persona/1` | persona → comentarios → persona → comentarios → ... |
| `GET /cliente/3` | cliente → comentarios/reservas → cliente → ... |
| `GET /reserva/1` | reserva → cliente → reservas → cliente → ... |
| `GET /paquete/1` | paquete → comentarios → persona → comentarios → ... |
| `GET /comentario` | comentario → persona → comentarios → persona → ... |
| `GET /destino` | **funciona bien** (su DTO no expone ninguna relación) |

El JSON se repite hasta que Jackson corta con
`HttpMessageNotWritableException: Document nesting depth (1001) exceeds the maximum allowed (1000)`.
Como la respuesta ya empezó a escribirse, el cliente recibe el JSON recursivo truncado.

## Dónde nace el problema

Relaciones bidireccionales en los modelos:

- `Persona.comentarios` (`@OneToMany`) ↔ `Comentario.persona` (`@ManyToOne`)
- `Cliente.reservas` ↔ `Reserva.cliente`
- `PaqueteTuristico.comentarios / reservas / guias` ↔ `Comentario.paquete`, `Reserva.paquete`, `Guia.paquetes`
- `Destino.paquetes` ↔ `PaqueteTuristico.destino`

Y DTOs que guardan una **entidad** en lugar de un DTO o un id:

- `ComentarioDto.persona` es `Persona` (entidad)
- `ReservaDto.cliente` es `Cliente` (entidad)

El mapper copia esa entidad tal cual y, al serializarla, Jackson sigue la relación inversa
(`persona.comentarios[].persona.comentarios[]...`) sin fin.

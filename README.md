# CrediAPI - Sistema de Originación de Créditos

Sistema de originación de créditos desarrollado con Spring Boot 3.2.2, Java 21 y arquitectura hexagonal/clean en multi-módulo.

## Arquitectura

```
CrediApi/
├── app-service/          # Punto de entrada (CrediApiApplication)
├── api-first/            # DTOs y contratos de API
├── application/          # Casos de uso y servicios de aplicación
├── domain/               # Agregados, entidades, VOs y SPIs
├── infrastructure/       # Adaptadores (JPA, REST, mappers)
└── test-integration/     # Tests de integración
```

## Tecnologías

- **Spring Boot 3.2.2** con Java 21
- **Gradle 8.6** con version catalog
- **PostgreSQL** + Flyway para migraciones
- **MapStruct 1.5.5** para mapeo
- **JWT + OAuth2 Resource Server** (AWS Cognito)
- **JUnit 5** + Jacoco para testing

## Dominio de Negocio

### Flujo Principal
1. **Crear Cliente** → validar documento único
2. **Crear Solicitud** → validar cliente y producto
3. **Aprobar Solicitud** → validar reglas de negocio y crear préstamo
4. **Desembolsar** → cambiar estado y actualizar fechas
5. **Listar Cuotas** → mostrar tabla de amortización
6. **Registrar Pago** (opcional) → aplicar a próxima cuota pendiente

### Entidades Principales
- **Customer**: cliente con documento, email, teléfono
- **LoanProduct**: producto con tasas, montos y plazos
- **LoanApplication**: solicitud con estado (DRAFT/SUBMITTED/APPROVED/REJECTED)
- **Loan**: préstamo aprobado con amortización francesa
- **Installment**: cuotas con capital, interés y saldo
- **Payment**: pagos aplicados a cuotas

## Configuración

### Base de Datos
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/crediapi
    username: crediapi
    password: crediapi123
  
  flyway:
    locations: classpath:db/migration
```

### Seguridad
```yaml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: https://cognito-idp.us-east-1.amazonaws.com/us-east-1_XXXXXXXXX
```

## Ejecución

### Prerrequisitos
- Java 21
- PostgreSQL 14+
- Gradle 8.6+

### Comandos
```bash
# Compilar
./gradlew build

# Ejecutar
./gradlew :app-service:bootRun

# Tests
./gradlew test

# Reporte Jacoco
./gradlew jacocoTestReport
```

## API Endpoints

### Clientes
- `POST /api/customers` - Crear cliente
- `GET /api/customers/{id}` - Obtener cliente

### Solicitudes
- `POST /api/applications` - Crear solicitud
- `POST /api/applications/{id}/approve` - Aprobar solicitud

### Préstamos
- `GET /api/loans/{id}` - Obtener préstamo
- `POST /api/loans/{id}/disburse` - Desembolsar
- `GET /api/loans/{id}/installments` - Listar cuotas

## Datos de Prueba

El sistema incluye datos semilla:
- **Roles**: ADMIN, OPS, ANALYST
- **Usuario**: admin@crediapi.com
- **Productos**: Crédito de Consumo (18% EA), Libre Inversión (22% EA)

## Testing

### Test de Integración
```java
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CreditFlowIntegrationTest {
    // Flujo completo: crear cliente → solicitud → aprobar → desembolsar
}
```

### Cobertura
- Jacoco habilitado en todos los módulos
- Reportes en `build/reports/jacoco/`

## Estructura de Módulos

### Domain
- **Entidades**: Customer, LoanProduct, LoanApplication, Loan, Installment
- **Value Objects**: Money, Rate, DocumentId, Email, Phone
- **SPIs**: Interfaces de repositorios y servicios externos

### Application
- **Casos de Uso**: CreateCustomerUseCase, ApproveApplicationUseCase, etc.
- **Servicios**: LoanCreationService (amortización francesa)

### Infrastructure
- **Adaptadores JPA**: Implementación de repositorios
- **Mappers**: MapStruct para entity ↔ domain
- **Configuración**: Security, Clock, IdGenerator

### API-First
- **DTOs**: Request/Response objects
- **Validaciones**: Bean Validation (JSR-380)

## Reglas de Negocio

### Amortización Francesa
```
i = APR/12
cuota = P * [i(1+i)^n]/[(1+i)^n - 1]
interés = saldo_anterior * i
capital = cuota - interés
saldo = saldo_anterior - capital
```

### Validaciones
- Monto dentro de límites del producto
- Plazo dentro de límites del producto
- Documento único por cliente
- Solo solicitudes SUBMITTED pueden aprobarse
- Solo préstamos APPROVED pueden desembolsarse
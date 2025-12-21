# 🏦 Banco Nexus - Infraestructura Cloud Native

Este repositorio contiene la **Orquestación Central** y los scripts de infraestructura para el ecosistema de microservicios de Banco Nexus. 

El proyecto sigue una arquitectura de **Microservicios Distribuidos** con repositorios independientes, unificados mediante Docker Compose y desplegados en AWS EC2.

---

## 🏗️ Arquitectura del Sistema

El sistema está compuesto por 9 microservicios contenerizados que se comunican a través de una red interna de Docker (`ecuasol-network`) y exponen sus servicios mediante un API Gateway.

| Servicio | Puerto Docker | Tecnología | Repositorio | Descripción |
| :--- | :--- | :--- | :--- | :--- |
| **API Gateway** | `8080` | Java 21 / Spring Cloud | [Banco_Nexus_gateway-server](https://github.com/BrayanVegaG0/Banco_Nexus_gateway-server) | Punto de entrada único. Enrutamiento y CORS. |
| **MS Cuentas** | `8083` | Java 21 / Spring Boot | [Banco_Nexus_ms-cuentas](https://github.com/BrayanVegaG0/Banco_Nexus_ms-cuentas) | Core bancario. Manejo de saldos y productos. |
| **MS Clientes** | `8084` | Java 21 / Spring Boot | [Banco_Nexus_ms-clientes](https://github.com/BrayanVegaG0/Banco_Nexus_ms-clientes) | Gestión de personas y empresas. |
| **MS Transacciones**| `8082` | Java 21 / Spring Boot | [Banco_Nexus_ms-transacciones](https://github.com/BrayanVegaG0/Banco_Nexus_ms-transacciones)| Orquestador de transferencias y pagos. |
| **MS Geografía** | `8081` | Java 21 / MongoDB | [Banco_Nexus_ms-geografiaMongo](https://github.com/BrayanVegaG0/Banco_Nexus_ms-geografiaMongo)| Catálogos de provincias y cantones. |
| **BFF Web** | `8085` | Java 21 / Spring Boot | [Banco_Nexus_BackEnd_WEB](https://github.com/BrayanVegaG0/Banco_Nexus_BackEnd_WEB)| Backend for Frontend (Banca Personas). |
| **BFF Ventanilla** | `8090` | Java 21 / Spring Boot | [Banco_Nexus_BackEnd_VENTANILLA](https://github.com/BrayanVegaG0/Banco_Nexus_BackEnd_VENTANILLA) | Backend for Frontend (Sistema Cajeros). |
| **Web Personas** | `5173` | React / Vite | [Banco_Nexus_SitioWeb](https://github.com/BrayanVegaG0/Banco_Nexus_SitioWeb) | Frontend de Banca en Línea. |
| **Web Ventanilla** | `3000` | React / Vite | [Banco_Nexus_Ventanillas](https://github.com/BrayanVegaG0/Banco_Nexus_Ventanillas) | Frontend para cajeros del banco. |
| **PostgreSQL** | `5432` | Postgres 15 | - | Bases de datos relacionales (`db_cuentas`, etc). |
| **MongoDB** | `27017` | Mongo Latest | - | Base de datos documental (Geografía). |

---

## 🚀 Despliegue en AWS (Producción)

Este proyecto utiliza una estrategia **"Multi-Repo Pull"**. El servidor central descarga el código de cada repositorio independiente y lo construye en sitio.

### Prerrequisitos
* Una instancia AWS EC2 (Ubuntu 24.04, t3.medium o superior).
* Docker y Docker Compose instalados.
* Git configurado con SSH Keys para acceso a los repositorios.

### Pasos de Instalación
1. **Clonar este repositorio de Infraestructura:**
   ```bash
   git clone [https://github.com/BrayanVegaG0/BancoNexus-infraestructura.git](https://github.com/BrayanVegaG0/BancoNexus-infraestructura.git) .
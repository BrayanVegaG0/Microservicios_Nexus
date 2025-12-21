#!/bin/bash

# ==========================================
# SCRIPT MAESTRO DE DESPLIEGUE ECUASOL
# ==========================================

echo "🚀 Iniciando despliegue de Microservicios Ecuasol..."

# 1. Definir la lista de carpetas (nombres de los repos)
# Asegúrate de que estos nombres coincidan EXACTAMENTE con las carpetas
SERVICES=(
    "gateway-server"
    "ms-cuentas"
    "ms-clientes"
    "ms-transacciones"
    "ms-geografiaMongo"
    "BackEnd_WEB_EcuSol"
    "SitioWeb_EcuSol"
    "Stack_Ventanilla" 
)

# 2. Iterar sobre cada servicio y actualizar código (Git Pull)
echo "🔄 Actualizando repositorios..."

for service in "${SERVICES[@]}"; do
    if [ -d "$service" ]; then
        echo "⬇️  Actualizando $service..."
        cd $service
        git checkout main  # O 'master', según tu rama
        git pull origin main
        cd ..
    else
        echo "⚠️  ALERTA: La carpeta $service no existe. Saltando..."
    fi
done

# 3. Bajar contenedores viejos (Opcional, para limpieza profunda)
# echo "🛑 Deteniendo contenedores..."
# docker compose down

# 4. Reconstruir y Levantar (Docker Compose V2)
# --build: Fuerza la recompilación si hubo cambios en el código
# -d: Detached mode (segundo plano)
# --remove-orphans: Limpia contenedores que ya no están en el yaml
echo "🏗️  Construyendo y levantando contenedores Docker..."
docker compose up -d --build --remove-orphans

# 5. Limpieza de imágenes basura (Dangling images) para no llenar el disco
echo "🧹 Limpiando imágenes antiguas..."
docker image prune -f

echo "✅ ¡Despliegue completado exitosamente!"
echo "🌍 Gateway activo en puerto 8080"
docker compose ps
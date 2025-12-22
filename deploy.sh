#!/bin/bash

# ==========================================
# SCRIPT DE DESPLIEGUE - NEXUS MONOREPO
# ==========================================

echo "?? Iniciando despliegue de Nexus..."

# 1. Actualizar el código (Al ser monorepo, solo necesitas un pull en la raíz)
echo "?? Actualizando repositorio principal..."
git checkout main
git pull origin main

# Nota: Si te da error de "local changes", usa esta línea en su lugar para forzar la actualización:
# git fetch --all && git reset --hard origin/main

# 2. Bajar contenedores (Opcional: descomenta si necesitas reiniciar la BD desde cero)
# echo "?? Deteniendo servicios..."
# docker compose down

# 3. Construir y Levantar
# --build: Recompila las imágenes con los cambios del git pull
# --remove-orphans: Borra contenedores viejos si cambiaste nombres en el yaml
echo "???  Construyendo y levantando contenedores Docker..."
docker compose up -d --build --remove-orphans

# 4. Limpieza
echo "?? Limpiando imágenes antiguas (ahorrando espacio)..."
docker image prune -f

echo "? ¡Despliegue completado!"
echo "?? Estado actual:"
docker compose ps
# JellyCast v0.15.3.1 - Release Notes

## 📱 Archivos de Release

- **jellycast-mobile-v0.15.3.1.apk** - Versión para teléfonos y tablets Android (118 MB)
- **jellycast-tv-v0.15.3.1.apk** - Versión para Android TV (114 MB)

## 🆕 Cambios Principales

### Renombrado Completo: Findroid → JellyCast
- ✅ Todas las clases, archivos y referencias renombradas
- ✅ Nuevo Application ID: `dev.jdtech.jellycast`
- ✅ Ahora es una app completamente independiente de Findroid

### Nuevas Funcionalidades

#### 🎬 Selección de Reproductor Externo (Móvil)
- ✅ **Detección mejorada de reproductores externos** (VLC, MX Player, etc.)
  - Soporte para Android 11+ con queries de paquetes
  - Detección de reproductores mediante HTTP, File y Content URIs
  - Lista de reproductores conocidos como fallback
  
- ✅ **UI mejorada para selección de reproductor**
  - Resaltado del reproductor seleccionado con fondo de color
  - Icono de check (✓) para el reproductor activo
  - Descripción dinámica en ajustes mostrando el reproductor seleccionado
  
- ✅ **Gestión inteligente de configuración**
  - Botón solo habilitado cuando la función "Usar reproductor externo" está activa
  - La selección persiste en SharedPreferences
  - Actualización automática de la descripción al volver a ajustes

#### 📡 Modo Fuera de Línea (Móvil)
- ✅ **Filtrado inteligente en "Continuar viendo"**
  - Cuando está en modo offline, solo muestra contenido descargado
  - No muestra elementos que no están disponibles sin conexión

## 🔧 Detalles Técnicos

### Compatibilidad
- **Android Mínimo**: SDK 27 (Android 8.1)
- **Android Objetivo**: SDK 36
- **Application ID**: `dev.jdtech.jellycast`
- **Namespace**: `dev.jdtech.jellyfin` (mantenido para compatibilidad de recursos)

### Arquitectura
- Jetpack Compose con Material3
- Hilt para inyección de dependencias
- Kotlin Coroutines y StateFlow
- Android 11+ package visibility queries

### Archivos Modificados
- 379+ archivos con contenido actualizado
- 26 archivos .kt renombrados físicamente
- 328 archivos Kotlin en total

## 📦 Instalación

### Móvil
```bash
adb install -r jellycast-mobile-v0.15.3.1.apk
```

### Android TV
```bash
adb install -r jellycast-tv-v0.15.3.1.apk
```

## ⚠️ Notas Importantes

1. **App Independiente**: JellyCast se instala como una aplicación separada de Findroid
2. **Primer Inicio**: Necesitarás configurar tus servidores Jellyfin nuevamente
3. **Reproductor Externo**: La función de selección de reproductor externo solo está disponible en la versión móvil
4. **Modo Offline**: Asegúrate de descargar contenido antes de activar el modo fuera de línea

## 🐛 Problemas Conocidos

- Ninguno reportado en esta versión

## 🙏 Créditos

Basado en Findroid - Cliente nativo de Jellyfin para Android
Renombrado y mejorado como JellyCast

---

**Fecha de Release**: 19 de octubre de 2025
**Build**: Release signed con debug keystore (solo para distribución local)

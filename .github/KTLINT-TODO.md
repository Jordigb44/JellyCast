# Tareas Pendientes: Corrección de Estilo KtLint

## 📋 Estado Actual

El CI/CD está configurado y funcionando, pero ktlint está temporalmente configurado como **no bloqueante** (`continue-on-error: true`) debido a violaciones de estilo de código existentes.

## 🐛 Problemas Detectados

### Archivos Afectados

1. **DlnaMiniController.kt** (core)
   - Missing trailing commas
   - Trailing spaces

2. **RokuDevicePicker.kt** (core)
   - Unused imports
   - Trailing spaces

3. **RokuHelper.kt** (core)
   - Import ordering issues
   - Unused imports
   - Missing trailing commas
   - Unexpected indentation
   - Trailing spaces

4. **DownloadsViewModel.kt** (core)
   - Import ordering issues
   - Missing trailing commas
   - Trailing spaces

### Tipos de Errores

- ❌ **Missing trailing comma** (~25 ocurrencias)
- ❌ **Trailing spaces** (~50 ocurrencias)
- ❌ **Unused imports** (3 ocurrencias)
- ❌ **Import ordering** (2 archivos)
- ❌ **Unexpected indentation** (4 líneas)

## 🔧 Solución Recomendada

### Opción 1: Manual (Recomendada)

Editar cada archivo manualmente para:
1. Agregar comas finales en parámetros multi-línea
2. Eliminar espacios al final de líneas
3. Reorganizar imports alfabéticamente
4. Eliminar imports no usados
5. Corregir indentación

### Opción 2: Automática (Problemática)

```bash
./gradlew ktlintFormat
```

**Nota**: Actualmente falla en algunos módulos, posiblemente por incompatibilidad de versión.

### Opción 3: IDE

Configurar IntelliJ IDEA / Android Studio:
1. Settings → Editor → Code Style → Kotlin
2. Import scheme from: `.editorconfig` o ktlint defaults
3. Aplicar reformateo: `Cmd/Ctrl + Alt + L`

## ✅ Pasos para Corregir

### 1. Arreglar Imports

```kotlin
// ❌ Mal
import android.util.Log
import dev.jdtech.jellyfin.models.*
import androidx.compose.runtime.*

// ✅ Bien
import androidx.compose.runtime.*
import dev.jdtech.jellyfin.models.*
```

### 2. Agregar Trailing Commas

```kotlin
// ❌ Mal
fun example(
    param1: String,
    param2: Int
)

// ✅ Bien
fun example(
    param1: String,
    param2: Int,
)
```

### 3. Eliminar Trailing Spaces

Usar Find & Replace en IDE:
- Find: `\s+$` (regex)
- Replace: `` (vacío)

### 4. Corregir Indentación

Usar auto-format del IDE después de arreglar espacios.

## 🚀 Re-habilitar KtLint como Bloqueante

Una vez arreglados todos los problemas:

```yaml
# .github/workflows/build-and-test.yml
- name: Run ktlint
  run: ./gradlew ktlintCheck  # Quitar || true
  # Quitar: continue-on-error: true
```

Commit y push:
```bash
git add .github/workflows/build-and-test.yml
git commit -m "ci: make ktlint blocking after fixes"
git push origin develop
```

## 📊 Archivos Específicos a Corregir

### Alta Prioridad (Más errores)
1. `core/src/main/java/dev/jdtech/jellyfin/roku/RokuHelper.kt` (35+ errores)
2. `core/src/main/java/dev/jdtech/jellyfin/presentation/components/DlnaMiniController.kt` (25+ errores)
3. `core/src/main/java/dev/jdtech/jellyfin/viewmodels/DownloadsViewModel.kt` (15+ errores)
4. `core/src/main/java/dev/jdtech/jellyfin/presentation/components/RokuDevicePicker.kt` (10+ errores)

## 🔍 Verificar Correcciones

```bash
# Verificar solo core
./gradlew :core:ktlintCheck

# Verificar todo
./gradlew ktlintCheck

# Ver reporte detallado
cat core/build/reports/ktlint/ktlintMainSourceSetCheck/ktlintMainSourceSetCheck.txt
```

## ⏱️ Estimación

- **Manual**: ~30-45 minutos
- **Con IDE**: ~15-20 minutos
- **Automático** (si funciona): ~5 minutos

## 📝 Notas

- Los archivos con errores parecen ser contribuciones recientes (Roku/DLNA features)
- El resto del código parece cumplir con ktlint
- Considerar añadir pre-commit hook para evitar futuros problemas

## 🎯 Estado Actual del CI

✅ **Funcionando**: CI ejecuta todos los checks pero ktlint no bloquea
⚠️ **Pendiente**: Arreglar código y re-habilitar ktlint bloqueante

---

**Última actualización**: 19 de octubre de 2025
**Autor**: CI/CD Setup

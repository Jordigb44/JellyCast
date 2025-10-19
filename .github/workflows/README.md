# GitHub Actions Workflows

Este directorio contiene los workflows de CI/CD para JellyCast.

## 📋 Workflows Disponibles

### 1. Build and Test (`build-and-test.yml`)
**Trigger**: Push y Pull Requests en todas las ramas

**Propósito**: Verificación continua de calidad y construcción

**Jobs**:
- 🔍 **Lint Check**: Ejecuta ktlint y Android Lint
- 🏗️ **Build APKs**: Construye APKs debug y release para móvil y TV
- 🧪 **Unit Tests**: Ejecuta tests unitarios y genera reportes
- 🔒 **Security Scan**: Análisis de dependencias
- ✅ **Build Status**: Verifica el estado general y comenta en PRs

**Artefactos**:
- Reportes de lint (7 días)
- APKs de release (30 días)
- Reportes de tests (7 días)
- Reportes de seguridad (30 días)

---

### 2. Release Build (`release.yml`)
**Trigger**: 
- Push a rama `main`
- Tags con formato `v*.*.*`
- Ejecución manual (workflow_dispatch)

**Propósito**: Generar releases oficiales con APKs firmados

**Jobs**:
- 📦 **Build Release APKs**: Construye APKs de release
  - Móvil: `jellycast-mobile-v{version}.apk`
  - TV: `jellycast-tv-v{version}.apk`
- 🔐 **Generate Checksums**: Crea SHA256SUMS.txt
- 📝 **Generate Release Notes**: Genera notas de versión automáticas
- 🚀 **Create GitHub Release**: Publica en GitHub Releases
- 🧹 **Cleanup**: Limpia artefactos antiguos (>30 días)

**Artefactos**:
- APKs de release (90 días)
- Checksums SHA256
- Notas de versión

**GitHub Release incluye**:
- APKs para móvil y TV
- SHA256SUMS.txt
- RELEASE_NOTES.md

---

### 3. Pull Request Checks (`pr-checks.yml`)
**Trigger**: Pull Requests a `main` y `develop`

**Propósito**: Verificaciones exhaustivas antes de merge

**Jobs**:
- ✅ **PR Validation**:
  - Verificación de formato de título (Conventional Commits)
  - Detección de conflictos de merge
  - Verificación de tamaño de archivos (<10MB)

- 📊 **Code Quality**:
  - Análisis con Detekt
  - Métricas de código (líneas añadidas/eliminadas)
  - Advertencias para PRs grandes (>50 archivos)

- 🏗️ **Build PR**: Construye APKs debug

- 🧪 **Test PR**: 
  - Ejecuta tests con cobertura
  - Genera reportes de cobertura
  - Comenta resultados en el PR

- 📦 **APK Size Comparison**:
  - Compara tamaño de APK con rama base
  - Muestra diferencia en MB y porcentaje
  - Alerta si el aumento es significativo

- 📋 **PR Summary**: Resumen de todos los checks

**Comentarios en PR**:
- ✅ Estado de checks
- 🧪 Resultados de tests
- 📦 Comparación de tamaño de APK
- 📋 Resumen final

---

## 🔧 Configuración

### Variables de Entorno
No se requieren variables adicionales. Los workflows usan:
- `GITHUB_TOKEN`: Proporcionado automáticamente

### Secretos (Opcional)
Para releases firmados con keystore personalizado, añadir:
- `RELEASE_KEYSTORE`: Archivo keystore en base64
- `RELEASE_KEYSTORE_PASSWORD`: Contraseña del keystore
- `RELEASE_KEY_ALIAS`: Alias de la clave
- `RELEASE_KEY_PASSWORD`: Contraseña de la clave

### Permisos
Los workflows requieren:
- `contents: write` (para crear releases)
- `issues: write` (para comentar en PRs)

---

## 🚀 Uso

### Crear una Release

#### Opción 1: Push a main
```bash
git checkout main
git merge develop
git push origin main
```

#### Opción 2: Crear tag
```bash
git tag v0.15.3.2
git push origin v0.15.3.2
```

#### Opción 3: Ejecución manual
1. Ve a Actions → Release Build
2. Click en "Run workflow"
3. Ingresa la versión (ej: 0.15.3.2)
4. Click en "Run workflow"

### Verificar Build en Todas las Ramas
Simplemente haz push a cualquier rama:
```bash
git push origin feature/nueva-funcionalidad
```

El workflow `build-and-test.yml` se ejecutará automáticamente.

### Crear Pull Request
1. Crea un PR a `main` o `develop`
2. El workflow `pr-checks.yml` se ejecutará automáticamente
3. Revisa los comentarios y checks en el PR
4. Corrige cualquier problema antes de hacer merge

---

## 📊 Badges de Estado

Añade estos badges a tu README.md:

```markdown
![Build and Test](https://github.com/Jordigb44/findroid/workflows/Build%20and%20Test/badge.svg)
![Release](https://github.com/Jordigb44/findroid/workflows/Release%20Build/badge.svg)
```

---

## 🔍 Troubleshooting

### El build falla con error de memoria
Ajusta `GRADLE_OPTS` en los workflows:
```yaml
env:
  GRADLE_OPTS: -Dorg.gradle.daemon=false -Dorg.gradle.workers.max=2 -Xmx2g
```

### Los tests fallan intermitentemente
Añade `--rerun-tasks` al comando de test:
```yaml
run: ./gradlew testDebugUnitTest --rerun-tasks
```

### El release no se crea automáticamente
Verifica:
1. Permisos del workflow (Settings → Actions → General)
2. Que estás en la rama `main`
3. Que el token tiene permisos `contents: write`

---

## 📚 Recursos

- [GitHub Actions Documentation](https://docs.github.com/en/actions)
- [Gradle Build Scans](https://scans.gradle.com/)
- [Conventional Commits](https://www.conventionalcommits.org/)

---

**Última actualización**: 19 de octubre de 2025

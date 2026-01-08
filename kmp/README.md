# KMP (Kotlin Multiplatform)

This directory contains the Kotlin Multiplatform (KMP) portion of the project.

It is intentionally split into **logic**, **UI**, and **application shell** so that:
- shared business logic can be consumed by **Android** and **Angular**
- mobile UI can exist independently without affecting JS output
- web UI remains entirely owned by Angular

---

## Modules

### `shared-logic`
Core shared logic module.

Targets:
- Android
- JavaScript (IR)
- iOS (present but currently dormant)

Responsibilities:
- Business logic
- Pure functions
- Data transformations
- JS-exported APIs consumed by Angular

This module **does generate JavaScript and TypeScript definitions** and is the
_only_ module that feeds the Angular app.

---

### `shared-ui`
Shared Compose UI module.

Targets:
- Android only (by design)

Responsibilities:
- Shared mobile UI components
- Compose-based layouts
- No business logic
- No JS target

This module exists to prove that shared UI can be reintroduced without impacting
the JS pipeline or Angular in any way.

---

### `composeApp`
Android application shell.

Responsibilities:
- Android entry point
- Wiring shared UI and shared logic together
- Platform-specific setup

This module depends on:
- `shared-logic`
- `shared-ui`

---

## Build & Dev Workflow

### Sync shared logic into Angular
From this directory:

```bash
./gradlew syncWeb

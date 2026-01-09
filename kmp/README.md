# Kotlin Multiplatform (KMP)

This directory contains the Kotlin Multiplatform portion of the project.

It is intentionally split into **logic**, **UI**, and **application shell** to keep
concerns isolated and prevent accidental coupling between Android and web.

The goal is not “maximum sharing”, but **controlled sharing**.

---

## Modules

### `shared-logic`

Pure shared logic.

Targets:
- Android
- JavaScript (IR)
- iOS (present but currently unused)

Responsibilities:
- Business logic
- Pure functions
- Data transformations
- APIs exported to JavaScript

This is the **only** module that:
- Produces JavaScript
- Produces TypeScript definitions
- Feeds the Angular application

No UI code exists here.

---

### `shared-ui`

Android-only shared UI.

Targets:
- Android

Responsibilities:
- Compose UI
- Layout and presentation
- Calling into `shared-logic` when needed

This module **does not**:
- Target JavaScript
- Export anything to Angular
- Contain business logic

Its existence proves that shared UI can be added without affecting the JS pipeline.

---

### `composeApp` / `androidApp`

Android application shell.

Responsibilities:
- Android entry point
- Activity setup
- Hosting Compose
- Wiring `shared-ui` and `shared-logic` together

This module depends on:
- `shared-logic`
- `shared-ui`

---

## Build Notes

The KMP project can be built independently.

For web integration, a single Gradle task is exposed:

```bash
./gradlew syncWeb
````

This task builds `shared-logic` for JavaScript and copies the output into the
Angular project.

In practice, this task is invoked by Angular’s `npm start` script.

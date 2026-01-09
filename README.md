# KMP Blog Site

This repository is a **single monorepo** containing two things:

1. A Kotlin Multiplatform (KMP) project
2. An Angular web application

The two are intentionally connected in only **one direction**:

- Kotlin **shared-logic** builds JavaScript
- Angular consumes that output
- Angular is the driver for web development

Android runs entirely on the Kotlin side and does not depend on Angular in any way.

---

## High-Level Structure

```

/
├─ kmp/        # Kotlin Multiplatform project
└─ angular/    # Angular web app

````

---

## How the Pieces Fit Together

- `shared-logic` (Kotlin)
  - Contains pure business logic
  - Builds JS + `.d.ts`
  - Output is copied into the Angular project

- `shared-ui` (Kotlin)
  - Android-only Compose UI
  - Depends on `shared-logic`
  - Never targets JS

- `composeApp` / `androidApp` (Kotlin)
  - Android application shell
  - Wires logic + UI together

- `angular`
  - Owns all web UI
  - Calls into Kotlin-generated JS
  - Runs independently of Android

There is **no shared UI between Android and web**.
Only shared logic.

---

## How to Run Things

### Android
Use Gradle or IntelliJ run configurations from the `kmp` project.

### Web
From the `angular` directory:

```bash
npm start
````

This will:

1. Build Kotlin shared logic
2. Copy the JS output into Angular
3. Start the Angular dev server

---

## Design Constraints (Intentional)

* Angular owns all web UI
* Kotlin owns all shared business logic
* Shared UI is Android-only
* No Compose → JS
* No Angular → Kotlin build steps
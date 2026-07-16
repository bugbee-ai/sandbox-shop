# Contributing to Sandbox Shop

Thanks for your interest! This repo doubles as a reference for how a mobile
team works on GitHub, so the workflow below is the demo.

## Workflow

1. **Open an issue first** using the issue forms — bugs and features have
   structured templates.
2. **Branch from `main`** with a descriptive name (`feature/…`, `fix/…`).
3. **Make your change** with tests. Run the same checks CI runs:
   ```sh
   ./gradlew lintDebug testDebugUnitTest assembleDebug
   ```
4. **Open a pull request.** The PR template guides what to include. CODEOWNERS
   automatically requests review, and the branch ruleset requires CI to pass
   before merging — `main` is never merged red.
5. **Merge when green.** Releases are cut by pushing a `v*` tag, which builds
   the APK and publishes a GitHub Release automatically.

## Project conventions

- Kotlin, official code style (`kotlin.code.style=official`).
- Keep `MainActivity.kt`'s checkout flow untouched — the intentional
  `BUGBEE-DEMO-BUG` is load-bearing for demos.
- Dependencies are managed by Dependabot; don't bump versions by hand unless
  a change requires it.

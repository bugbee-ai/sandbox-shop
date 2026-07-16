# Sandbox Shop — Full GitHub Ecosystem Build-Out

**Date:** 2026-07-15
**Purpose:** Turn `bugbee-ai/sandbox-shop` into a living showcase of the GitHub
ecosystem for a shareholder demo, doubling as a reference template for iOS/Android
teams new to GitHub.

## Approved decisions

1. **Visibility:** repo flips to **public** — unlocks branch protection, CodeQL,
   secret scanning, and GitHub Pages at no cost on the free org plan.
2. **Scope:** full build-out (CI, release pipeline, security suite, community
   health files, branch ruleset, README + demo script, seeded demo content).
3. **Demo content:** seeded — realistic issues, a milestone, an open feature PR
   with CI checks, and a published `v1.0.0` release with the APK attached.
4. **BUGBEE-DEMO-BUG:** untouched. The intentional checkout bug in
   `MainActivity.kt` is load-bearing for Bugbee's own demos. The seeded PR adds
   an unrelated feature instead.

## Components

### Workflows (`.github/workflows/`)
- **`ci.yml`** (replaces `build-apk.yml`): runs on PRs and pushes to `main`.
  Job DAG: `validate` (Gradle wrapper validation) → `lint` + `test` in
  parallel → `build` (debug APK artifact). Uses `gradle/actions/setup-gradle`
  for caching. Least-privilege `permissions:`, concurrency cancellation,
  job summaries. All actions pinned by commit SHA.
- **`release.yml`**: on `v*` tag push. Builds the APK, publishes a GitHub
  Release with auto-generated notes and the APK attached, deploys against the
  `production` environment (populates the Deployments tab). Uses the
  preinstalled `gh` CLI — no third-party release action.
- **`codeql.yml`**: CodeQL for `java-kotlin`, manual build mode
  (`assembleDebug`), on push/PR to `main` plus a weekly schedule.
- **`pages.yml`**: deploys `site/` (static landing page) to GitHub Pages via
  the Actions deployment path (`github-pages` environment).

### Security & dependencies
- `dependabot.yml`: weekly `gradle` + `github-actions` update PRs.
- Repo settings via API: Dependabot alerts + security updates, secret scanning
  + push protection, private vulnerability reporting.
- `SECURITY.md` policy.

### Team workflow
- Issue forms (`bug_report.yml`, `feature_request.yml`, `config.yml` pointing
  blank issues at Discussions), PR template, `CODEOWNERS`, `CONTRIBUTING.md`,
  MIT `LICENSE`, curated label set, `v1.1 — Checkout polish` milestone.
- Branch ruleset on `main`: require PRs and green CI status checks
  (0 required approvals so a solo maintainer can demo the merge flow;
  the demo script notes how teams raise this).

### App changes (additive only, away from the checkout bug path)
- `PriceFormatter.kt` + JUnit test on `main` so CI's test job exercises real
  tests; JUnit 4 added as `testImplementation`.
- Seeded PR branch `feature/discount-codes` adds `DiscountCodes.kt` + tests.

### Docs & demo
- `README.md`: status badges, ecosystem map, mermaid pipeline diagram,
  build/run instructions.
- `docs/DEMO_SCRIPT.md`: step-by-step walkthrough for the shareholder demo,
  including the iOS parallel (same concepts on macOS runners with
  Xcode/fastlane) and free-plan vs. paid-plan notes.
- `site/index.html`: minimal landing page served by GitHub Pages.

## Order of operations
File authoring → local Gradle verification → logical commits → flip repo
public + enable security settings → push `main` → verify workflow runs →
seed labels/milestone/issues → tag `v1.0.0` → verify release → open demo PR →
**ruleset last** (so setup pushes aren't blocked) → repo metadata.

## Out of scope
- Projects v2 board (`gh` token lacks `project` scope — command documented in
  the demo script instead).
- Instrumented/emulator tests, signed release builds with Play Console upload
  (mentioned in the demo script as the natural next steps).

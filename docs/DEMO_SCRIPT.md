# Shareholder Demo Script — GitHub for Mobile Teams

Repo: <https://github.com/bugbee-ai/sandbox-shop> · ~15 minutes
Everything below is already live — no setup needed on demo day. Have the repo
open in one tab and the [Actions tab](https://github.com/bugbee-ai/sandbox-shop/actions)
in another.

## 1. The front door (2 min) — repo home page

- Point at the **README badges**: CI passing, CodeQL passing, latest release.
  "You can judge the health of this project without opening a single file."
- Scroll to the **mermaid pipeline diagram** — GitHub renders it natively.
- Talking point: *one platform* holds the code, the automation, the security
  posture, and the team process. No Jenkins, no separate issue tracker.

## 2. CI on every change (3 min) — Actions tab

- Open the latest **CI** run. Show the **job graph**: wrapper validation →
  lint + tests in parallel → APK build.
- Click into the run **summary** — APK size, test results, and a downloadable
  `app-debug` artifact any tester can install. No developer machine involved.
- Live moment: press **Run workflow** (`workflow_dispatch`) and let it run in
  the background while you keep talking; come back to it green at the end.
- iOS parallel: identical concept — `runs-on: macos-latest`, Xcode +
  fastlane instead of Gradle. GitHub hosts the Macs.

## 3. Team workflow (3 min) — Issues + the open PR

- Open **Issues**: structured **issue forms** (bug report asks for device,
  severity, logcat). Show the milestone grouping (`v1.1 — Checkout polish`).
- Open the seeded **pull request** (`feature/discount-codes`): CI checks ran
  automatically, CODEOWNERS auto-requested review, template pre-filled the
  description.
- Try to merge → point out merging is gated on green checks. Then show
  Settings → Rules: `main` **requires a PR + passing CI** — nobody, including
  admins by default, pushes straight to production code. (Demo tip: teams
  normally also require 1–2 approving reviews; it's set to 0 here so a solo
  maintainer can demo the merge.)

## 4. Shipping (3 min) — Releases

- Open **Releases**: `v1.0.0` was published *by the robot* — auto-generated
  notes plus an installable APK, triggered by nothing more than
  `git tag v1.0.1 && git push --tags`.
- Show the **Deployments** panel (repo sidebar): the release ran against the
  `production` **environment**. Real teams add required reviewers to that
  environment — a human gate before anything ships.
- Production path: same workflow signs an AAB with keystore **secrets** stored
  in Actions and uploads straight to Play Console / TestFlight via fastlane.

## 5. Security, on by default (3 min) — Security tab

- **Code scanning**: CodeQL analyzes every push and PR, plus a weekly sweep.
- **Dependabot**: vulnerable-dependency alerts, plus the weekly update PRs
  visible in the PR list — dependency hygiene with zero human effort.
- **Secret scanning + push protection**: a leaked API key is blocked at
  `git push` time, before it ever lands in history.
- **Private vulnerability reporting**: researchers report privately via the
  Security tab (see `SECURITY.md`).

## 6. GitHub Pages (1 min)

- <https://bugbee-ai.github.io/sandbox-shop/> — the project site, deployed by
  the same Actions pipeline. Teams use this for docs, design systems, and
  test/coverage reports.

## Q&A crib notes

- **Cost:** everything shown is **free for public repos**. For private repos:
  Actions has a generous free tier (2,000 min/mo), then GitHub Team is
  $4/user/mo (adds branch protection on private repos); CodeQL/secret scanning
  on private repos is GitHub Advanced Security (Enterprise).
- **iOS specifics:** macOS runners are billed at 10× Linux minutes; fastlane
  is the standard signing/TestFlight tool; certificates live in Actions
  secrets. Everything else in this demo is identical.
- **Projects board:** to add a GitHub Projects (v2) board, run
  `gh auth refresh -s project` once, then
  `gh project create --owner bugbee-ai --title "Sandbox Shop Roadmap"`.
- **The checkout bug is intentional** (`BUGBEE-DEMO-BUG`) — it powers the
  Bugbee triage demo. Don't let anyone "helpfully" fix it live.

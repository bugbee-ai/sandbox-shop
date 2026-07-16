# Security Policy

## Reporting a vulnerability

Please use GitHub's **private vulnerability reporting** for this repository:
go to the **Security** tab → **Report a vulnerability**. Reports go directly
to the maintainers without creating a public issue.

Please do not open public issues for security problems.

## What's running automatically

- **CodeQL** scans every push and pull request to `main`, plus a weekly sweep.
- **Dependabot** raises alerts and update PRs for vulnerable Gradle and
  GitHub Actions dependencies.
- **Secret scanning with push protection** blocks commits containing
  credentials before they land.

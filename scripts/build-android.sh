#!/usr/bin/env bash
set -euo pipefail
repo_dir="$(cd "$(dirname "$0")/.." && pwd)"
for project in greeting happy-birthday compose-article task-manager compose-quadrant business-card; do
  (cd "$repo_dir/unit-01/$project" && ./gradlew --console=plain assembleDebug lintDebug)
done

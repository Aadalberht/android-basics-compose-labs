#!/usr/bin/env bash
set -euo pipefail
repo_dir="$(cd "$(dirname "$0")/.." && pwd)"
projects=(
  unit-01/greeting
  unit-01/happy-birthday
  unit-01/compose-article
  unit-01/task-manager
  unit-01/compose-quadrant
  unit-01/business-card
  unit-02/dice-roller
  unit-02/lemonade
  unit-02/tip-time
  unit-02/art-space
)
for project in "${projects[@]}"; do
  tasks=(assembleDebug lintDebug testDebugUnitTest)
  if [[ "$project" == "unit-02/tip-time" ]]; then
    tasks+=(assembleDebugAndroidTest)
  fi
  (cd "$repo_dir/$project" && ./gradlew --console=plain "${tasks[@]}")
done

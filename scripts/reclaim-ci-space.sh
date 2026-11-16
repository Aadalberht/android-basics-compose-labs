#!/usr/bin/env bash
set -euo pipefail

repo_dir="$(cd "$(dirname "$0")/.." && pwd)"
staging_dir="${RUNNER_TEMP:-/tmp}/android-lab-apks"
gradle_home="${GRADLE_USER_HOME:-$HOME/.gradle}"

rm -rf "$staging_dir"
mkdir -p "$staging_dir"

while IFS= read -r apk; do
  relative_path="${apk#"$repo_dir"/}"
  mkdir -p "$staging_dir/$(dirname "$relative_path")"
  cp "$apk" "$staging_dir/$relative_path"
done < <(find "$repo_dir/unit-01" "$repo_dir/unit-02" "$repo_dir/unit-03" \
  -path '*/app/build/outputs/apk/debug/app-debug.apk' -type f | sort)

find "$repo_dir/unit-01" "$repo_dir/unit-02" "$repo_dir/unit-03" \
  -type d \( -name build -o -name .gradle \) -prune -exec rm -rf {} +
rm -rf "$gradle_home/caches"

while IFS= read -r apk; do
  relative_path="${apk#"$staging_dir"/}"
  mkdir -p "$repo_dir/$(dirname "$relative_path")"
  cp "$apk" "$repo_dir/$relative_path"
done < <(find "$staging_dir" -name app-debug.apk -type f | sort)

echo "Preserved $(find "$staging_dir" -name app-debug.apk -type f | wc -l | tr -d ' ') debug APKs."
df -h "$repo_dir"

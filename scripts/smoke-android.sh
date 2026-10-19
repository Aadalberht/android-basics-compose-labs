#!/usr/bin/env bash
set -euo pipefail
repo_dir="$(cd "$(dirname "$0")/.." && pwd)"
mkdir -p "$repo_dir/unit-01/evidence/screenshots"
for project in greeting happy-birthday compose-article task-manager compose-quadrant business-card; do
  package="com.example.${project//-/}"
  adb install -r "$repo_dir/unit-01/$project/app/build/outputs/apk/debug/app-debug.apk"
  adb logcat -c
  adb shell am start -W -n "$package/.MainActivity"
  sleep 3
  adb exec-out screencap -p > "$repo_dir/unit-01/evidence/screenshots/$project.png"
  adb shell uiautomator dump /sdcard/window.xml
  adb pull /sdcard/window.xml "$repo_dir/unit-01/evidence/screenshots/$project.xml"
  if adb logcat -d -s AndroidRuntime:E | grep -q 'FATAL EXCEPTION'; then
    adb logcat -d -s AndroidRuntime:E
    exit 1
  fi
  adb shell am force-stop "$package"
done

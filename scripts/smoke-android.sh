#!/usr/bin/env bash
set -euo pipefail
repo_dir="$(cd "$(dirname "$0")/.." && pwd)"

run_app() {
  local unit="$1" project="$2" package="$3" expected="$4" tap_label="${5:-}" after_tap="${6:-}"
  local evidence="$repo_dir/$unit/evidence/screenshots"
  local xml="$evidence/$project.xml"
  mkdir -p "$evidence"

  adb install -r "$repo_dir/$unit/$project/app/build/outputs/apk/debug/app-debug.apk"
  adb logcat -c
  adb shell am start -W -n "$package/.MainActivity"
  sleep 2
  if ! adb shell dumpsys activity activities | grep -q "mResumedActivity.*$package"; then
    echo "The requested app is not in the foreground: $package"
    exit 1
  fi

  adb shell uiautomator dump /sdcard/window.xml >/dev/null
  adb pull /sdcard/window.xml "$xml" >/dev/null
  grep -Fq "$expected" "$xml"

  if [[ -n "$tap_label" ]]; then
    read -r tap_x tap_y < <(python3 "$repo_dir/scripts/ui-point.py" "$xml" "$tap_label")
    adb shell input tap "$tap_x" "$tap_y"
    sleep 2
    adb shell uiautomator dump /sdcard/window.xml >/dev/null
    adb pull /sdcard/window.xml "$xml" >/dev/null
    grep -Fq "$after_tap" "$xml"
  fi

  adb exec-out screencap -p > "$evidence/$project.png"
  if adb logcat -d -s AndroidRuntime:E | grep -q 'FATAL EXCEPTION'; then
    adb logcat -d -s AndroidRuntime:E
    exit 1
  fi
  adb shell am force-stop "$package"
}

run_app unit-01 greeting com.example.greeting "Hi, my name is Albert!"
run_app unit-01 happy-birthday com.example.happybirthday "Happy Birthday"
run_app unit-01 compose-article com.example.composearticle "Jetpack Compose tutorial"
run_app unit-01 task-manager com.example.taskmanager "All tasks completed"
run_app unit-01 compose-quadrant com.example.composequadrant "Text composable"
run_app unit-01 business-card com.example.businesscard "Albert"

run_app unit-02 dice-roller com.example.diceroller "Roll" "Roll" "Roll"
run_app unit-02 lemonade com.example.lemonade "Tap the lemon tree" "Lemon tree" "Keep tapping the lemon"
run_app unit-02 tip-time com.example.tiptime "Calculate Tip"
run_app unit-02 art-space com.example.artspace "Morning Over the Hills" "Next" "Quiet Geometry"

run_app unit-03 affirmations com.example.affirmations "I am strong."
run_app unit-03 courses com.example.courses "Architecture"
run_app unit-03 woof com.example.woof "Woof" "Show dog hobby" "Hide dog hobby"
run_app unit-03 superheroes com.example.superheroes "Superheroes"
run_app unit-03 thirty-days com.example.thirtydays "30 Days of Focus" "Show full tip" "Hide full tip"

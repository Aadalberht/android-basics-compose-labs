#!/usr/bin/env python3
"""Compile each standalone exercise, run it and compare its recorded output."""
from pathlib import Path
import os
import shutil
import subprocess
import sys

root = Path(__file__).resolve().parents[1]
compiler = os.environ.get('KOTLINC') or shutil.which('kotlinc')
if not compiler:
    sys.exit('Install Kotlin CLI or set KOTLINC to its executable path.')
java = str(Path(os.environ['JAVA_HOME']) / 'bin/java') if 'JAVA_HOME' in os.environ else 'java'
sources = sorted((root / 'unit-01/kotlin').rglob('*.kt'))
output = root / 'unit-01/kotlin/build/verification'
output.mkdir(parents=True, exist_ok=True)
for source in sources:
    jar = output / (source.stem + '.jar')
    subprocess.run([compiler, str(source), '-include-runtime', '-d', str(jar)], check=True)
    actual = subprocess.run([java, '-jar', str(jar)], check=True, capture_output=True,
                            text=True).stdout
    expected = source.with_suffix('.txt').read_text()
    if actual != expected:
        sys.exit(f'Output differs: {source.relative_to(root)}\n{actual}')
    print(f'PASS {source.relative_to(root)}')
print(f'{len(sources)} standalone Kotlin programs passed.')

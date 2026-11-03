#!/usr/bin/env python3
"""Print the center of the first UI Automator node matching text or description."""
from pathlib import Path
import re
import sys
import xml.etree.ElementTree as ET

if len(sys.argv) != 3:
    sys.exit('Usage: ui-point.py WINDOW.XML LABEL')

root = ET.parse(Path(sys.argv[1])).getroot()
label = sys.argv[2]
for node in root.iter('node'):
    if node.attrib.get('text') == label or node.attrib.get('content-desc') == label:
        numbers = [int(value) for value in re.findall(r'\d+', node.attrib.get('bounds', ''))]
        if len(numbers) == 4:
            print((numbers[0] + numbers[2]) // 2, (numbers[1] + numbers[3]) // 2)
            break
else:
    sys.exit(f'No UI node found for: {label}')

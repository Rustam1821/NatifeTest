#!/bin/bash
# prints the line of code number (takes into account .java and .kt files)
cd ..
find ./app "(" -name "*.java" -or -name "*.kt" ")" -print | xargs wc -l

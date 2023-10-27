#!/bin/bash
# This will attempt to auto-fix any errors and will report back any issues that
# could not automatically be fixed
cd ..
./gradlew ktlintFormat --stacktrace

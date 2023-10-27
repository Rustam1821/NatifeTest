#!/bin/bash
# This will run through your project and report back any errors which are found using
# the default ktlint-gradle plugin configuration.
cd ..
./gradlew ktlintCheck --stacktrace

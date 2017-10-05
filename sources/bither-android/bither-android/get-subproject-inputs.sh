#!/bin/bash

DEPS=explicit-dependencies

echo "Gathering outputs from the other subprojects to ${DEPS}..."
cp ../android-charts/build/intermediates/bundles/debug/classes.jar ${DEPS}/android-charts-classes.jar
cp ../wheel/build/intermediates/bundles/debug/classes.jar ${DEPS}/wheel-classes.jar

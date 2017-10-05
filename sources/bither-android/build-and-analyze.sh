#!/bin/bash

echo "Bither-Android: building android-charts..."
./gradlew :android-charts:assembleDebug
echo "Bither-Android: building bitherj..."
./gradlew :bitherj:jar
echo "Bither-Android: building wheel..."
./gradlew :wheel:assembleDebug
echo "Bither-Android: building bither-android..."
./gradlew :bither-android:assembleDebug
echo "Bither-Android: gathering JAR dependencies..."
cd bither-android && ./get-subproject-inputs.sh && cd ..
echo "Bither-Android: running analysis..."
./gradlew :bither-android:analyze

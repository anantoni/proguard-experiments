#!/bin/bash

echo "Running calculator without reflection handling"
./doop -a context-insensitive -i ../proguard-experiments/apkfromsource/calculator.apk --platform android_25_fulljars --id calculator --gen-proguard-keep --souffle-jobs 8 --cache > ../calculator_res.txt
echo "Finished calculator analysis"

echo "Running calculator with reflection handling"
./doop -a context-insensitive -i ../proguard-experiments/apkfromsource/calculator.apk --platform android_25_fulljars --id calculator-reflection --reflection-classic --gen-proguard-keep --souffle-jobs 8 --cache -reflection-classic > ../calculator_reflection.txt
echo "Finished calculator reflection analysis"

echo "GSON example without reflection handling"
./doop -a context-insensitive -i ../proguard-experiments/apkfromsource/gsonexample.apk --platform android_25_fulljars --id gsonexample --gen-proguard-keep --souffle-jobs 8 --cache > ../gson_res.txt
echo "Finished GSON example analysis"

echo "GSON example with reflection handling"
./doop -a context-insensitive -i ../proguard-experiments/apkfromsource/gsonexample.apk --platform android_25_fulljars --id gsonexample-reflection --reflection-classic --gen-proguard-keep --souffle-jobs 8 --cache > ../gson_reflection.txt
echo "Finished GSON example reflection analysis"

echo "Mercury SSH without reflection handling"
./doop -a context-insensitive -i ../proguard-experiments/apkfromsource/mercuryssh.apk --platform android_25_fulljars --id mercuryssh --gen-proguard-keep --souffle-jobs 8 --cache > ../mercuryssh_res.txt
echo "Finished mercury ssh analysis"

echo "Mercury SSH with reflection handling"
./doop -a context-insensitive -i ../proguard-experiments/apkfromsource/mercuryssh.apk --platform android_25_fulljars --id mercuryssh-reflection --reflection-classic --gen-proguard-keep --souffle-jobs 8 --cache > ../mercuryssh_reflection.txt
echo "Mercury SSH with reflection handling"

echo "Mintube without reflection handling"
./doop -a context-insensitive -i ../proguard-experiments/apkfromsource/mintube.apk --platform android_25_fulljars --id mintube --gen-proguard-keep --souffle-jobs 8 --cache > ../mintube_res.txt
echo "Finished mintube analysis"

echo "Mintube with reflection handling"
./doop -a context-insensitive -i ../proguard-experiments/apkfromsource/mintube.apk --platform android_25_fulljars --id mintube-reflection --reflection-classic --gen-proguard-keep --souffle-jobs 8 --cache > ../mintube_reflection.txt
echo "Finished mintube reflection analysis"

echo "Radiodroid without reflection handling"
./doop -a context-insensitive -i ../proguard-experiments/apkfromsource/radiodroid.apk --platform android_25_fulljars --id radiodroid --gen-proguard-keep --souffle-jobs 8 --cache > ../radiodroid_res.txt
echo "Finished radiodroid analysis"

echo "Radiodroid with reflection handling"
./doop -a context-insensitive -i ../proguard-experiments/apkfromsource/radiodroid.apk --platform android_25_fulljars --id radiodroid-reflection --reflection-classic --gen-proguard-keep --souffle-jobs 8 --cache > ../radiodroid_reflection.txt
echo "Finished radiodroid without reflection handling"

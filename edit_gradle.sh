#!/bin/bash

if [ "$*" == "noproguard" ]; then
    echo "no proguard"
elif [ "$*" == "default" ]; then
    echo "default"
elif [ "$*" == "defaultdoop" ]; then
    echo "default doop"
elif [ "$*" == "defaultdoopreflection" ]; then
    echo "default doop reflection"
elif [ "$*" == "doop" ]; then
    echo "doop"
elif [ "$*" == "doopreflection" ]; then
    echo "doop reflection"
elif [ "$*" == "defaultopt" ]; then
    echo "optimized default"
elif [ "$*" == "defaultoptdoop" ]; then
    echo "optimized default doop"
elif [ "$*" == "defaultoptdoopreflection" ]; then
    echo "optimized default doop reflection"
elif [ "$*" == "optdoop" ]; then
    echo "optimized doop"
elif [ "$*" == "optdoopreflection" ]; then
    echo "optimized doop reflection reflection"
fi

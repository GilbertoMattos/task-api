#!/usr/bin/env bash

JAVA_HOME=/home/ti-0243713/.jdks/openjdk-21.0.2 \
    ./mvnw \
    -U clean install \
    -Dmaven.test.skip=true \
    -Dmaven.compiler.source=1.8 \
    -Dmaven.compiler.target=1.8

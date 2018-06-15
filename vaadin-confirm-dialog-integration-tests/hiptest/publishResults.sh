#!/bin/bash

hiptest-publisher -c hiptest-publisher.config -p "../target/failsafe-reports/TEST-*hiptest.*.xml" --token=$1 --test-run-id=$2

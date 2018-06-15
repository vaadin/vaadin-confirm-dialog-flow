#!/bin/bash

hiptest-publisher -c hiptest-publisher.config --only=tests --overriden-templates=templates --filename-pattern=%sIT.java --token=$1 --test-run-id=$2

#!/bin/bash

podman run --rm -p 5672:5672 -p 15672:15672 --hostname rabbit-local --name rabbit rabbitmq:3-management


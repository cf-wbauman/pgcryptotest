#!/bin/bash

docker run --rm -e POSTGRES_USER=user -e POSTGRES_PASSWORD=password -e POSTGRES_DB=testdb -p 5440:5432 postgres:14.13-alpine
#!/usr/bin/env bash
export AUTHORIZATION_CODE_LOGIN_PASSWORD=normal123
export TOKEN=$(./authorization_code_login.sh -a "http://localhost:8080" -r "jics" -c "frontend" -l "http://localhost:9000" -u "normal") && curl http://localhost:8081/home -H "Accept: application/json" -H "Authorization: Bearer ${TOKEN}" && echo -e ""

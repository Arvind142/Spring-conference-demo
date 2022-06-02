#!/usr/bin/env bash
echo "####################################################################################################################"
echo ">>spinning up containers"
docker-compose up -d > /dev/null
echo ">>pause for few seconds until database service is up and running"
sleep 15
echo ">>creating tables"
docker cp ./create_tables.sql postgres-demo:/create_tables.sql
docker exec -it postgres-demo psql -d conference_app -f create_tables.sql -U postgres
echo ">>adding records to tables"
docker cp ./insert_data.sql postgres-demo:/insert_data.sql
docker exec -it postgres-demo psql -d conference_app -f insert_data.sql -U postgres
sleep 5
echo "####################################################################################################################"
echo ">>database should be up and running use below conf for postgres database"
echo "---------------------------------------------------------------------------------"
echo "| JDBC URL: jdbc:postgresql://localhost:5432/conference_app                     |"
echo "| Username: postgres                                                            |"
echo "| Password: new_se3ret_password_test                                            |"
echo "|-------------------------------------------------------------------------------|"
echo "| Adminer UI: http://localhost:5001  - UI to peform DB operations               |"
echo "| Details:                                                                      |"
echo "|   System:   PostgreSQL                                                        |"
echo "|   Server:   postgres-demo                                                     |"
echo "|   username: postgres                                                          |"
echo "|   password: new_se3ret_password_test                                          |"
echo "|   Database: conference_app                                                    |"
echo "---------------------------------------------------------------------------------"
echo "####################################################################################################################"
echo ">>to stop everything run 'docker-compose down' command "
echo "####################################################################################################################"
# compare-kafka

Compare the performance of the system with and without kafka

```

docker compose up --build -d --force-recreate

# Producer
http://localhost:8100/swagger-ui/index.html
# Consumer Mongo
http://localhost:8200/swagger-ui/index.html
# Consumer MSSQL
http://localhost:8201/swagger-ui/index.html
```

# Configuration
## consumer-mssql
- Update the ipaddress, username and password in application.properties
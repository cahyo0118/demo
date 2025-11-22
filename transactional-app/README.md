# Test Case 1: Transaction Rollback Demo

### success
```shell
curl --location --request POST 'http://localhost:8081/accounts/transfer?from=1&to=2&amount=100' \
--data ''
```

### failed
```shell
curl --location --request POST 'http://localhost:8081/accounts/transfer?from=1&to=2&amount=600'
```
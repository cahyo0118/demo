# Test Cases for Transactional Application

## Test Case 1: Transaction Rollback Demo

### success
```shell
curl --location --request POST 'http://localhost:8081/accounts/transfer?from=1&to=2&amount=100' \
--data ''
```

### failed
```shell
curl --location --request POST 'http://localhost:8081/accounts/transfer?from=1&to=2&amount=600'
```

## Test Case 2: Optimistic Locking Demo

### User A (slow request, loses the race)
```shell
curl -X POST "http://localhost:8081/products/1/update?stock=9&delay=3000"
```

### User B (faster request, wins the race)
```shell
curl -X POST "http://localhost:8081/products/1/update?stock=9&delay=3000" & curl -X POST "http://localhost:8081/products/1/update?stock=8&delay=1000" & wait
```
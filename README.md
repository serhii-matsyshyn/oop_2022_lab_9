# oop_2022_lab_9 Flower Store Reboot

Made by Serhii Matsyshyn

### Available online at https://flower-store-serhii-matsyshyn.herokuapp.com/


## Endpoints that are available:
- [GET] /api/flowers-list
- [POST] /api/add-flower

- [GET] /api/delivery/all-delivery-types
- [GET] /api/payment/all-payment-types
- [GET] /api/order/create/randomFlowersPreOrder/{flowersCount}
- [POST] /api/order/create
- [GET] /api/order/{orderId}/set-order-processed
- [POST] /api/order/{orderId}/addUser
- [POST] /api/order/{orderId}/removeUser
- [GET] /api/users/all
- [POST] /api/users/add
- [GET] /api/get-all-orders
- [GET] /api/get-order/{orderId}
- [GET] /api/delivery/deliver/{orderId}
- [GET] /api/payment/pay/{orderId}



## Tests coverage:
88% classes, 48% lines

## How to run:
Setup DB with Docker
```bash
docker run --name oop-course -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 postgres
```
Run application
```bash
docker start oop-course
```

## !!! Important:
### Use updated file [test.http](src/test/test.http) to test endpoints (on localhost). Replace template values with your own (e.g. orderId that is generated during order, etc.)
### Use updated file [test_heroku.http](src/test/test_heroku.http) to test endpoints (on heroku). Replace template values with your own (e.g. orderId that is generated during order, etc.)

### Test manually
#### Test getting flowers list from db:

GET http://localhost:8080/api/flowers-list  


#### Test adding flower to db:

POST http://localhost:8080/api/add-flower  
Content-Type: application/json  

{
"flowerType": "ROSE",
"color": "RED",
"sepalLength": 150,
"price": 100
}


POST http://localhost:8080/api/add-flower  
Content-Type: application/json  

{
"flowerType": "CHAMOMILE",
"color": "RED",
"sepalLength": 150,
"price": 100
}

#### Create order:
**IMPORTANT** - you need to add flowers to db before creating order,
since we check if flower available in db before creating order

POST http://localhost:8080/api/order/create  
Content-Type: application/json  

[
{
"flowerType": "ROSE",
"color": "RED",
"price": 10,
"quantity": 1
},
{
"flowerType": "CHAMOMILE",
"color": "RED",
"price": 10,
"quantity": 1
}
]

### User and notifier:
#### User add to db:
POST http://localhost:8080/api/users/add
Content-Type: application/json

{
"email": "email@email.email",
"dob": "1990-01-01"
}

#### Get all users:
GET http://localhost:8080/api/users/all

#### User subscribe to notifier:
When user subscribe to notifier, he will receive email (or receive information in other way) when order is processed.  

POST http://localhost:8080/api/order/{orderId}/addUser
Content-Type: application/json

{
"email": "email@email.email",
"dob": "1990-01-01"
}

#### Set order status to processed:
When order status is set to processed, user will receive email (or receive information in other way) about it.  
It uses Observer pattern to notify Customer when Order is processed.  
GET http://localhost:8080/api/order/{orderId}/set-order-processed

Example information in email:
```
User email@email.email was notified that: Order 31daf4cc-693b-46db-a8f4-610ac10cb899 is processed
```


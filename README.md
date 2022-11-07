# oop_2022_lab_8 Flower Store Continue

Made by Serhii Matsyshyn

## Endpoints that are available:
- [GET] /api/flowers-list
- [POST] /api/add-flower

- [GET] /api/delivery/all-delivery-types
- [GET] /api/payment/all-payment-types
- [GET] /api/order/create/randomFlowersPreOrder/{flowersCount}
- [POST] /api/order/create

- [GET] /api/get-all-orders
- [GET] /api/get-order/{orderId}
- [GET] /api/delivery/deliver/{orderId}
- [GET] /api/payment/pay/{orderId}



## Tests coverage:
85% classes, 47% lines

## How to run:
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
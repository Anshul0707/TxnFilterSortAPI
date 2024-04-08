# TxnFilterSortAPI

## Project Overview:

The project is a RESTful API service built using Spring Boot framework to manage transactions. It provides endpoints for
adding transactions, retrieving transactions within a specified amount range, and fetching transactions sorted by their
amount.

## Installation

1. Clone the repository.
2. Set up the SQL database and tables.
3. Run the HTTP server.

## API Contracts

### 1.Add Transaction

- Method: POST
- Endpoint: `http://localhost:8080/txn/add`
- Request Body:

```
    {
    "txnId": "74001755",
    "customerName": "John",
    "service": "UPI",
    "amount": 3548,
    "gst": 0.18,
    "commission": 10
    }
```

- Response:Status: 200 OK

### 2.Get Transactions by Amount Range

- Method: GET
- Endpoint: `http://localhost:8080/txn/amount/{initialRange}/{finalRange}`
- Request Parameters:
    - {initialRange}: Initial amount range (float)
    - {finalRange}: Final amount range (float)
- Response Body:

```java
[
        {
        "txnId":"74001755",
        "customerName":"John",
        "service":"UPI",
        "amount":3548,
        "gst":0.18,
        "commission":10
        },
        {
        "txnId":"74002423",
        "customerName":"James",
        "service":"UPI",
        "amount":758,
        "gst":0.36,
        "commission":20
        }
 ]

```

- Response:Status: 200 OK

### 3.Get Transactions Sorted by Amount

- Method: GET
- Endpoint: `http://localhost:8080/txn/sort/amount`
- Response Body:

```java
[
        {
        "txnId":"74002423",
        "customerName":"James",
        "service":"UPI",
        "amount":758,
        "gst":0.36,
        "commission":20
        },
        {
        "txnId":"74001755",
        "customerName":"John",
        "service":"UPI",
        "amount":3548,
        "gst":0.18,
        "commission":10
        }
 ]
```

- Response:Status: 200 OK

## Additional Notes:

Ensure that you have PostgreSQL installed and configured with the appropriate database schema and credentials as per the
application's requirements.
Update the application.properties file with the correct database connection details before running the application.
Use an API testing tool like Postman to test the endpoints with sample requests and verify the responses.

## Contact

For any inquiries or feedback, please contact us at  `anshul.markwade786@gmail.com`

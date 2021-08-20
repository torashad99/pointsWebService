# pointsWebService

Web service to manage points for a rewards company

## Instructions

### 1. Installing Maven and Postman

We need to have Maven installed on your local machine in order to run the web service. If your machine does not have Maven installed, please look at how to install Maven [here](https://www.baeldung.com/install-maven-on-windows-linux-mac). We also need to send/receive API requests; We could use curl but there's an easier, better and more visually appealing API handler called Postman that does the job as well. Download Postman for your machine [here](https://www.postman.com/downloads/).

### 2. Running the Web Service

To run the web service, clone this repository on to your machine. Then open your terminal on your local machine, and navigate to where the contents of the web service exists. Then enter,

`./mvnw spring-boot:run`

Wait until you see the `Started PointsWebServiceApplication` line, after that open up Postman and select the "HTTP Requests" button. You can see a Dropdown and Enter Requests URL. Dropdown has the 'GET' or 'POST' request identifiers and valid requests to enter in the field are given below. For sending body information, click on "Body" tab under the Requests URL field and underneath the tab click on "raw"; after that a blue dropdown menu will appear on the right after "GraphQL", click on the dropdown and select "JSON". 

## Valid Requests

### Add transactions for a specific payer and date

#### Request : `POST localhost:8080/points/api`

This request will add transactions, given points, payer and timestamp on the request body.

Request Body Example : ```
             {
                "payer" : "CompanyA",
                "points" : 2000,
                "Timestamp" : "2020-12-02T17:30:00Z"
              }
        ```

Response Body Example : ```Transaction is Added``` / ```Transaction is added, sorted by timestamps in ascending order``` / ```Cannot enter 0. Please enter a positive or negative value```

### Spend points 

#### Request : `POST localhost:8080/points/api/spend`

This request will spend points based on the oldest timestamp first until points are over. If points cannot be spent, it returns an empty list

Request Body Example : ```{ "points": 5000 }```

Response Body Example : ```[ {"payer" : "CompanyA", "points" : -2500} , {"payer" : "CompanyB", "points" : -2500} ]``` / ``` [] ```

### Get points balance

#### Request : `GET localhost:8080/points/api/balance`

This request will get point balances by company 

Request Body Example : ```None```

Response Body Example : ``` { "CompanyA": 500, "CompanyB": 300, "CompanyC": 200 } ```

### Get all transactions

#### Request : `GET localhost:8080/points/api`

This request will get all transactions added previously, sorted by timestamp in ascending order. Returns an empty list if no transactions are added

Request Body Example : ```None```

Response Body Example : ```[ { "payer": "CompanyA", "points": 250, "timestamp": "2020-10-31T18:00:00Z" }, { "payer": "CompanyB", "points": 700, "timestamp": "2020-11-19T14:00:00Z" } ]``` / ``` [] ```

# RentCar

<div align="center">
  <img src="https://github.com/krishna98oza/shocking-grade-9442/assets/115473268/f878bfde-8480-465a-9b68-a58485991fa2" alt="Rentkar Logo">
</div>


# REST API for Online Cab Booking Application

* We have created a REST API for an online cab booking application that can be used by 
  customers to login into their profile, update their information and book cabs, by a driver 
  to log in and update their details along with their cab details and accept a ride from the 
  customer. All this is overlooked by the admin who can also login and update their 
  information as well as access the data in the application. We have implemented data and 
  user validation at every step, for every user. 

* Customer should be able to view the list of available cabs.

* Customer should be able to book a cab for the desired location from a specific site. 

* Admin should be able to perform the below operations:

      1. Cab Management 
      2. Driver Management
      3. Booking Management

## Tech Stack:

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Lombok
* Swagger

## Modules:

* Login Module
* Admin Module
* Customer Module
* Driver Management Module
* Cab Management Module
* Booking Management Module

## Contributors:

* [Krishna Shrinivas Oza](https://github.com/krishna98oza)
* [Umesh Kumar Gupta](https://github.com/Umesh8878)
* [Navneet Srivastava](https://github.com/Navneet3009)
* [Rajvardhan Naik](https://github.com/shisui53)

## Installation & Run

* Before running the API server, you should update the database config inside the [application.properties](https://github.com/krishna98oza/shocking-grade-9442/blob/main/RentCar/pom.xml) file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/rentcar
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root

```

## Swagger Deployed link
http://localhost:8080/swagger-ui/index.html#/

### Sample API Response for User Login

`POST   localhost:8080/Userlogin/Login`

* Request Body

```
    {
        "email": "umesh@gmail.com",
        "password": "umesh"
    }
    
    {
        "email": "umesh@gmail.com",
        "password": "umesh"
    }
    
```
 
### E-R Diagram Of Online Cab Booking Application
---

<img src="https://user-images.githubusercontent.com/101389007/233461279-5b887298-050a-45f0-adcd-671add82e5ad.png">


---

## Swagger UI

---

![db](https://github.com/krishna98oza/shocking-grade-9442/assets/115473268/d2a43f79-69c5-4fae-aa2e-d4a0880d4662)


---

### Login Controller

---

![login_controller](https://github.com/krishna98oza/shocking-grade-9442/assets/115473268/100d05ef-dbd3-47dd-b0fb-fb8cfbffe6c0)

---

### Admin Controller

---

![admin_controller](https://github.com/krishna98oza/shocking-grade-9442/assets/115473268/9ebb60d0-5e38-4845-85d5-10ece8a69aef)


---

### Customer Controller

---

![customer_controller](https://github.com/krishna98oza/shocking-grade-9442/assets/115473268/69a993c3-0f22-4213-80f7-9e1ac3136096)


---

### Driver Controller

---

![driver-controller](https://github.com/krishna98oza/shocking-grade-9442/assets/115473268/831214f4-e97d-47db-9109-eb7d201f2d75)


---

### Cab Controller

---

![cab_controller](https://github.com/krishna98oza/shocking-grade-9442/assets/115473268/17fe5844-4e18-43e6-a49a-c543c82796d3)


---

### TripBooking Controller

---

![trip-controller](https://github.com/krishna98oza/shocking-grade-9442/assets/115473268/5c8f0a4a-f34e-41d2-bd4f-e6e450ecd103)


---

## Thank You for Visiting
 

# Event Management System

A full-stack **Event Management System** built using **Java Spring Boot**, **Thymeleaf**, and **MySQL**. This application allows users to view and book events, while admins can manage events, users, and bookings through an admin dashboard.

---

## 🚀 Features

### 👤 User Features

* User registration and login
* View available events
* Book events
* View booking history

### 🛠️ Admin Features

* Admin login
* Create, update, and delete events
* View all users
* View all bookings
* Dashboard with statistics:

  * Total events
  * Total users
  * Total bookings

### 📊 Dashboard Highlights

* Cards displayed side-by-side (Bootstrap grid)
* Booking list showing which user booked which event
* Clean and responsive UI

---

## 🧰 Tech Stack

### Backend

* Java 17+
* Spring Boot
* Spring MVC
* Spring Data JPA
* Hibernate

### Frontend

* Thymeleaf
* HTML5
* CSS3
* Bootstrap 5

### Database

* MySQL

### Tools

* Maven
* Git
* IntelliJ IDEA / Eclipse

---

## 🗂️ Project Structure

```
Event-Management-System
│
├── src/main/java
│   └── com/example/eventmanagementsystem
│       ├── controller
│       ├── service
│       ├── repository
│       ├── entity
│       └── config
│
├── src/main/resources
│   ├── templates
│   │   ├── admin
│   │   ├── user
│   │   └── auth
│   ├── static
│   │   ├── css
│   │   └── js
│   └── application.properties
│
├── pom.xml
└── README.md
```

---

## 🧑‍💻 Entities

* **User** – stores user details and roles
* **Event** – stores event information
* **Booking** – maps users to events (Many-to-One relationships)

---

## 🔗 Database Relationships

* One **User** → Many **Bookings**
* One **Event** → Many **Bookings**
* Booking acts as a junction between User and Event

---

## ⚙️ Configuration

### application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/eventmanagementsystem
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

spring.thymeleaf.cache=false
server.port=8080
```

---

## ▶️ How to Run the Project

1. Clone the repository

   ```bash
   git clone https://github.com/your-username/event-management-system.git
   ```

2. Import the project into IntelliJ IDEA / Eclipse

3. Create a MySQL database:

   ```sql
   CREATE DATABASE eventmanagementsystem;
   ```

4. Update database credentials in `application.properties`

5. Run the application

6. Open browser and visit:

   ```
   http://localhost:8080
   ```

---

## 🔐 Authentication & Authorization

* Role-based access (ADMIN / USER)
* Admin pages protected
* Users can only book and view their own bookings

> ⚠️ Note: Spring Security can be integrated or customized as per project requirements.

---

## 🧪 Future Enhancements

* Email notification on booking
* Event image upload
* Pagination and search
* JWT-based authentication
* Payment gateway integration
* Event category and filters

---

## 📸 Screenshots

*Add screenshots of:*

* Login Page
* User Dashboard
* Admin Dashboard
* Event List
* Booking List

---

## 🤝 Contributing

Contributions are welcome!

1. Fork the repository
2. Create a new branch
3. Commit your changes
4. Open a pull request

---

## 📄 License

This project is licensed under the MIT License.

---

## 👨‍💻 Author

**Ramesh**
Java Full Stack Developer

---

⭐ If you like this project, give it a star!

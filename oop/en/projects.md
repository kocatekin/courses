# OOP Project Examples for Students

This document provides **ready-to-use project ideas** for your Object-Oriented Programming final project. Each example follows a clear structure so you know exactly what is required.

Feel free to choose **any** project from this list or use these as inspiration to create your own.

---

# 📘 Structure of Each Project

Every project includes:

* **Description**
* **Required Classes**
* **OOP Requirements**
* **Minimum Features**
* **Optional Advanced Features**

---

# ⭐ Project Example 1: Library Management System

### **Description**

A system to manage books and members. Users borrow and return books. The system tracks book availability.

### **Required Classes**

* Book
* Member
* StudentMember (inherits Member)
* Loan
* LibraryManager

### **OOP Requirements**

* Encapsulation: private fields, getters/setters
* Inheritance: Member → StudentMember
* Polymorphism: `calculateFee()` overridden
* Interface: `Searchable`

### **Minimum Features**

* Add/remove books
* Search books
* Borrow/return books
* Track availability

### **Optional Features**

* File storage
* Late fee calculation
* Librarian login system

---

# ⭐ Project Example 2: Online Food Ordering System

### **Description**

A system where customers can browse menus, add items to a cart, and place orders.

### **Required Classes**

* MenuItem
* User
* Customer (inherits User)
* Order
* Restaurant

### **OOP Requirements**

* Inheritance: User → Customer
* Encapsulation for sensitive data (address, phone)
* Polymorphism: different payment types
* Interface: `Orderable`

### **Minimum Features**

* View menu
* Add items to cart
* Place order
* Display order summary

### **Optional Features**

* Different payment methods
* Restaurant ratings
* Discounts or coupon codes

---

# ⭐ Project Example 3: Student Course Registration System

### **Description**

A system for students to enroll in courses and track their registered classes.

### **Required Classes**

* Student
* Course
* Instructor
* Registration
* CourseCatalog

### **OOP Requirements**

* Inheritance: Student → GraduateStudent
* Polymorphism: overridden `calculateTuition()`
* Interface: `Registrable`

### **Minimum Features**

* Add/remove courses
* View course list
* Register for courses
* Prevent duplicate registration

### **Optional Features**

* GPA calculation
* Instructor assignment
* Time conflict checking

---

# ⭐ Project Example 4: Hotel Reservation System

### **Description**

A booking system for customers to reserve rooms with different room types.

### **Required Classes**

* Room
* Reservation
* Customer
* Payment
* Hotel

### **OOP Requirements**

* Inheritance: Room → DeluxeRoom / StandardRoom
* Polymorphism: room price calculation
* Interface: `Reservable`

### **Minimum Features**

* Search available rooms
* Book a room
* Cancel reservation
* View booking details

### **Optional Features**

* Seasonal pricing
* Room service ordering
* Loyalty points

---

# ⭐ Project Example 5: Car Rental System

### **Description**

A system for managing car rentals, including availability and customer bookings.

### **Required Classes**

* Car
* Rental
* Customer
* Payment
* CarInventory

### **OOP Requirements**

* Inheritance: Car → ElectricCar / GasCar
* Polymorphism: `calculateRentalFee()`
* Interface: `Rentable`

### **Minimum Features**

* Add/remove cars
* Rent car
* Return car
* Display available cars

### **Optional Features**

* Fuel cost calculation
* Damage reporting
* Search filters (brand, fuel type)

---

# ⭐ Project Example 6: Banking System

### **Description**

A simple banking system where users can perform account operations.

### **Required Classes**

* Account
* SavingsAccount (inherits Account)
* CheckingAccount (inherits Account)
* Transaction
* Bank

### **OOP Requirements**

* Polymorphism: overridden `withdraw()` behavior
* Encapsulation of balance
* Interface: `Transferable`

### **Minimum Features**

* Deposit
* Withdraw
* Transfer
* View transactions

### **Optional Features**

* Monthly report
* Interest calculation
* Loan system

---

# ⭐ Project Example 7: Inventory Management System

### **Description**

A system to track products, stock levels, and supplier information.

### **Required Classes**

* Product
* Supplier
* Inventory
* Order
* StockManager

### **OOP Requirements**

* Encapsulation: product details
* Inheritance: Product → PerishableProduct
* Interface: `Storable`

### **Minimum Features**

* Add/remove product
* Update stock
* Search product
* Display low stock items

### **Optional Features**

* Automatic reorder generation
* Price analytics
* File-based storage

---

# ⭐ Project Example 8: Quiz / Exam System

### **Description**

A system where students take quizzes and receive scores.

### **Required Classes**

* Question
* MultipleChoiceQuestion
* TrueFalseQuestion
* Quiz
* Student

### **OOP Requirements**

* Inheritance: Question hierarchy
* Polymorphism: overridden `checkAnswer()`
* Interface: `Gradable`

### **Minimum Features**

* Load questions
* Take quiz
* Calculate score
* Show results

### **Optional Features**

* Timer functionality
* Random question order
* Difficulty levels

---

# ⭐ Project Example 9: Task & Project Management Tool

### **Description**

A simple system for creating tasks and organizing projects.

### **Required Classes**

* Task
* User
* Project
* Deadline
* Notification

### **OOP Requirements**

* Encapsulation of deadlines & priorities
* Inheritance: Task → TimedTask
* Interface: `Completable`

### **Minimum Features**

* Create task
* Assign task to project
* Mark task as completed
* View upcoming tasks

### **Optional Features**

* Priority levels
* Reminders
* File export

---

# ⭐ Project Example 10: Movie Ticket Booking System

### **Description**

A system to browse movies, select seats, and book tickets.

### **Required Classes**

* Movie
* ShowTime
* Seat
* Booking
* Customer

### **OOP Requirements**

* Inheritance: Movie → 3D / 2D Movie
* Polymorphism: pricing differences
* Interface: `Bookable`

### **Minimum Features**

* List movies
* Select showtime
* Choose seats
* Confirm booking

### **Optional Features**

* Seat map visualization
* Discounts
* Booking history


Good luck and have fun building your final project!

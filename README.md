# Project Introduction
Restaurants are an indispensable part of modern human life, it is a place where people come to enjoy delicious food, meet friends, date couples, organize parties and events, and relax after a period of earning money. Most customers go to restaurants to enjoy delicious food, comfortable space as well as enthusiastic service and the best service. To meet those problems, restaurants need to equip themselves with the most appropriate and modern management systems. Restaurant management systems become an important factor to help restaurants compete and develop. Realizing the need for equipment, our team has used the knowledge learned along with our understanding to build and develop the "Restaurant Management" system software, mainly focusing on storage; human resource management, customers; revenue management; Allow customers to order at the table and develop an interface that is easy to interact with users and customers.
# Project Overview

**Object-Oriented Design for the Restaurant Management Problem**

1. **Identify the main classes**

   When designing a restaurant management system with object orientation, the following basic classes are defined:

   - **Employee**
     - **Attributes**: **Employee ID**, **name**, **address**, **phone number**, **position**, **salary**.
     - **Methods**: **Update information**.

   - **Customer**
     - **Attributes**: **Customer ID**, **name**, **address**, **phone number**.
     - **Methods**: **Update information**, **view order history**.

   - **Dish**
     - **Attributes**: **Dish ID**, **name**, **price**, **ingredients**, **dish type**.
     - **Methods**: **Update information**.

   - **Table**
     - **Attributes**: **Table ID**, **number of seats**, **status** (**empty**, **occupied**).
     - **Methods**: **Update status**.

   - **Bill**
     - **Attributes**: **Bill ID**, **date**, **customer**, **employee**, **dish list**, **total amount**.
     - **Methods**: **Calculate total amount on the bill**.

2. **Establish relationships between classes**

   - **Employee and Bill**: One **employee** can create multiple **bills**.
   - **Customer and Bill**: One **customer** can have multiple **bills**.
   - **Dish and Bill**: One **bill** can include multiple **dishes**.
   - **Table and Bill**: One **table** can be linked with multiple **bills** (if customers change tables).

3. **Supporting classes (if any)**

   - **Ingredient**: Manages ingredients for each **dish**.
   - **Menu**: Manages the list of **dishes**.
   - **Supplier**: Manages suppliers of **ingredients**.

4. **Example class diagram**

5. **Main functions of the system**

   - **Employee management**: **Add**, **edit**, **delete**, **search for employees**.
   - **Customer management**: **Add**, **edit**, **delete**, **search for customers**.
   - **Dish management**: **Add**, **edit**, **delete**, **search for dishes**.
   - **Table management**: **Update table status**, **arrange tables**.
   - **Bill management**: **Create new bills**, **edit bills**, **view bill history**.
   - **Reporting**: **Generate sales reports**, **inventory reports**.

---

Dish management: Add, edit, delete, search for dishes.
Table management: Update table status, arrange tables.
Bill management: Create new bills, edit bills, view bill history.
Reporting: Generate sales reports, inventory reports.
# Project Objective
Building a Restaurant Management System designed with object orientation in a 3-layer model in a professional, flexible way, able to manage and store a large amount of data. The system helps users more easily organize and manage Customer data, manage Table Reservations, manage Menus, ... and much more.
# ERD Model 
![image](https://github.com/user-attachments/assets/14ef617d-8ff5-43c8-b2bd-eeb013b9912c)

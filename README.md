# Java Sample Employee Data

## Introduction

This project is used to introduce Java Spring REST API CRUD applications. As such it is a small application showing just the code that is needed to explain the topic.

## Database layout

The table layouts are as follows:

- Employee is the driving table
- Email has a Many-To-One relationship with Employee. Each employee has many emails. Each email has only one employee.
- Jobtitles has a Many-To-Many relationship with Employee

![Image of Database Layout](sampleemps-db.png)

Three different applications exist

- sampleemps_model - Includes just the modeling of the data
- sampleemps_read - Includes only reading data
- sampleemps_delete_save_update - Finishes the CRUD application by adding Creating, Updating, and Deleting
- sampleemps_data_modeling - adds auditing fields and more to the CRUD application

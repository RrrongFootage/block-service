About The Project
guud-assessment

Spring Boot Application with RestController

Exposing endpoints that provide the following:

◦ Schedule
▪ retrieve single by ID
▪ retrieve a list of schedules that contain service blocks within a specified date
range.
▪ create
▪ archive

◦ Place
▪ retrieve single by ID
▪ retrieve a list of all items
▪ create
▪ update: label, latitude, longitude
▪ archive

◦ Service Block
▪ retrieve single by ID
▪ retrieve a list of service blocks that fall within a specified date range.
▪ create
▪ update: start date, end date
▪ assign to schedule: given a schedule and a list of service blocks, creates the
association between these records, this same endpoint must also be able to
handle the removal of a service block from a schedule.


Postgres Database is used for the entities.
Build with

    Spring boot
    Java8/Java11 compitable
    Maven

Getting Started

Follow the below steps to get started.
Installation

    Clone the repo or download the application

    https://github.com/RrrongFootage/block-service

    Install Maven dependencies

    mvn clean install

Usage

    mvn spring-boot:run (To start the app).

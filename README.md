## Table of Contents
1. [Project Overview](#project-overview)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Installation and Setup](#installation-and-setup)
5. [Usage](#usage)
6. [How to Build the JAR File](#how-to-build-the-jar-file)
7. [Contributing](#contributing)

## Project Overview

The **University Management System** is a beautiful Java project designed using **AWT** (Abstract Window Toolkit) and **Swing** for creating graphical user interfaces. This application allows various operations related to university management, including:

- Adding students and faculty members
- Applying for leaves
- Managing examination marks
- Processing fee payments

This project provides an efficient way to handle university administrative tasks and can be packaged as a JAR file for easy execution as a desktop application.

## Features

- User-friendly graphical interface for easy navigation and operations.
- Add, update, and delete student and faculty records.
- Leave application management for students and faculty.
- Examination marks management with options for input and report generation.
- Fee payment processing with tracking capabilities.
- JAR file creation for running the application on any compatible Java environment.

## Technologies Used

- **Programming Language**: Java
- **GUI Framework**: AWT, Swing
- **Database**: MySQL
- **IDE**: IntelliJ IDEA / Eclipse
- **Build Tool**: Apache Maven (if applicable)

## Installation and Setup

To set up the University Management System locally, follow these steps:

1. **Clone the repository:**
    ```bash
    git clone https://github.com/palpratik56/University-Management-System.git
    ```

2. **Navigate to the project directory:**
    ```bash
    cd University-Management-System
    ```

3. **Install MySQL**: Ensure you have MySQL installed and running. Create a database for the project.

4. **Set up the database**: 
   - Import the SQL scripts provided in the `db` folder to set up the necessary tables.

5. **Configure database connection**: 
   - Open the configuration file (if applicable) and set your database credentials (username and password).

## Usage

To run the application:

1. Open the project in your preferred Java IDE (IntelliJ IDEA, Eclipse, etc.).
2. Run the main class `UniversityManagementSystem.java`.
3. Follow the GUI prompts to perform various operations such as adding students, managing examinations, and processing fees.

## How to Build the JAR File

To create a JAR file for the application, follow these steps:

1. Open the terminal and navigate to the project directory.
2. Use the following command to compile the project:
    ```bash
    javac -d bin src/*.java
    ```
3. Create a JAR file using the following command:
    ```bash
    jar cfe UniversityManagementSystem.jar src/UniversityManagementSystem.class -C bin .
    ```
4. To run the JAR file, use:
    ```bash
    java -jar UniversityManagementSystem.jar
    ```

## Contributing

Contributions to the University Management System are welcome! If you would like to contribute, please follow these steps:

1. Fork the project.
2. Create a feature branch (`git checkout -b feature/newFeature`).
3. Commit your changes (`git commit -m 'Add new feature'`).
4. Push to the branch (`git push origin feature/newFeature`).
5. Open a pull request.

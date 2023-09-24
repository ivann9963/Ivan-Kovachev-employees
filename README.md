# Ivan-Kovachev-employees Documentation

## Table of Contents

1. [Introduction](#introduction)
2. [Getting Started](#getting-started)
3. [Code Structure](#code-structure)
4. [Models](#models)
5. [Main Logic](#main-logic)
6. [Best Practices](#best-practices)
7. [Contributing](#contributing)
8. [License](#license)

---

## Introduction

This project aims to find the pair of employees who have worked together for the longest time on the same projects.

---

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- A text editor or IDE

### Installation

1. Clone the repository
2. Navigate to the project directory
3. Compile and run the `Main.java` file

---

## Code Structure

The project is organized into two main directories:

- `src/models`: Contains the `Employee` model class.
- `src`: Contains the `Main` class, which includes the main logic.

---

## Models

### Employee

The `Employee` class is responsible for storing employee data. It includes the following fields:

- `empId`: Employee ID
- `dateFrom`: Start date of the project
- `dateTo`: End date of the project

[View Employee Model](https://github.com/ivann9963/Ivan-Kovachev-employees/blob/master/src/models/Employee.java)

---

## Main Logic

The `Main` class contains the logic for:

- Loading data from a CSV file
- Calculating the time two employees have worked together
- Finding the pair of employees who have worked together the longest

[View Main Logic](https://github.com/ivann9963/Ivan-Kovachev-employees/blob/master/src/Main.java)

---

## Contributing

Feel free to contribute to this project by creating a pull request.

---

## License

This project is open-source and available under the MIT License.

---

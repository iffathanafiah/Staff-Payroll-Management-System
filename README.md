# Staff Payroll Management System

## Original Author

This project is created and maintained by [rydzze](https://github.com/rydzze).

## Introduction

In today's business world, managing staff payroll is crucial for a company's success. However, existing systems often come with their share of problems: they take up too much time, they're prone to errors, and they struggle to keep up with growing needs. Therefore, our proposed Staff Payroll Management System provides a better solution which aims to confront these challenges head-on, offering a streamlined approach to payroll administration that prioritizes efficiency, accuracy, and a user-friendly experience. By enhancing data storage accuracy and introducing modern user interfaces, the system seeks to revolutionize how businesses handle their payroll operations. Developed using Java and exploiting Java Swing technology, the system includes several functions for Staff and Payroll sections such as add, delete, edit, and view functions. Moreover, we also include save and load functions to restore and preserve our system data.

## Problem Statements and Objectives

### Problem Statements
1. **Time-Consuming Process:**
   - The process of requesting, issuing, and distributing the payslip can take too much time, leading to delays that might impact the company's reputation.
2. **Inaccuracies:**
   - Current systems use manual and traditional methods, which are inefficient and prone to human errors like miscalculations, and data entry mistakes.
3. **Scalability and Performance Issues:**
   - The current payroll system would have a problem with handling their staffs' data that keeps growing, as well as calculating the payroll.
4. **User-Friendliness Interface:**
   - User adoption of the system might be hindered as the application interface is outdated since it did not receive frequent updates.

### Objectives
1. **Automate Workflows:**
   - Build and implement an automated staff payroll management system that optimizes the workflows for requesting, issuing, and distributing the payslip.
2. **Improve Data Management:**
   - Improve the accuracy and efficiency of staff data management and payslip generation by introducing features enabling employers to add, edit, view, and remove data.
3. **Enhance Scalability:**
   - Solve scalability and performance issues by enhancing the payroll system's ability to handle growing staff data using file management.
4. **Modernize User Interface:**
   - Design a brand-new user interface for the system using Java Swing, making the system easier to use and visually appealing.

## Programme Scope

The Staff Payroll Management System is designed to meet the demands of employers, aiming to accelerate staff payroll information requests, issues, and updates. The system's primary goal is to streamline payroll information management by integrating necessary functions like adding, viewing, editing, and deleting staff payroll records, along with features like digital payslip exporting and automated salary calculation. Updating and organizing employee information would be easier for employers, ensuring its reliability and precision. The system will be developed using the Java programming language, utilizing JFrame, and applying principles of Object-Oriented Programming as well as file management concepts.

## Detailed Description

### Implementation Details of Source Code

- **Package Organization:**
  - The program source code is organized into a package named `src`, serving as the root directory. Inside it, other packages like `Staff` and `Payroll` are created to organize the source code files for improved maintainability and readability.
  
- **Graphical User Interface (GUI):**
  - The login and main menu interfaces are implemented using JFrame from Java Swing packages for its robust graphical user interface (GUI) capabilities.
  - Other interfaces for adding, viewing, and editing features are implemented using JInternalFrame for enhanced modularity, allowing seamless transitions between features and improving user experience and response time.
  
- **Data Structures:**
  - Two static array lists are used as data structures to store the staff and payroll data within their respective source code files, ensuring these lists belong to their respective classes and avoiding duplication of data.
  
- **File Handling:**
  - File handling for the staff payroll management system is achieved through the utilization of load and save functions to read and write data from and into a .txt file, respectively.
  
- **Formatted Text Fields:**
  - Formatted text fields are used for numerical input fields to prevent unexpected user input that could lead to errors.
  
- **Exception Handling:**
  - Exception handling is implemented throughout the system as a precautionary measure to prevent runtime errors and ensure smooth functionality even in the face of unexpected issues.

### How to Run

The Windows batch files provide a convenient way to compile and run the system in Windows. Here's what each command in the batch file does:

1. **compile:**
   - This command compiles the Java files into Java classes. It's equivalent to running:
     ```
     javac *.java
     ```

2. **run:**
   - This command runs the Staff Payroll Management System. It's equivalent to running:
     ```
     java Main
     ```

3. **compileRun:**
   - This command combines both compile and run commands. It compiles the Java files and then runs the Staff Payroll Management System.

### Contributors

We'd like to give credit to the following contributors who have helped in the development of this project:

- [Ariff Ridzlan](https://github.com/rydzze)
- [Nawfal Syafi'](https://github.com/Blackthorn23)
- [Iffat](https://github.com/xsumthingz)
- Haikal Hazim

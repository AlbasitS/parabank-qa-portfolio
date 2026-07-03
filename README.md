# Parabank QA Testing Portfolio

## 📌 Project Overview
This project is a Software Quality Assurance (QA) portfolio built using the ParaBank demo banking application.

The project demonstrates both Manual Testing and Automation Testing practices, including test planning, test case design, bug reporting, and end-to-end UI automation using Selenium WebDriver with Java.

The automation framework is developed using the Page Object Model (POM) design pattern and TestNG framework. Test execution reports are generated using Extent Reports, and failed test cases automatically capture screenshots for easier debugging.

To ensure a stable and consistent testing environment, the application is executed locally using Docker.

## 🛠 Technology Stack
|        Category      |         Technology          |
|----------------------|-----------------------------|
| Programming Language | Java 17                     |
| Automation Framework | Selenium WebDriver          |
| Test Framework       | TestNG                      |
| Build Tool           | Maven                       |
| Design Pattern       | Page Object Model (POM)     |
| Reporting            | Extent Reports              |
| Driver Management    | WebDriverManager            |
| Version Control      | Git & GitHub                |
| Test Environment     | Docker (ParaBank Localhost) |
| IDE                  | IntelliJ IDEA               |
| Browser              | Google Chrome               |

## 📂 Project Structure
```text
parabank-qa-portfolio
│
├── Manual-Testing
│   ├── Feature-Inventory.xlsx
│   ├── Test-Scenario.xlsx
│   ├── Test-Case.xlsx
│   └── Bug Report.xlsx
│
├── Automation-Testing
│   ├── src
│   │   ├── base
│   │   ├── pages
│   │   ├── tests
│   │   └── utils
│   └── pom.xml
│
├── README.md
└── LICENSE
```
### Folder Description
|       Folder       |                       Description                              |
|--------------------|----------------------------------------------------------------|
| Manual-Testing     | Test scenarios, test cases, bug reports, and feature inventory |
| Automation-Testing | Selenium WebDriver automation framework using Java and TestNG  |
| pages              | Page Object Model classes                                      |
| tests              | TestNG test classes                                            |
| base               | Base test configuration                                        |
| utils              | Utility classes such as Extent Reports and Screenshot capture  |

## 📸 Project Screenshots

### Login Page
The login page of the ParaBank application used for authentication testing.

![Login Page](docs/screenshots/login-page.png)

### Register Page
The user registration page used for new customer account creation testing.

![Register Page](docs/screenshots/register-page.png)

### Transfer Funds
Transfer Funds feature used for positive and negative transaction testing.

![Transfer Funds](docs/screenshots/transfer-funds-feature.png)

### Automation Execution
Selenium WebDriver executing automated UI tests in Google Chrome.

![Automation Running](docs/screenshots/automation-execution.png)

### Extent Report
HTML execution report generated after automation testing.

![Extent Report](docs/screenshots/extent-report.png)

### Bug Report
Example of manual testing bug documentation created during testing.

![Bug Report](docs/screenshots/bug-report.png)

## ✨ Features

### Manual Testing
- Feature Inventory
- Test Scenario
- Test Case
- Bug Report

### Automation Testing
- Selenium WebDriver with Java
- TestNG Framework
- Maven Project
- Page Object Model (POM)
- WebDriverManager Integration
- Docker Local Test Environment

### Automated Test Coverage
- User Registration
- Login
- Open New Account
- Transfer Funds
- Bill Payment
- Update Contact Information
- Request Loan

### Reporting
- Extent Report
- Automatic Screenshot on Test Failure

## 🚀 Getting Started

### Prerequisites
Make sure the following software is installed before running this project:
- Java 17
- Apache Maven
- IntelliJ IDEA
- Google Chrome
- Docker Desktop
- Git

## ▶️ Running the Automation

### 1. Clone Repository
```bash
git clone https://github.com/AlbasitS/parabank-qa-portfolio.git
```

### 2. Start ParaBank
Run ParaBank locally using Docker.

### 3. Open Automation Project
Open the `Automation-Testing` folder using IntelliJ IDEA.

### 4. Install Dependencies
Maven will automatically download all required dependencies.

### 5. Execute Test
Run any TestNG test class, for example:
- LoginTest
- RegisterTest
- BillPayTest
- TransferFundsTest
- OpenNewAccountTest
- UpdateContactInfoTest
- RequestLoanTest

## 📊 Test Report

This project uses **Extent Reports** for execution reporting.
After each execution, an HTML report is generated automatically.

Location:
`Automation-Testing/reports/`

Features:
- Detailed execution report
- Test status (Pass / Fail)
- Execution time
- Automatic screenshots for failed test cases

## 🐞 Known Bugs

The following defects were identified during testing:

| Bug ID  |                          Description                               | Status |
|---------|--------------------------------------------------------------------|--------|
| BUG-001 | Transfer Funds accepts negative transfer amount.                   |  Open  |
| BUG-002 | Transfer Funds allows transfer amount exceeding available balance. |  Open  |

Detailed bug reports are available in:
`Manual-Testing/Bug Report.xlsx`

## 🎯 Future Improvements

The following improvements are planned for future development as this portfolio continues to evolve:
- Implement Data-Driven Testing
- Execute Cross-Browser Testing
- Integrate Jenkins for Continuous Integration (CI)
- Add API Testing using REST Assured
- Execute Parallel Testing
- Improve test data management

## 👤 Author

**Septian Al Basit**

Passionate about Software Quality Assurance, Automation Testing, and Continuous Learning.
- GitHub: https://github.com/AlbasitS
- LinkedIn: *(coming soon)*

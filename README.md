# Test Plan – AutomationCRM

## 1. Objective

Automate basic end-to-end test scenarios for the CRM platform, starting from login and continuing with full CRUD operations on the "Google Accounts" section. This ensures we validate critical workflows, reduce regression risk, and improve test coverage.

---

## 2. Modules Covered

| Module          | Functional Description                        |
|-----------------|-----------------------------------------------|
| Login           | Authenticate user with email/password         |
| Google Accounts | Create, Read, Update, Search, Delete accounts |

---

## 3. Proposed Test Cases – Google Accounts

### Login

| Test Case ID | Name                         | Purpose                                       | Preconditions | Steps                                                                           | Expected Result                     |
|--------------|------------------------------|-----------------------------------------------|---------------|---------------------------------------------------------------------------------|-------------------------------------|
| TC-LOGIN-001 | Login with valid credentials | Ensure access to CRM with correct credentials | None          | 1. Open CRM login page<br>2. Enter valid email and password<br>3. Click "Login" | User is redirected to the dashboard |

### Google Accounts CRUD

| Test Case ID | Name                      | Purpose                                     | Preconditions          | Steps                                                                                    | Expected Result                        |
|--------------|---------------------------|---------------------------------------------|------------------------|------------------------------------------------------------------------------------------|----------------------------------------|
| TC-GA-001    | Create new Google account | Validate creation of a new Google account   | User is logged in      | 1. Go to "Google Accounts"<br>2. Click "Create Account"<br>3. Fill form<br>4. Click Save | Account appears in the table           |
| TC-GA-002    | Read account from table   | Verify new account appears in listing       | Account has been added | 1. Navigate to "Google Accounts"<br>2. Check latest entry or matching details in table   | Details match the created account      |
| TC-GA-003    | Search for account        | Confirm search functionality works properly | Account exists         | 1. Go to "Google Accounts"<br>2. Use search bar <br>3.                                   | Table displays filtered account(s)     |
| TC-GA-004    | Update existing account   | Ensure account data can be edited           | Account exists         | 1. Click Edit on account<br>2. Change name or status<br>3. Save changes                  | Table reflects updated data            |
| TC-GA-005    | Delete account            | Ensure deletion removes account             | Account exists         | 1. Click Delete<br>2. Confirm action<br>3. Verify account is removed                     | Account no longer appears in the table |

---

## 4. Project Structure Proposal

crm-automation/
- src/
    - main/
        - java/
            - com/
                - crm/
                    - pages/
                        - LoginPage.java
                        - GoogleAccountsPage.java
                    - utils/
                        - BasePage.java
    - test/
        - java/
            - com/
                - crm/
                    - login/
                        - LoginTest.java
                    - googleaccounts/
                        - CreateAccountTest.java
                        - ReadAccountTest.java
                        - SearchAccountTest.java
                        - UpdateAccountTest.java
                        - DeleteAccountTest.java
- pom.xml
- README.md

--- 

### Description

* **src/main/java/**: Contains the core Java source code for the automation framework.
  * **com/crm/pages/**: Page Object Model (POM) classes for UI interactions.
  * **LoginPage.java**: Page object for login functionality. 
  * **GoogleAccountsPage.java**: Page object for Google Accounts-related actions.

* **com/crm/utils/**: Utility classes for configuration and test data.
  * **BasePage.java**: Base class for page objects with common methods.
* **src/test/java/**: Contains test classes for automation scenarios.
  * **com/crm/login/**: Test cases for login functionality.
    * **LoginTest.java**: Tests for login scenarios.
  * **com/crm/googleaccounts/**: Test cases for Google Accounts operations.
    * **CreateAccountTest.java**: Tests account creation.
    * **ReadAccountTest.java**: Tests account retrieval.
    * **SearchAccountTest.java**: Tests account search functionality.
    * **UpdateAccountTest.java**: Tests account updates.
    * **DeleteAccountTest**: Tests account deletion.
* **pom.xml:** Maven configuration file with dependencies and build settings.
* **README.md:** Project documentation with setup instructions and overview.
  
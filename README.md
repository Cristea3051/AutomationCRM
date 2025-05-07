# Test Plan – AutomationCRM

## 1. Objective

Automate basic end-to-end test scenarios for the CRM platform, starting from login and continuing with full CRUD operations on the "Google Accounts" section. This ensures we validate critical workflows, reduce regression risk, and improve test coverage.

---

## 2. Modules Covered

| Module          | Functional Description                  |
|-----------------|-----------------------------------------|
| Google Accounts | Create, Update, Search, Delete accounts |

---

## 3. Proposed Test Cases – Google Accounts

### Google Accounts CRUD

| Test Case ID | Name                      | Purpose                                     | Preconditions          | Steps                                                                                    | Expected Result                        |
|--------------|---------------------------|---------------------------------------------|------------------------|------------------------------------------------------------------------------------------|----------------------------------------|
| TC-GA-001    | Create new Google account | Validate creation of a new Google account   | User is logged in      | 1. Go to "Google Accounts"<br>2. Click "Create Account"<br>3. Fill form<br>4. Click Save | Account appears in the table           |
| TC-GA-003    | Search for account        | Confirm search functionality works properly | Account exists         | 1. Go to "Google Accounts"<br>2. Use search bar <br>3.                                   | Table displays filtered account(s)     |
| TC-GA-004    | Update existing account   | Ensure account data can be edited           | Account exists         | 1. Click Edit on account<br>2. Change name or status<br>3. Save changes                  | Table reflects updated data            |
| TC-GA-005    | Delete account            | Ensure deletion removes account             | Account exists         | 1. Click Delete<br>2. Confirm action<br>3. Verify account is removed                     | Account no longer appears in the table |

---

## 4. Project Structure

crm-automation/
- [src](src)
    - [main](src/main/)
        - [java](src/main/java)
            - [com](src/main/java/com/)
                - [crm](src/main/java/com/crm/)
                    - [pages](src/main/java/com/crm/pages)
                        - [LoginPage.java](src/main/java/com/crm/pages/LoginPage.java)
                    - [utils](src/main/java/com/crm/utils)
                        - [BasePage.java](src/main/java/com/crm/utils/BasePage.java)
        - [resources](src/main/resources)
            - [credentials.properties](src/main/resources/credentials.properties)
            - [log4j2.xml](src/main/resources/log4j2.xml)
    - [test](src/test)
        - [java](src/test/java)
            - [com](src/test/java/com/)
                - [crm](src/test/java/com/crm/)
                    - [GoogleAccounts](src/test/java/com/crm/GoogleAccounts)
                       - [CreateAccount](src/test/java/com/crm/GoogleAccounts/CreateAccount)
                         - [CreateAccountPage.java](src/test/java/com/crm/GoogleAccounts/CreateAccount/CreateAccountPage.java)
                         - [CreateAccountTest.java](src/test/java/com/crm/GoogleAccounts/CreateAccount/CreateAccountTest.java)
                       - [DeleteAccount](src/test/java/com/crm/GoogleAccounts/DeleteAccount)
                           - [DeleteAccountPage.java](src/test/java/com/crm/GoogleAccounts/DeleteAccount/DeleteAccountPage.java)
                           - [DeleteAccountTest.java](src/test/java/com/crm/GoogleAccounts/DeleteAccount/DeleteAccountTest.java)
                       - [SearchAccount](src/test/java/com/crm/GoogleAccounts/SearchAccount)
                            - [SearchAccountPage.java](src/test/java/com/crm/GoogleAccounts/SearchAccount/SearchAccountPage.java)
                            - [SearchAccountTest.java](src/test/java/com/crm/GoogleAccounts/SearchAccount/SearchAccountTest.java)
                       - [UpdateAccount](src/test/java/com/crm/GoogleAccounts/UpdateAccount)
                            - [UpdateAccountPage.java](src/test/java/com/crm/GoogleAccounts/UpdateAccount/UpdateAccountPage.java)
                            - [UpdateAccountTest.java](src/test/java/com/crm/GoogleAccounts/UpdateAccount/UpdateAccountTest.java)
- [pom.xml](pom.xml)
- [README.md](README.md)

--- 

### Description

* **[java](src/main/java)**: Contains the core Java source code for the automation framework.
  * **[pages](src/main/java/com/crm/pages)**: Page Object Model (POM) classes for UI interactions.
  * **[LoginPage.java](src/main/java/com/crm/pages/LoginPage.java)**: Page object for login functionality.

* **[utils](src/main/java/com/crm/utils)**: Utility classes for configuration and test data.
  * **[BasePage.java](src/main/java/com/crm/utils/BasePage.java)**: Base class for page objects with common methods.
* **[java](src/test/java)**: Contains test classes for automation scenarios.
  * **[GoogleAccounts](src/test/java/com/crm/GoogleAccounts)**: Test cases for Google Accounts operations.
    * **CreateAccountTest.java**: Tests account creation.
    * **ReadAccountTest.java**: Tests account retrieval.
    * **SearchAccountTest.java**: Tests account search functionality.
    * **UpdateAccountTest.java**: Tests account updates.
    * **DeleteAccountTest**: Tests account deletion.
* **pom.xml:** Maven configuration file with dependencies and build settings.
* **README.md:** Project documentation with setup instructions and overview.
  
  

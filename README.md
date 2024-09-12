The Simple Banking System is a Java-based console application that simulates basic banking operations. It allows users to create accounts, deposit and withdraw funds, and check their account balances. The system saves account data to a file, ensuring persistence across sessions.

Features
Create Account: Users can create a new account with a name.
Deposit Funds: Users can deposit money into their account.
Withdraw Funds: Users can withdraw money, subject to available balance.
Check Balance: Users can check the balance of their account.
Persistent Data: All account details are saved in a file (accounts.txt) to maintain account information even after exiting the program.
Installation and Setup
To run this project on your local machine:

Clone the repository:

bash
Copy code
git clone https://github.com/yourusername/SimpleBankingSystem.git
Compile and run the Java program:

Open a terminal in the project directory.
Run the following commands:
bash
Copy code
javac SimpleBankingSystem.java
java SimpleBankingSystem
File Persistence:

The system uses a file named accounts.txt to store account data. This file will be automatically created in the project directory when the program runs for the first time.

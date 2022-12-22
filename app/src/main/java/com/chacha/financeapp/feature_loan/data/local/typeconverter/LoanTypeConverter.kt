package com.chacha.financeapp.feature_loan.data.local.typeconverter

import androidx.room.*
import com.chacha.financeapp.feature_loan.data.local.Loans
import com.google.gson.Gson

/*A Sacco (short for Savings and Credit Cooperative) is a type of financial institution that is owned and controlled by its members. Here are some classes and their properties that might be useful in a Sacco application:

Members: This class could represent a member of the Sacco. Properties might include:
id (integer): a unique identifier for the member
name (string): the name of the member
email (string): the email address of the member
phone (string): the phone number of the member
membershipDate (date): the date that the member joined the Sacco
balance (double): the current balance of the member's account
Loan: This class could represent a loan issued by the Sacco to a member. Properties might include:
id (integer): a unique identifier for the loan
memberId (integer): the ID of the member who is borrowing the loan
amount (double): the amount of the loan
interestRate (double): the interest rate applied to the loan
startDate (date): the date that the loan was issued
endDate (date): the date that the loan is due to be repaid
Transaction: This class could represent a financial transaction made by a member. Properties might include:
id (integer): a unique identifier for the transaction
memberId (integer): the ID of the member who made the transaction
type (string): the type of transaction (e.g. "deposit", "withdrawal", "loan payment")
amount (double): the amount of the transaction
timestamp (date/time): the date and time that the transaction was made
Sacco: This class could represent the Sacco itself. Properties might include:
id (integer): a unique identifier for the Sacco
name (string): the name of the Sacco
location (string): the location of the Sacco
members (list): a list of the members of the Sacco
loans (list): a list of the loans issued by the Sacco
transactions (list): a list of the transactions made by the members of the Sacco*/



class LoanTypeConverter {
    @TypeConverter
    fun fromLoan(loan: Loans): String {
        return Gson().toJson(loan)
    }

    @TypeConverter
    fun toLoan(value: String): Loans {
        return Gson().fromJson(value, Loans::class.java)
    }
}








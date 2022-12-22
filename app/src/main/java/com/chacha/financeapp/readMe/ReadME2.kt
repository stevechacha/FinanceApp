package com.chacha.financeapp.readMe

import java.util.Date

/*
Some examples of APIs that might be used in a sacco system include:

A banking API to enable integration with a bank or other financial institution, allowing members to make deposits and withdrawals,
 transfer money, and perform other financial transactions.


A payment processing API to enable the acceptance of payments from members and the disbursement of loans or other financial products.

A database API to enable access to and manipulation of member and financial data stored in a database.

An analytics API to enable the analysis of financial data and the generation of reports and other insights.

An interface API to enable the creation of user interfaces for different components of the system,
   such as a member portal or a loan application process.



A security API to enable the implementation of security measures such as authentication, authorization, and encryption.*/







/*

public class Member
{
    public string Name { get; set; }
    public string PhoneNumber { get; set; }
    public string EmailAddress { get; set; }
    public string MailingAddress { get; set; }
    public MembershipStatus Status { get; set; }
    public string MembershipId { get; set; }

    public void MakeDeposit(decimal amount)
    {
        // implementation details go here
    }

    public void ApplyForLoan(Loan loan)
    {
        // implementation details go here
    }
}

public enum MembershipStatus
{
    Active,
    Inactive
}

public class Loan
{
    public decimal Amount { get; set; }
    public decimal InterestRate { get; set; }
    public int NumPayments { get; set; }
    public PaymentFrequency Frequency { get; set; }
    public LoanStatus Status { get; set; }
    public string LoanId { get; set; }

    public decimal CalculatePayment()
    {
        // implementation details go here
    }
}

public enum PaymentFrequency
{
    Monthly,
    Biweekly,
    Weekly
}

public enum LoanStatus
{
    Approved,
    Denied,
    InProgress
}

public class Account
{
    public decimal Balance { get; set; }
    public List<Transaction> TransactionHistory { get; set; }
    public AccountType Type { get; set; }
    public string AccountId { get; set; }

    public void MakeDeposit(decimal amount)
    {
        // implementation details go here
    }

    public void MakeWithdrawal(decimal amount)
    {
        // implementation details go here
    }
}

public enum AccountType
{
    Checking,
    Savings,
    Loan
}

public class Transaction
{
    public decimal Amount { get; set; }
    public TransactionType Type { get; set; }
    public DateTime Date { get; set; }
    public string TransactionId { get; set; }
}

public enum TransactionType
{
    Deposit,
    Withdrawal,
    Transfer
}

public class Report
{
    public ReportType Type { get; set; }
    public List<Transaction> Data { get; set; }
    public DateTime StartDate { get; set; }
    public DateTime EndDate { get; set; }

    public void Generate()
    {
        // implementation details go here
    }
}

public enum ReportType
{
    BalanceSheet,
    IncomeStatement
}
*/



data class Member (
    val  name: String ,
    val phoneNumber : String,
    val emailAddress: String,
    val membershipStatus : MembershipStatus,
    val memberId:String,
){
    fun makeDeposit() {
        // implementation details go here
    }

    fun  applyForLoan() {
        // implementation details go here
    }
}


enum class MembershipStatus {
    Active,
    Inactive
}

data class Loan(
    val loanId: String,
    val loanAmount: Double,
    val interestRate:Double,
    val NumPayments : String,
    val paymentFrequency: PaymentFrequency,
    val loanStatus : LoanStatus,
){
    fun calculatePayment() {
        // implementation details go here
    }
}

enum class PaymentFrequency {
    Monthly,
    Biweekly,
    Weekly
}

enum  class LoanStatus {
    Approved,
    Denied,
    InProgress
}

data class Account(
    val accountId: String,
    val balance: Double,
    val transactionHistory: List<Transaction> ,
    val accountType: AccountType
) {
    fun deposits() {
    }

    fun widthrawals() {

    }
}


enum class AccountType {
    Checking,
    Savings,
    Loan
}

data class Transaction(
    val transactionId: String,
    val amount: Double,
    val transactionType: TransactionType,
    val transactionDate: Date

)
enum class TransactionType{
    Deposit,
    Withdrawal,
    Transfer,
    LoanRepayment
}

data class Report(
    val reportType: ReportType,
    val transactionHistory: List<Transaction>,
    val startDate: Date,
    val endDate: Date,

){
    fun generateReport(){

    }
}


enum class ReportType{
    BalanceSheet,
    IncomeStatement
}

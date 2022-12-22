package com.chacha.financeapp.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.chacha.financeapp.core.data.local.typeconverter.DataTypeConverters
import com.chacha.financeapp.feature_account.data.local.Accounts
import com.chacha.financeapp.feature_account.data.local.AccountsDao
import com.chacha.financeapp.feature_loan.data.local.Loans
import com.chacha.financeapp.feature_loan.data.local.LoansDao
import com.chacha.financeapp.feature_member.data.local.MemberDao
import com.chacha.financeapp.feature_member.data.local.Members
import com.chacha.financeapp.feature_payment.data.local.Payments
import com.chacha.financeapp.feature_payment.data.local.PaymentsDao
import com.chacha.financeapp.feature_saving.data.local.SavingsAccount
import com.chacha.financeapp.feature_transaction.data.local.Transactions
import com.chacha.financeapp.feature_transaction.data.local.TransactionsDao

@Database(
    entities = [
        Accounts::class,
        Transactions::class,
        Loans::class,
        Members::class,
        Payments::class

               ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DataTypeConverters::class)
abstract class FinanceDatabase: RoomDatabase() {
    abstract val accountsDao: AccountsDao
    abstract val transactionsDao: TransactionsDao
    abstract val loansDao: LoansDao
    abstract val memberDao: MemberDao
    abstract val paymentsDao:  PaymentsDao
}
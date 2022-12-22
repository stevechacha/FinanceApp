package com.chacha.financeapp.feature_account.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AccountsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAccount(accounts: Accounts)

    @Query("SELECT * FROM account")
    fun getAllAccounts(): List<Accounts>


    @Query("SELECT * FROM account WHERE accountNumber = :accountNumber")
    fun getAccount(accountNumber: String): Accounts

    @Delete
    fun deleteAccount(accounts: Accounts)


    /* Others */

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllAccounts(accounts: List<Accounts>): List<Long>

    @Query("SELECT * FROM account WHERE id = :id")
    fun getAccount(id: Int): Accounts?

    @Query("SELECT * FROM accounts WHERE id = :id")
    fun getLiveAccount(id: Int?): LiveData<Accounts>

    @Query("SELECT COUNT(id) FROM accounts")
    fun getDataCount(): Int

    @Update
    fun updateAccount(accounts: Accounts?)

    @Update
    suspend fun updateAccount(accounts: LiveData<Accounts>)


    @Query("DELETE FROM accounts")
    fun deleteAll()
}


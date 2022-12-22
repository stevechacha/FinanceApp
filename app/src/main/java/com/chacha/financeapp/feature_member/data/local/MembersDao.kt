package com.chacha.financeapp.feature_member.data.local

import androidx.room.*

@Dao
interface MemberDao {
    @Query("SELECT * FROM member")
    fun getAll(): List<Members>

    @Insert
    fun insert(member: Members)

    @Update
    fun update(member: Members)

    @Delete
    fun delete(member: Members)
}

package com.chacha.financeapp.core.data.repository

import com.chacha.financeapp.core.data.local.FinanceDatabase
import com.chacha.financeapp.core.domain.repository.FinanceRepository
import javax.inject.Inject

class FinanceRepositoryImpl @Inject constructor(
    private val financeDB: FinanceDatabase

    ) : FinanceRepository {

}
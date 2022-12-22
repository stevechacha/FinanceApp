package com.chacha.financeapp.feature_report.data.local

import com.chacha.financeapp.readMe.Transaction


/* Report Class
•	report type (e.g. balance sheet, income statement) (e.g. string or enumerated type)
•	data included in the report (e.g. list of transactions, account balances) (e.g. list of objects)
•	report date range (e.g. start date, end date) (e.g. date or datetime objects)
   report financial statements, member reports, and loan reports.

*
* */

data class Report(
    val transaction: Transaction
)

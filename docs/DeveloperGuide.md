# Developer Guide

## Design & implementation
### Edit Feature
`SpendingList` and `Ui` facilitate this feature. The Edit feature is able to edit the existing items in the spending list. 
It implements the following operations:
1. `SpendingList#editItem(index, description, symbol, amount, category)` → updates the items in the spending list
2. `Ui#printEdit(spendingList, index)` → prints the message to show the successful completion of the edition process

Below shows an example of the usage:
1. User executes `edit 1 food bubble tea SGD 5.00` command to edit the first item in the spending list to bubble tea 
with a cost of SGD 5.00 under the category of food
2. The `edit` command calls the `EditCommand#execute(spendingList, ui)` to complete the edition process

Figure below shows the sequence diagram of `EditCommand` class.
![Sequence Diagram of EditCommand class](images/EditCommand.png)

### Convert Feature
`SpendingList`, `Ui` and `Item` facilitate this feature. The Convert feature is able to convert the currency of the items 
stored in the spending list. It implements the following operations:
1. `SpendingList#getSpendingList()` → retrieves the current spending list
2. `ConvertCommand#identifyCurrency(description)` → identifies the currency after conversion
3. `ConvertCommand#findExchangeRate()` → finds the corresponding exchange rate
4. `Item#editAmount(amount)` → updates the new amount after conversion
5. `Item#editSymbol(currency)` → updates the new currency after conversion
6. `SpendingList#updateSpendingList()` → updates the spending list after conversion 
7. `Ui#printConvertCurrency(outputCurrency)` → print the message to show the successful completion of the conversion 
process

Below shows an example of the usage:
1. User executes `convert SGD USD` command to convert the currency from SGD to USD
2. The `convert` command calls the `ConvertCommand#execute(spendingList, ui)` to complete the conversion process

Figure below shows the sequence diagram of `ConvertCommand` class.
![Sequence Diagram of ConvertCommand class](images/ConvertCommand.png)

### Set Budget Feature
`Budget` and `Ui` facilitate this feature. The Set Budget feature is able to set the budget limit for the spending. 
It implements the following operations:
1. `SetBudgetCommand#identifyBudgetLimit(description)` → identifies the budget limit input by the user
2. `Budget#addBudget(currency, budgetLimit)` → stores the budget limit with its corresponding currency
3. `Ui#printBudgetLimit(currency, budgetLimit)` → print the message to show the successful completion of the setting 
budget process

Below shows an example of usage:
1. User executes `set SGD 100.0` to set the budget limit to SGD 100.0
2. The `set` command calls `SetBudgetCommand#execute(spendingList, ui)` to complete the setting budget process

Figure below shows the sequence diagram of SetBudgetCommand class.
![Sequence Diagram of SetBudgetCommand class](images/SetBudgetCommand.png)

### Warn Feature
`Budget`, `SpendingList` and `Ui` facilitate this feature. The Warn feature is able to warn the user when the total 
spending amount approaches the threshold of 90% of the budget limit or when the total spending amount exceeds 
the budget limit. It implements the following operations:
1. `Budget#getCurrency()` → retrieves the corresponding currency for the budget
2. `Budget#getBudgetLimit()` → retrieves the budget limit
3. `SpendingList#getCurrentAmount()` → gets the total amount of spending in the spending list
4. `Ui#printApproachingWarningMessage(outputCurrency, amountRemaining)` → prints the warning message that the spending 
is approaching budget limit (i.e. exceeds the threshold value of 90% of the budget limit but not yet exceed it), with 
the amount remaining
5. `Ui#printExceedingWarningMessage()` → prints the warning message that the spending has exceeded the budget limit

Below shows an example of usage:
1. User adds the spending to the spending list after setting the budget limit
2. The `add` command calls `WarnCommand#execute(spendingList, ui)` to check if the user approaches or exceeds budget 
limit 

Figure below shows the sequence diagram of WarnCommand class.
![Sequence Diagram of WarnCommand class](images/WarnCommand.png)

### Summary Feature
`SpendingList` and `Item` facilitate this feature. The Summary feature is able to summarise the total amount spent 
given a date. It implements the following operations:
* `Item#getDate()` → gets the date when user spent on the item
* `Item#getAmount()` → gets the amount spent on the item
* `SpendinList#getSpendingAmount(period)` → gets the total amount spent during a period
Below shows an example of usage:
1. User executes the `summary 2020` command to get the amount spent during year 2020.
2. The `summary` command calls the `SpendinList#getSpendingAmount(2020)` which checks the spending date of every items
stored in the memory.
3. If the item is spent during year 2020, the amount spent will be summed up.

Figure below shows the sequence diagram of `SummaryCommand` class:
![Sequence Diagram of SummaryCommand class](images/summary.png)



## Product scope
### Target user profile

The target user is NUS hostel students including both local students and international students.

### Value proposition

We observed that hostel students are encountering tight budgets due to expensive hostel fees, on top of their school 
tuition fees. Hence, we are developing a money manager targeted at NUS hostel students. This money manager   
Cent Wise Dollar Wise aims to help hostel students to have better financial management with limited budget. 


## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|international student|convert local currency to foreign currency or the reverse way|trace my spending easily|
|v1.0|careless user|view and reset the previous input|ensure the data input is correct|
|v1.0|user|have a monthly/yearly summary|know how much I had spent|
|v2.0|user|set a budget limit|be less likely to overspend my money|
|v2.0|user|be warned when my spending approaches the budget limit or exceeds the budget limit|be less likely to overspend my money|
|v2.0|big spender|tag purchases according to categories|for an easier overview|
|v2.0|user|have weekly reminders on how much has spent|take note of future spending|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}

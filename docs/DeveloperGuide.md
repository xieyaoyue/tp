# Developer Guide

## Design & implementation
### Edit Feature
`SpendingList` and `Ui` facilitate this feature. Edit feature is able to edit the existing items in the spending list. 
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
`SpendingList`, `Ui` and `Item` facilitate this feature. Convert feature is able to convert the currency of the items 
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
User executes `convert SGD USD` command to convert the currency from SGD to USD
The `convert` command calls the `ConvertCommand#execute(spendingList, ui)` to complete the conversion process

Figure below shows the sequence diagram of `ConvertCommand` class.
![Sequence Diagram of ConvertCommand class](images/ConvertCommand.png)

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


## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}

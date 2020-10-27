# User Guide

## 1. Introduction
Welcome to Cent Wise Dollar Wise User Guide! Cent Wise Dollar Wise is a desktop application for money management, optimised for use via a Command Line Interface (CLI). This application aims to help NUS hostel students manage their financial situation and track their spending efficiently. 
This user guide provides in-depth documentation on the application’s installation process and command features. 

## 2. Quick Start
1. Ensure that you have Java 11 or above installed in your computer.
2. Download the latest version of `Duke` from [here](http://link.to/duke).
3. Copy the file to a home folder you would like to use.
4. Open a terminal in that home folder and enter java -jar duke.jar to begin.
5. Type the desired command and press Enter to execute it. Tips: entering help will display the help window with a list of commands that could be executed.
6. Refer to the Features below for details of each command.

## 3. Features 
### 3. 1 Viewing Repayment List Summary: `repayment list`
This command shows your repayment list.

Format:

`repayment list`

### 3.2 Viewing Spending List Summary: `spending list`
This command shows your spending records during a specified period of time (a particular year or month, or both).
You can also choose to view your spending records which belong to a specific spending category.

Format:

`spending list [YEAR = current year] [MONTH = current month] [-c CATEGORY] [-a]`

* The abbreviation of `MONTH` is case sensitive.

Examples of usage:

`spending list` → lists all entries for the current month

`spending list 2020` → lists all entries for year 2020

`spending list 2020 Jul` → lists all entries for July 2020

`spending list -c Food` → lists all food entries for the current month

`spending list 2020 -c Food` → lists all food entries for the year 2020

`spending list 2020 Jul -c Food` → lists all food entries for July 2020

`spending list -a` → lists all entries

### 3.3 Viewing Budget Limit: `view`
This command shows the current budget limit you have set.

Format:

`view`

### 3.4 Setting Budget Limit: `set`
This command allows you to set a budget limit. You will receive a Ui warning message when your spending approaches 
the limit or exceeds the limit.

Format:

`set [-s AMOUNT]`

Example of usage:

`set -s SGD 100.0` → sets the budget limit to SGD 100.0

### 3.5 Inputting Repayment Information: `repay`
This command adds a repayment record to your repayment list.

Format:

`repay [-n NAME] [-s AMOUNT] [-t DEADLINE]`

Example of usage:

`repay -n Johnny -s SGD 5.0 -t 2020-12-02` → stores the information that you need to repay SGD 5.0 to Johnny before 
2020-12-02

### 3.6 Converting Currency: `convert`
If you are an international student, you may be more used to viewing your spendings in terms of your home currency. 
This command will help you by converting the currency in your spending list to another currency you prefer.

Format: 

`convert [-d INPUT_CURRENCY} [-d OUTPUT_CURRENCY]`

Example of usage:

`convert -d SGD -d USD` → converts the currency from SGD to USD

### 3.7 Viewing Summary: `summary`
This command generates a statement of your total expenditure during a specific period of time (a particular year or 
month, or both). Statements based on each spending category will also be shown.

Format: 

`summary YEAR MONTH [-a]`

* The abbreviation of `MONTH` is case sensitive.

Examples of usage:

`summary` → shows summary of current month

`summary 2020` → shows summary of a specific year

`summary 2020 Oct` → shows summary of a specific year and month

`summary -a` → shows the summary of total expenditure

## 4. FAQ

**Q**: How do I transfer my data to another computer? 

**A**: Install the app in the other computer and copy the data/duke.json to the same folder. When you start the app, it will automatically detect and load the backup data.

## 5. Command Summary
Action | Format & Examples 
--- | ---
add | add [-d DESCRIPTION] [-s SPENDING]
clear | clear KEYWORD </br> e.g. clear 1
convert | convert [-d DESCRIPTION] [-d DESCRIPTION] </br> e.g. convert -d SGD -d USD
draw | draw [YEAR = current year] [MONTH = current month]
edit | edit INDEX [-d NEW_DESCRIPTION] [-s NEW_SPENDING] </br> e.g. edit 1 -d bubble tea -s SGD 4.00
export | export PATH
help | help
logout | logout
purge data | purge data
repay | repay [-n NAME] [-s AMOUNT] [-t DEADLINE] </br> e.g. repay -n Johnny -s SGD 5.00 -t 2020-12-02
repayment list | repayment list
set | set [-s AMOUNT] </br> e.g. set -s SGD 100.00
view | view
spending list | spending list [YEAR = current year] [MONTH = current month] [-c CATEGORY] [-a] </br> e.g. spending list 2020 Jul -c food
summary | summary [YEAR = current year] [MONTH = current month] [-a] </br> e.g. summary 2020 Jul 

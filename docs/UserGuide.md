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
### Adding a todo: `todo`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

### View Summary: `summary`
Views the monthly / yearly summary expenditure.

Format: 

`summary YEAR MONTH [-a]`

* The abbreviation of `MONTH` is case sensitive.

Example of usage:

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
repay | repay [-d NAME] [-s AMOUNT] [-t DEADLINE] </br> e.g. repay -d Johnny -s SGD 5.00 -t 2020-12-02
repayment list | repayment list
set | set [-s AMOUNT] </br> e.g. set -s SGD 100.00
view | view
spending list | spending list [YEAR = current year] [MONTH = current month] [-c CATEGORY] [-a] </br> e.g. spending list 2020 Jul -c food
summary | summary [YEAR = current year] [MONTH = current month] [-a] </br> e.g. summary 2020 Jul 

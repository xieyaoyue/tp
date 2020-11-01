# Yen Pin Fang - Project Portfolio Page

## Overview
This project is a money manager. It is specially designed for the hostel students in the National University 
of Singapore. This application aims to help NUS hostel students manage their financial situation and track 
their spending efficiently. 

### Summary of Contributions
    1. Item
    2. Category
    3. SpendingList
    4. Summary
    5. Reminder

#### 1. Item
This is one of the most fundamental parts of the program. It stores the data of each spending item including 
description, currency code, date, amount and category. Initially, it was implemented in a way that each category
will extends the `Item` class. However, there would be a situation when the user wants to change the category of the
item. 

Hence, an enumeration of `Category` is created to check the validity of categories entered before storing.

#### 2. Category


#### 3. SpendingList
This may be considered as the most important part of the program as almost every class requires it in order to execute. 
`SpendingList` stores each spending item in an ArrayList in the memory. It allows addition, edition and deletion of 
specific spending item. It is the only class that can access the data stored in the `Item` object. Below is a class
diagram between `SpendingList` and `Item` class: 


#### 4. Summary
This is one of the useful features of this application. It can show the expenditure summary and the amount of spending
in each category as shown in the figure below:

The user can choose the period to be shown, such as year 2020 or a specific month.

#### 5. Reminder
This is an enhancement feature in the application. It aims to remind the user the total amount of expenditure every 
week. The message will be prompt to the user when the program starts to run. Refer to the diagram below:

At the start of the program, `Reminder` take note of the current date and current day of week. It will then find out all
the seven dates in the week and sum up the spending. Currently, a new week starts on Monday. Hence, the amount of 
spending will reset to $0 every Monday.

In `Reminder` class, it would also give out warning message if the user is overspending soon.
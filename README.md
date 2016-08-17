# MyMess
Has a user and admin interface
Admin has a single login detail :
  user-id : admin
  password : admin
  enroll no : 1
  
User is connected to a table called 'user_details'

The specifics of user_details are as follows :
  usr_name : varchar(20) 
  usr_surname : varchar(20)
  usr_gender : varchar(23)
  usr_id : varchar(25)
  usr_pword : varchar(25)
  usr_enroll : varchar(20) : not null : unique
  usr_course : varchar(20)
  usr_classof : int(6)
  usr_dob : date
  usr_email : varchar(45)
  usr_contact : bigint(20)
  usr_roomno : int(10)
  usr_secureq : varchar(30)
  usr_securea : varchar(30)
  usr_balance : int(11) : not null

When a student registers, (s)he gets an option add in 250 rupees inn their account.
All of these details are permenent except : room no, contact no, email address and balance through a separate module called "recharge"

The other tables used in the project are :
  menu_all
  cart_temp
  user_history
  
The description of the tables are as follows :
  menu_all hold the entire menu with descriptoins as follows :
  item code, item name, stock availible, date etc.
  
  cart_temp holds the menu items which can be added, deleted, also entire cart can be emptied in one click.
  
  user_history holds a list of all the items bought by the user.

Specification:
    Main features:
      -Recording tasks 
      -Tomato Clock
      -Categorizing Tasks (See video (1:16)) 
      -Login system
      -Notification system (User inputted)
      -Future improvements
      -Google cloud support 
      -How much time spent per task (tied into the tomato clock)
      -Achievement system


Why this app is useful:

As a user, we can not only set tasks and be more self-disciplined, in this app you can have the freedom to create a study group and interact with other peers by texting. And if you are an instructor in u of t, you can create a group, invite students in and assign tasks to them. What if we forgot the tasks? Don’t worry, the notification system will remind you when the due date is near and help you take control of your time again!

Some cool features:
      -The login system
      -Interaction between two peers account including add and message
      -Self-assigned categories and tasks. You can also access your task with date and category
      -Join/leave/manage the group and Group-assigned work 
      -Confirmation System in Notification allows you to make confirmation (Ask Leo later)



Instruction for our productivity app

Firstly, we should login ----- then we may have different types of Users, we can add AdminUser who manages NormalUser Account later, and also we can create a demo User as a tutorial account which tell people how to use our app, but now let’s just have NormalUser


-Branch 1: NormalUser 

*Calendar - when entering the calendar, User would receive tasks that is due in the future (basically system.out.println format: Top line date, the line under the date is the task (before GUI)), and User after that can have two options:

	*Check task with no due date
	*Search task with due date (can be a specific date or a single month), also return task related

*MyTask - User then have 3 options:

	*CheckExistedTask - if User choose that option:
-Firstly there will be a default folder in it called Default, which is an  
 arraylist stores tasks. And if the user chooses Default, it will return tasks that are stored in it.
-Also, later on there would be more folders (User can create it with option CreateNewCategory) and they will function the same
(We can make each task in it editable if TA think it is too less work)
-User can also delete folders as long as there is still a folder remains (>= 1)

	*CreateNewCategory - if User choose that option:
-User can now create categories of task, basically set name of the category they want and then it will become a folder in CheckExistedTask

	*CreateTask -  if User choose that option:
-User can create task with due date with some specification, and have option to put it under a category(folder) that has been created

*MyPeer - basically user has two options, add peers and text peers that has been added before (For social extension, that is an extra work since we are 8 people group)

	(when you send a request to a peer, she/he has to confirm it in Notification)


*MyGroup - User here has four options:
*Create 
Create a group, set names balabala, after that, creator will be the leader of the group, and a folder with the name of the group will appear in the CheckExistedTask.
 Also, that group cannot be deleted in CheckExistedTask (plan: to add an boolean attribute to the group called protected.)

And if the folder with same name existed, do nothing but set it to be protected
 
*ExistedGroup 
All groups that this user joined will show up and the user can select any of these group to access the information of a specific group (later on if we want to implement for extension, we can add peer from it :) )

	*ManageMyGroup
Most tricky part, from there, user can access to the group where he/she is  in charge of  ( be the admin or leader of the group), then this user can assign tasks which will appear on the folder(category) of each member of this group in CheckExistedTask
Leader or admin can also set new admin in the group they are in charge of and send notification to group members 
Leader or admin can invite and kick members (implemented same as LeaveGroup)

	 *LeaveGroup
 -     User can type in the name of the group he wants to leave and if that group has this user in it, he will receive a notification which needs this user’s final confirmation to leave this group (or we can do it right away if the group exists and has this user, buy it would be less cooler lol)


*Notification - challenging part, but can be extended to have a lottttt of functionalities
	*CheckMyMailBox
 		 -     From there User can receive two kinds of notification:
			- ConfirmationMail      Like peer request, the user has to confirm it
			- NormalMail          can be message from other peer, from the group, 					        or the due date reminder
		
*LogOut - log out and go back to the login page


-Branch 2: Create an account.
	- only normalUser can be created, just simply type your id and your password. If your id was not taken, a new account will be recorded and you can log into your new account






*
*






Entity Class

Class TaskCategory       // Represents a single folder/category. Contains a list of Tasks. 
Attributes: Arraylist<Task>

Class Task(Super)					// Abstract
Attributes: Name, Clock (Not sure about the attributes here.)


Class DefaultTaskTemplate extends Task  // We will  add more templates later

 
#Class WorkoutTask_Preset extends Task   		//Special task templates	
#Class SchoolworkTask_ extends Task)             
”””
(Save specific Task template for extension in Phase 2  , it takes a lot of time to implement GUI for each task template.
”””     	
Class IndividualTaskManager 	 // This is the class representing an individuals task manager. 
Attributes:  TaskCategoryManager T;  // This is use case (Check the TaskCateforyManager class in Usecases). It creates task categories and overlooks task page.
	     
	     Calendar c   // The calendar for the individuals task manager. All the tasks and their due dates will be shown here.
	      


Class Group				// Manages groups
Attributes: User Leader: <User> // Leader of the group
	     Arraylist <User> editorAcess // The users who can add tasks to the group
	     Arraylist <User> groupMembers // 
	     Calender groupCalender // This calender represents the groups calender. Shows all tasks and due dates for group.
	     TaskCategoryManager T // This will contain the MAIN task category where all tasks are added to initially and also later we will extend it to create folders for each user and add tasks to each folder. (Check the use cases section.)
	     

Class User(Super)				//User info - User can be admin or normal user. Idk what admin is but they are the creators of the app I guess.

Class NormalUser extends User    	// Regular user of app.
Attributes: password, 
     Username,
     Arraylist <Group> myGroups // Contains the groups the user is in
     Individual myPersonalTask  // This is users individual task thingy. 



Class/interface Tomato_Clock


Class Notification					// Notification messages
Class Statistics 				// Achievements and task completion stats
Class Calendar
Class Message

Use case class
			
Class TaskCategoryManager  // Creates task categories and makes and adds it to a list.
Attributes: Arraylist <TaskCategory> taskCategories // The list containing categories created by a user or group. 
Methods: addCategory - adds a category from the arraylist
	    deleteCategory - deletes a category from the arraylist
	    

Class UserManager		// Does user stuff
Class TaskManager		// Edits task and sets clock, notif etc
Class GroupTaskManager  // Manages groups
Class NotificationManager
Class CalendarManager
Class StatisticsManager

Controller
Class Main  // The main controller that initializes everything. Initializes GUI as well.


Class Gui

User logs in.
User creates account
User has option to either an individual task manager or grp task manager.
Individual task manager:
	Ability to make different task categories. 
	
Group task manager:
	For groups to work together. The creator/admin can assign tasks to different individuals (We can have multiple categories for each user and the head admin can fill up those tasks). 

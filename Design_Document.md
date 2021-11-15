# Design Document


## CRC Model

![](https://github.com/CSC207-UofT/course-project-tbd/blob/9d53b51927695325d7e9261066477fc2cc88f960/CRC%20card%20(phase%201).png)

##Clean Architecture

Our group have made sure to follow the Clean Architecture when implementing the program.
As shown in the src file, the whole program is divided into layers consisted of entities;
controllers, gateways, presenters; use cases and GUI. The inner layer was implemented in
a way that they do not know or depend on the existence of the outer layer. Specifically,
all the entities do not call upon any methods of the use cases and there are no controllers
being called in the use cases. On the other hand, the outer layer was implemented to utilize
and depend on the next inner layer without skipping any layers. Our GUI only interacts with
the controllers and gateways, controllers only have access to the use cases and the use cases
are the only layer that can modify the entities. This implementation strictly follows the
Dependency Rule which states that any one of the layers in a clean architecture can encapsulate
a dependency, those dependencies can only point inward, as the inner layers are designed
not to have any knowledge of the outer layers. The only violation to the Clean Architecture
in our program is calling an entity in the Main file (which technically a file in the controller layer).
However, this is an exception since we are allowed to call any entities in the Main file in
order to run the program.

## SOLID Principles
### S - Single-responsibility Principle
The single responsibility principle states that every class must have only one reason to change.
That is, every class must only do a single job. All of our entity classes represent a single idea/enterprise business
rule. For example, in our **Group** class, we can see that it does task only related to storing information
regarding a group such as the group leader, the members and other features of our group. Moreover, **Group**
does not do any other task that is not directly related to a group. Similarly, our use-case class - **GroupManager**
is responsible for only manipulating things related to a group. All the methods in **GroupManager** does
something that is related to the group such as creating group, joining group and so on.
### O - Open-closed Principle
The open-closed principle states that a class must be open for extension but closed for modification. This means
that our classes must be able to be extended without changing/modifying how it currently looks like. If you look at how
NormalUser and User is implemented, you can see that almost everywhere
(except where the extra details given specifying it is Normal User matters), we have called the abstract class User,
rather than NormalUser. For example, in our use case class UserManager, most of the areas, we have used User rather than
UserManager. This means that in the future if we wish to add more User types like an Admin/Developer User, we can simply
extend our abstract class User and just create our new class. We would not need to edit all of our pre-existing code to
manipulate our new user.

### L - Liskov Substitution Principle
The Liskov's substitution principle states that if a class is a subclass of another class, then the program obtained by
replacing all occurrences of the parent class with the child class should still work.
Our User class is an abstract class and NormalUser extends this class. Similar to the previous example for the
Open Closed principle, we can see that throughout most of our program we have called the abstract class User rather than
NormalUser. Hence, by replacing the User with NormalUser will still run our code. This is because our User class follows
the open closed principle which enables our class to be interchanged without any issues.

### I - Interface Segregation Principle
The interface segregation principle states that the client of our software must not be forced to implement
interfaces/methods they will not use. Currently, we only have a single interface Alarm Menu which is responsible
for giving our notification. But the user has the freedom to either choose to use the alarm or disable it. Hence,
if the user does not wish to have an alarm added to their task, they need not implement the interface or take input
from the command line. All the unnecessary code and commands that might not be used have been segregated from the
client.

### D - Dependency Inversion Principle
The dependency inversion principle states that the high level code (Such as the entity classes) should not directly
depend on the lower level code (Such as our Use-case classes) rather if it is required, they must depend on an
interface or an abstraction. Currently, in our program, our entity classes do not depend on the use
case classes at all. None of our entity classes are importing our use cases or even the controllers
(In which case clean architecture would be) violated. The one issue we have with this principle is that right now our
controllers and presenters are directly working with the System.out and System.in. We will be changing this once we
finish up our GUI, and we will either Inject the Input/Output through an interface or do some other change to it.

## Code organisation
We used packages to organise our codes by layer. Doing so makes the code easily understandable to everyone working with
the code. At the top we have Database, user interface followed by controllers and presenters followed  by Use Case
classes followed by entity classes.
This follows the dependency inversion principle, where the flow control is always from the higher-level modules to
lower level modules. The use case classes depend on the entity classes, and the controllers depend on the use case
classes. But there is no direct dependence between the controllers and entity class in our project.
Our organisation structure also follows the open/closed principle, where to add new features or functionality we do not
have to modify our entity classes, but we can extend it.
In our project, entities are the highest-level policies  (core of the program), which follows the clean architecture.
The use cases can manipulate the entity classes, without changing anything inside the entity classes. Like **Task**
class is an entity class, and **TaskManager** class manipulates the attributes in task to create methods, which in turn
is used by **TaskPageController** class.  This makes testing the classes easier. 

## Design Patterns
In phase 1: We implemented Iterator Design Pattern in Category class, which stores Tasks of users’. In this way, we can
encapsulate the code. And users don’t need to know how Task is stored in Category.

Plan in Phase 2:
1.We will create another type of User called AdminUser, which will be given more functionalities than NormalUser,
We will use Factory method to create the instance of them. Then call it in controller
2.We may implement Observer Design Pattern in GroupManager, in this way, when a group is created, it will notify
UserGroupManager to add the group to user’s record. And whenever the user leave or delete group, UserGroupManager will
also be notified to make the change in User's group record.

## Coding style and documentation

To make sure we strictly follow the coding style and documentation guidelines of java, we consulted existing
documentations and coding style within the java library. For example, while we were documenting our code,
we opened ArrayList class in java and mimic the documentations they have used in their code. We also consulted
the tutrialspoint.com website (https://www.tutorialspoint.com/java/java_documentation.htm) for many other Javadoc
tags that we don’t know what they mean., such as @inheritDoc, @see, etc.. One thing worth noting is that for our
data gateway files, we are using a hash map directly to store the inputs because we know that the way we design them,
it is appropriate to use a hash map in this case.

As for the coding style, since each of us have different writing habits when it comes to code formats, such as
using spaces instead of tabs, adding spaces between operators, and the placement of brackets. We utilized the
IntelliJ re-factor feature: reformat code (Ctrl + Alt + L). We do this every time before we commit and push onto
GitHub to make sure people who are reviewing the code don’t have a hard time reading the code. We also cleared all
the warnings, which made our code cleaner. So overall, in terms of coding style and documentation, our code looks
standardized and uniform across all files, regardless of who wrote them.

## Refactoring:

Following the feedback that suggests we merge some of our controller classes, we have decided to merge
CreateGroupController, JoinGroupController, LeaveGroupController into one class. This merged class is called
GroupFunctionsController; it embodies all the functionalities of the three controllers aforementioned with each
functionality presented as methods instead. Now, each time we want to use functionalities such as create a group, we
will be calling on the method CreateGroup in the GroupFunctionsController instead.

## Test Report
We tested most of our classes, including the use case classes and entity classes. We could not test the controller and
presenters as in order to test them we would have to make a file system, and we would have to change a bunch of things.

## Use of GitHub Features
**Branches**: We created separate local branches, one for each member in the group. Each member committed their changes
to their own branch, before merging with the master branch.

**Git Status**: All the members of our group used git status after every commit to check whether the changes we 
committed actually made it into the repositories.

**Pull Requests**: After committing changed to our own branches, we created a pull request to update the master branch 
with our commit. Creating a pull requests allows other members of the group to check, test the code and review any 
conflicts before merging with the master branch.  

**Documentation**: All of our commits contained a short message to indicate what the changes being made were.

**Issues**: The issues feature on GitHub lets a member keep track of tasks to be completed. So one could link an issue 
to a pull request. We did not extensively use this feature, primarily because we split the work, splitting into groups 
of 2-3 such that another teammate can also provide their input, help resolve errors and catch mistakes.

**Actions**:  The actions feature on GitHub can help automate tasks and automatically trigger a workflow to test the 
code. While we use test cases to rigorously test our code, we also were able to see over 460 workflows created with a 
green checkmark on GitHub.

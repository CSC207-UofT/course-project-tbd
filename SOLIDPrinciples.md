## SOLID Principles
### S - Single-responsibility Principle
The single responsibility principle states that every class must have only one reason to change. 
That is, every class must only do a single job. All of our entity classes represent a single idea/enterprise business 
rule. For example, in our **Group** class, we can see that it does tasks only related to storing information
regarding a group such as the group leader, the members and other features of our group. Moreover, **Group** 
does not do any other task that is not directly related to a group. Similarly, our use-case class - **GroupManager**
is responsible for only manipulating things related to a group. All of the methods in **GroupManager** does 
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

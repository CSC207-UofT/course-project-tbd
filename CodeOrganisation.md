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




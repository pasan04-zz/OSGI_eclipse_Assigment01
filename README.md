<h3>Abstract</h3>
For this project we had chosen a Food ordering system in a restaurant. We have named it as Olive Garden Restaurant. This system was selected as there are some functions which we can implement as plug-in modules.
Moreover, the procedure we have to follow can be easily illustrated by implementing the food ordering system. We have considered two main system users when designed the solution. They are administrator and the customers of the restaurant. Features which are used by those two users were divided into some isolated modules considering the dependencies between the functions.
In order to eliminate the maintenance and the testing, and to cope up with higher performance, microkernel architecture pattern is the best solution to implement this kind of system. This project consists of three main bundles which some of them act as the publishers and some of them act as the consumers.
The source code was created in the Eclipse IDE using OSGi. The whole procedure was designed and the developed by the team members and all the team members contribute to the source codes of all bundles in design and development.
Overall mission of this project is to illustrate the best use of microkernel architecture pattern in software development.

<h3>Acknowledgement</h3>
We would first like to thank Mr. Udara Samarathunga, the lecturer in charge of the Software Architecture module, for making himself available and taking his valuable time to rectify all our doubts we had regarding the module and the assignment.
We would also like to thank lab instructors for all the guidance and support lent to carry out this assignment. We would not have done this much if it was not for them taking their valuable time to rectify the shortcomings in this assignment.

<h3Declaration</h3>
We declare that this project report or any part of it was not copied from any other person's or group’s work (published or unpublished), and has not previously submitted for assessment either at Sri Lanka Institute of Information Technology or elsewhere else.

<h3>Introduction</h3>
1. Microkernel Architecture
The microkernel architecture pattern mainly consists of two types of components. They are core system and plug-in modules. Application functionalities are divided between independent bundles as known as plug-in modules and the basic core system.

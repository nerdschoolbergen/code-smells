# Clean code and refactoring

Somewhere along the way code goes from good to bad. It's usually a combination of many small factors that when allowed 
to take hold in your project, makes it hard to work with and downright frustrating. Your code starts to smell... bad...


## [Open presentation slides](https://docs.google.com/presentation/d/19rQAnOHE2CcQ-hGvmDVPpvsr5wjYGjp6WVM8caHFLF0/edit?usp=sharing)

## Focus of this lesson
In this workshop you'll work together in a team. You'll get to know some of the most common code smells and how to fix them. After this workshop you'll know the basics of 
clean code and how to refactor your smelly code with test coverage. 

## What you need
- IntelliJ Community Edition: [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/)
- Java dev kit: [Java SE Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- Git 

## How to get started

* Start by cloning this repository into a folder on your computer. If you've never used git before, you can alternatively use the the "Download ZIP" button to the right.
* Although you have this `README.md` file on your computer it's easier to read it on GitHub, so we recommend you keep this page open with the exercise tasks.

## Exercises
This repository contains a set of exercises organized in folders. Each folder contains a `README.md` describing the exercise.

- [Exercise](assignment/)


## Helpful resources
- [IntelliJ video tutorials](https://www.jetbrains.com/idea/documentation/)
- [IntelliJ for Eclipse users](https://www.jetbrains.com/help/idea/2016.3/eclipse.html)
- [IntelliJ testing](https://www.jetbrains.com/help/idea/2016.3/testing.html)


## Shortlist of code smells and ways to fix them

* Duplicated code:
Copy/paste is dangerous! Can be that different parts of the code do the same thing. Or different algorithms that give same result.

Collect into a single place, and adhere to the Single Responsibility Principle.

	* Extract method.
	* Extract class.
	* Pull up method.
	* Form template method.

* Long method:
As functionality grows over time, so do methods. How do we know it's too long?
Line count is one measure, number of execution paths is a better measure.

Split into smaller methods. Make sure each does only one thing. Split into several classes, make sure each class has a Single Responsibility.

	* Extract method.
	* Replace temp with query.
	* Replace method with method object.
	* Decompose conditional.

* Long parameter list:
	* Replace parameter with method.
	* Introduce parameter object.
	* Preserve whole object.

* Large class/divergent change/data clumps:
Data clumps is a specific type of duplication where the same or similar group of fields can be spotted in different classes. 

Extract the clump into a class with the methods from the different classes. 

	* Extract class.
	* Extract subclass.
	* Extract interface.
	* Replace data value with object.
	* Introduce parameter object.
	* Preserve whole object.

* Data class:
All fields and no functionality makes the object a dull quiet thing.

Look around the code for functionality that naturally belongs with the fields and move it into the class. 

	* Move method.
	* Encapsulate field.
	* Encapsulate collection.

* Shotgun surgery:
Changing one small thing idea-wise ends up changing lots of similar changes all over the code.

Chances are, you are missing an object. Introduce one, so that changes to the idea can be expressed in a single place. 

	* Move method.
	* Move field.

* Feature envy/inappropriate intimacy:
A method is doing operations entirely on an object or values outside the current class.
Classes are reaching into each other for values.

The functionality is in the wrong place Move it to the object with the values it wants to be with. You may need to move 
it to a new class, or merge classes.

	* Move method.
	* Move field.
	* Extract method.

* Primitive obsession:

A programmer who thinks it’s too much overhead to use an object for just a few simple values. This is what compilers are for. 

	* Replace data value with object.
	* Replace type code with class.

* Switch statements:
Switching on an object property to do different things often means that property has meaning, not just a simple value. 

Consider replacing switch statement with polymorphism – make each value of the switching property determine a new subclass.

	* Replace conditionals with polymorphism.
	* Replace type code with subclasses.
	* Replace parameter with explicit methods.
	* Introduce null object.

* Speculative generality:
The creation of a solution that will solve that whole class of problems, and all their varieties.

You Ain't Gonna Need It. Take it out. Simple code is always better.

	* Collapse hierarchy.
	* Remove parameter.
	* Rename method.
	* Inline class.

* Temporary field:
	* Extract class.
	* Introduce null object.

* Comments:
Comments lie. Make your code expressive enough to tell the truth instead by paying attention to good naming.

	* Extract method.
	* Introduce assertion.

### Examples of how to employ common methods:
######(google is your friend)

* Pull up method:
	- Pull a method up into a superclass.

* Form template method:
	- Generalise methods so that the constituents are the same, then pull up method.
	- Have the specialised parts in subclass methods that are abstract in the super class.

* Replace conditional with polymorphism:
	- Move each "leg" of the conditional into an overriding method in a subclass, and make the original method abstract.

* Introduce null object:
	- Rather than returning null, return an object (fex a subclass) representing the null condition (i.e. base case).

* Encapsulate field:
	- Make a field private and provide getter/setter.

* Encapsulate collection:
	- Rather than get/set for a collection, provide get, add and remove methods.

* Collapse hierarchy:
	- Remove unneeded classes.

* Replace temp with query:
	- Extract expression into method.

* Decompose conditional:
	- Extract method for condition (if part), then part and else parts.

* Replace parameter with method:
	- Remove parameter and let the receiver invoke the method.

* Replace type code with subclasses:
	- Replace i.e. constants with sub classes.

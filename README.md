# Code Smells
Somewhere along the way code goes from good to bad. It's usually a combination of many small factors that when allowed to take hold in your project, makes it hard to work with and downright frustrating. Your code starts to smell... bad...

### Requirements

* Java and a IDE/text editor that can compile java and run tests.
* Git

### Ways to fix it

* Duplicated code:
	* Extract method.
	* Extract class.
	* Pull up method.
	* Form template method.

* Long method:
	* Extract method.
	* Replace temp with query.
	* Replace method with method object.
	* Decompose conditional.

* Long parameter list:
	* Replace parameter with method.
	* Introduce parameter object.
	* Preserve whole object.

* Large class/divergent change/data clumps:
	* Extract class.
	* Extract subclass.
	* Extract interface.
	* Replace data value with object.
	* Introduce parameter object.
	* Preserve whole object.

* Data class:
	* Move method.
	* Encapsulate field.
	* Encapsulate collection.

* Shotgun surgery:
	* Move method.
	* Move field.

* Feature envy:
	* Move method.
	* Move field.
	* Extract method.

* Primitive obsession:
	* Replace data value with object.
	* Replace type code with class.

* Switch statements:
	* Replace conditionals with polymorphism.
	* Replace type code with subclasses.
	* Replace parameter with explicit methods.
	* Introduce null object.

* Speculative generality:
	* Collapse hierarchy.
	* Remove parameter.
	* Rename method.
	* Inline class.

* Temporary field:
	* Extract class.
	* Introduce null object.

* Inappropriate intimacy:
	* Move method.
	* Move field.
	* Extract class.

* Comments:
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

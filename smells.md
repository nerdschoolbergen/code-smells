## Shortlist of code smells and ways to fix them

### Code Smell 1: Duplicated code

> Copy/paste is dangerous! Can be that different parts of the code do the same thing. Or different algorithms that give same result.

Collect into a single place, and adhere to the Single Responsibility Principle.

- Extract method ([IntelliJ](https://www.jetbrains.com/help/idea/extract-method.html))
- Extract class ([IntelliJ](https://www.jetbrains.com/help/idea/extract-into-class-refactorings.html))
- Pull up method ([IntelliJ](https://www.jetbrains.com/help/idea/pull-members-up.html))
- Form template method ([refactoring.guru](https://refactoring.guru/form-template-method))

### Code Smell 2: Long method

> As functionality grows over time, so do methods. How do we know it's too long?
Line count is one measure, number of execution paths is a better measure.

Split into smaller methods. Make sure each does only one thing. Split into several classes, make sure each class has a Single Responsibility.

- Extract method ([IntelliJ](https://www.jetbrains.com/help/idea/extract-method.html))
- Replace temp with query ([refactoring.guru](https://refactoring.guru/replace-temp-with-query))
- Replace method with method object ([IntelliJ](https://www.jetbrains.com/help/idea/extract-into-class-refactorings.html))
- Decompose conditional ([refactoring.guru](https://refactoring.guru/decompose-conditional))

### Code Smell 3: Long parameter list

> More than three or four parameters for a method.

- Replace parameter with method ([refactoring.guru](https://refactoring.guru/replace-parameter-with-method-call))
- Introduce parameter object ([IntelliJ](https://www.jetbrains.com/help/idea/extract-into-class-refactorings.html))
- Preserve whole object ([refactoring.guru](https://refactoring.guru/preserve-whole-object))

### Code Smell 4: Large class/divergent change/data clumps

> Data clumps is a specific type of duplication where the same or similar group of fields can be spotted in different classes.

Extract the clump into a class with the methods from the different classes.

- Extract class ([IntelliJ](https://www.jetbrains.com/help/idea/extract-into-class-refactorings.html))
- Extract subclass ([refactoring.guru](https://refactoring.guru/extract-subclass))
- Extract interface ([IntelliJ](https://www.jetbrains.com/help/idea/extract-interface.html))
- Replace data value with object ([refactoring.guru](https://refactoring.guru/replace-data-value-with-object))
- Introduce parameter object ([IntelliJ](https://www.jetbrains.com/help/idea/extract-into-class-refactorings.html))
- Preserve whole object ([refactoring.guru](https://refactoring.guru/preserve-whole-object))

### Code Smell 4: Data class

> All fields and no functionality makes the object a dull quiet thing.

Look around the code for functionality that naturally belongs with the fields and move it into the class.

- Move method ([IntelliJ](https://www.jetbrains.com/help/idea/move-refactorings.html))
- Encapsulate field ([IntelliJ](https://www.jetbrains.com/help/idea/encapsulate-fields.html))
- Encapsulate collection ([refactoring.guru](https://refactoring.guru/encapsulate-collection))

### Code Smell 4: Shotgun surgery

Changing one small thing idea-wise ends up changing lots of similar changes all over the code.

Chances are, you are missing an object. Introduce one, so that changes to the idea can be expressed in a single place.

- Move method ([IntelliJ](https://www.jetbrains.com/help/idea/move-refactorings.html))
- Move field ([IntelliJ](https://www.jetbrains.com/help/idea/move-refactorings.html))

### Code Smell 5: Feature envy/inappropriate intimacy

> A method is doing operations entirely on an object or values outside the current class. Classes are reaching into each other for values.

If the functionality is in the wrong place, move it to the object with the values it wants to be with. You may need to move it to a new class, or merge classes.

- Move method ([IntelliJ](https://www.jetbrains.com/help/idea/move-refactorings.html))
- Move field ([IntelliJ](https://www.jetbrains.com/help/idea/move-refactorings.html))
- Extract method ([IntelliJ](https://www.jetbrains.com/help/idea/extract-method.html))

### Code Smell 6: Primitive obsession

> A programmer who thinks it's too much overhead to use an object for just a few simple values. This is what compilers are for.

- Replace data value with object ([refactoring.guru](https://refactoring.guru/replace-data-value-with-object))
- Replace type code with class ([refactoring.guru](https://refactoring.guru/replace-type-code-with-class))

### Code Smell 7: Switch statements

> Switching on an object property to do different things often means that property has meaning, not just a simple value.

Consider replacing switch statement with polymorphism – make each value of the switching property determine a new subclass.

- Replace conditionals with polymorphism ([refactoring.guru](https://refactoring.guru/replace-conditional-with-polymorphism))
- Replace type code with subclasses ([refactoring.guru](https://refactoring.guru/replace-type-code-with-subclasses))
- Replace parameter with explicit methods ([refactoring.guru](https://refactoring.guru/replace-parameter-with-explicit-methods))
- Introduce null object ([refactoring.guru](https://refactoring.guru/introduce-null-object))

### Code Smell 8: Speculative generality

> The creation of a solution that will solve that whole class of problems, and all their varieties.

You Ain't Gonna Need It. Take it out. Simple code is always better.

- Collapse hierarchy ([refactoring.guru](https://refactoring.guru/collapse-hierarchy))
- Remove parameter ([IntelliJ](https://www.jetbrains.com/help/idea/change-signature.html))
- Rename method ([IntelliJ](https://www.jetbrains.com/help/idea/rename-refactorings.html))
- Inline class ([IntelliJ](https://www.jetbrains.com/help/idea/inline.html))

### Code Smell 9: Temporary field

> Temporary fields get their values (and thus are needed by objects) only under certain circumstances. Outside of these circumstances, they're empty.

- Extract class ([IntelliJ](https://www.jetbrains.com/help/idea/extract-into-class-refactorings.html))
- Introduce null object ([refactoring.guru](https://refactoring.guru/introduce-null-object))

### Code Smell 10: Comments

Comments lie. Make your code expressive enough to tell the truth instead by paying attention to good naming.

- Extract method ([IntelliJ](https://www.jetbrains.com/help/idea/extract-method.html))
- Introduce assertion ([refactoring.guru](https://refactoring.guru/introduce-assertion))

## Examples of how to employ common refactoring methods

### Pull up method ([IntelliJ](https://www.jetbrains.com/help/idea/pull-members-up.html))

Pull a method up into a superclass.

### Form template method ([refactoring.guru](https://refactoring.guru/form-template-method))

- Generalise methods so that the constituents are the same, then pull up method
- Have the specialised parts in subclass methods that are abstract in the super class.

### Replace conditional with polymorphism ([refactoring.guru](https://refactoring.guru/replace-conditional-with-polymorphism))

Move each "leg" of the conditional into an overriding method in a subclass, and make the original method abstract.

### Introduce null object ([refactoring.guru](https://refactoring.guru/introduce-null-object))

Rather than returning null, return an object (fex a subclass) representing the null condition (i.e. base case).

### Encapsulate field ([IntelliJ](https://www.jetbrains.com/help/idea/encapsulate-fields.html))

Make a field private and provide getter/setter.

### Encapsulate collection ([refactoring.guru](https://refactoring.guru/encapsulate-collection))

Rather than get/set for a collection, provide get, add and remove methods.

### Collapse hierarchy ([refactoring.guru](https://refactoring.guru/collapse-hierarchy))

Remove unneeded classes.

### Replace temp with query ([refactoring.guru](https://refactoring.guru/replace-temp-with-query))

Extract expression into method.

### Decompose conditional ([refactoring.guru](https://refactoring.guru/decompose-conditional))

Extract method for condition (if part), then part and else parts.

### Replace parameter with method ([refactoring.guru](https://refactoring.guru/replace-parameter-with-method-call))

Remove parameter and let the receiver invoke the method.

### Replace type code with subclasses ([refactoring.guru](https://refactoring.guru/replace-type-code-with-subclasses))

Replace i.e. constants with sub classes.

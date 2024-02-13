# Fix the smelly code

Form groups of about 3 people and review Pub.java in nerdschool.bar. Which code smells can you find? Refactor to remove smell(s). There is a small test suite (nerdschool.bar.PubPricesTest.java)
that will help you along the way. Introduce more tests if you need them.


You will learn to:

- Identify bad code
- Fix code smells
- Refactor with tests

## Required software and tools for this exercise

- IntelliJ Community Edition: [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/)
- Java dev kit: [Java SE Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)



## Details

:pencil2: Open `pom.xml` in IntelliJ by selecting *Import project* from the Welcome Screen. You can also use File --> New --> Project from existing sources. 

:pencil2: Run all the tests and examine the code. 

:question: What does this code do? Before you start changing the code, understand what the code does. 

:question: What is wrong with the code? There are naming issues, magical numbers, bad structure and more. 

The main part of this exercise is to refactor the code. You'll get to do much of this on your own, but here are some fairly small tasks to start with: 

:pencil2: Fix all the magical numbers. 

:pencil2: Rename existing functions so their names reflect what they do.

:pencil2: Remove bad comments.

:pencil2: Make functions where appropriate if there are clear bits of the code that are independent of the rest. 

From now on you're on your own. There are many ways to refactor this code and not necessarily one correct one. It's useful to discuss whether you see any code that should be separated into and what each class should do. Can any of the code structures you've learned about make this code easier to read and easier to maintain? If you add more drinks to the menu, how can you make the code support this in the best way possible? 


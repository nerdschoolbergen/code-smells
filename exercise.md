# Exercise: Fix the smelly code

## You will learn to

- Identify bad code
- Fix code smells
- Refactor with tests

## How to get started

* Start by cloning this repository into a folder on your computer. If you've never used git before, you can alternatively use the the "Download ZIP" button to the right.
* Although you have this `README.md` file on your computer it's easier to read it on GitHub, so we recommend you keep this page open with the exercise tasks.

## Required software and tools for this exercise

- IntelliJ Community Edition: [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/)
- Java dev kit: [Java SE Development Kit](https://www.oracle.com/java/technologies/downloads/)

:question: Not familiar with IntelliJ? Take a look at the [User interface](https://www.jetbrains.com/help/idea/guided-tour-around-the-user-interface.html) docs and the [interactive training course inside IntelliJ](https://www.jetbrains.com/help/idea/feature-trainer.html#start-a-lesson-from-the-welcome-screen).

## 1.0 - Opening the "Pub" example code in IntelliJ

:book: This repository contains an "Pub" example app.

:pencil2: Open `pom.xml` in IntelliJ by selecting *Open* from the Welcome Screen. You can also use File --> Open --> and then select the `pom.xml`. (See [Open an existing Maven project](https://www.jetbrains.com/help/idea/maven-support.html#maven_import_project_start) in the IntelliJ docs for more info about how to open projects.)

:pencil2: Select **Open as Project**.

## 1.1 - Run tests

:pencil2: Run all the tests in the `PubPricesTest` class and verify that they are all green. (See [Run tests](https://www.jetbrains.com/help/idea/performing-tests.html) in the IntelliJ docs for more info about how to run tests.)

## 1.2 - Examining the code and the tests

:pencil2: Examine the tests and the code in the `Pub` class.

:question: What does this code do? Before you start changing the code, understand what the code does.

:question: What is wrong with the code? There are naming issues, magical numbers, bad structure and more.

## 1.3 - Refactoring the code

:book: The main part of this exercise is to refactor the code. Remember that refactoring is all about changing the *internal structure* of the code *without* changing its behavior.

:exclamation: Remember to run the tests after each change to verify that behavior is unchanged

You'll get to do much of this on your own, but here are some fairly small tasks to start with. :

:pencil2: Fix all the magical numbers.

:pencil2: Rename existing functions so their names reflect what they do.

:pencil2: Remove bad comments.

:pencil2: Make functions where appropriate if there are clear bits of the code that are independent of the rest.

## 1.4 - Refactoring the code - freestyling

From now on you're on your own. There are many ways to refactor this code and not necessarily one correct one. It's useful to discuss whether you see any code that should be separated into and what each class should do.

:question: Can any of the code structures you've learned about make this code easier to read and easier to maintain?

:question: If you add more drinks to the menu, how can you make the code support this in the best way possible?

:book: See [smells.md](smells.md) for a shortlist of code smells and how to fix them.

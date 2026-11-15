# Discussion Forum Unit 1: Java's Architecture and the Expense Tracker App

**Posted by:** S M Wasir Jayed Rafi
**Course:** CS 1102-01 — Programming 1 (AY2027-T2)

## How the JVM, JDK, and JRE Get the App Running on Any Machine

Three pieces of Java sit underneath that console app before a single line of it ever runs. The JDK (Java Development Kit) is the full toolbox a developer installs to write and build the program - it bundles the compiler (`javac`), debugging tools, and the JRE itself, so it's the only piece actually needed on a development machine (Burd, 2022). The JRE (Java Runtime Environment) is a smaller slice of that: the JVM plus the standard class libraries a running program depends on, installed on a machine that only needs to *run* Java software, not build it. The JVM (Java Virtual Machine) is the part that does the real work at execution time - it loads the compiled bytecode, verifies it, and translates it into instructions the host operating system can actually run (Eck, 2022, Section 1.3). Put together, they form a one-way pipeline: the JDK's compiler produces bytecode once, and the JRE - built around the JVM - is what any target machine needs to run that same bytecode later.

The platform independence comes from where the compilation step stops. `javac` doesn't compile the junior developer's source code straight into Windows or Mac machine code; it compiles it once into bytecode, a format no real processor understands directly but every JVM does (Burd, 2022). Windows, Mac, and Linux each get their own JVM build, and each one knows how to turn that identical `.class` file into whatever its own OS needs. The startup never has to maintain three separate codebases for three operating systems - one compile produces one bytecode file, and the JVM on each machine handles the rest.

## Picking Data Types for the Expense Tracker

Each expense entry carries three pieces of information, and Java's primitive types map onto them pretty directly (Burd, 2022). The expense amount belongs in a `double`, since money needs decimal precision - an `int` would just drop the cents off a $12.49 lunch. The category ("Groceries," "Transport," "Rent") is text, so it's a `String`, not a primitive at all but the obvious choice for anything that isn't a number. The number of items purchased is a plain `int`: nobody buys 2.5 items, so there's no reason to carry decimal precision that doesn't correspond to anything real.

```java
double expenseAmount = 12.49;
String category = "Groceries";
int itemCount = 3;
```

## Validating Input and Where Typecasting Comes In

Reading these values from the keyboard means pulling in Java's `Scanner` class, which Eck's Chapter 2 and Burd's Chapter 5 both walk through (Burd, 2022; Eck, 2022, Section 2.4.6). The risky part isn't typing the import line and creating the `Scanner` object - that's boilerplate the junior developer reuses every time. It's trusting that whatever a user types is actually a number. Calling `nextDouble()` on text input throws an `InputMismatchException` and kills the program, so before pulling the value, the app should call `hasNextDouble()` and only proceed if it returns true, otherwise prompting the user again instead of crashing.

Typecasting shows up even once the input is valid. Multiplying an `int` quantity by a `double` price - `itemCount * pricePerItem` - works without the developer writing anything extra, because Java implicitly widens the `int` to a `double` before multiplying. Explicit casting matters in the other direction: if the app needs to display a quick whole-dollar budget estimate, casting a `double` total straight to `int` truncates it rather than rounding it, so $49.90 becomes $49 instead of $50. That's a real source of quiet errors in an expense tracker - calling `Math.round()` before casting down to `int` avoids silently shaving cents off a displayed total.

## Catching Errors Before and After Compilation

A missing semicolon is the classic syntax error - leaving off the `;` after `double total = 0;` stops the program from compiling at all. `javac` reports it immediately, before any bytecode is produced, which is exactly why it's a *compile-time* error rather than something that shows up mid-run.

Integer division is a different animal. `itemCount / categoryCount`, with both declared as `int`, compiles cleanly, but if `itemCount` is 7 and `categoryCount` is 2, Java doesn't give 3.5 - it truncates to 3, silently, with no error raised at all. Worse, if `categoryCount` happens to be 0, that same line throws an `ArithmeticException` at runtime and ends the program. Neither problem shows up at compile time because the syntax is valid Java; they only surface once the JVM actually executes that line.

Fixing both means two separate changes: restoring the semicolon so the file compiles, and casting one operand to `double` before dividing - `(double) itemCount / categoryCount` - so the result stops truncating. With both fixes in place, the corrected program runs in order: `javac` compiles the source into bytecode, and this time it succeeds instead of stopping at the missing semicolon; the JVM's class loader then loads and verifies that bytecode; the JVM executes `main()` line by line, now computing 3.5 instead of silently truncating it to 3; and `System.out.println()` sends the final total to the console before the JVM reclaims the program's memory and exits.

## Closing Thought

None of this is really optional groundwork for the expense tracker - the JVM is what lets the same build run on a teammate's Mac and the company's Linux server, the data types decide whether a $0.01 difference gets tracked at all, and catching integer-division truncation early is the difference between a budget tool that quietly lies to its users and one that doesn't.

## References

Burd, B. (2022). *Java for dummies* (8th ed.). John Wiley & Sons.

Eck, D. J. (2022). *Introduction to programming using Java (Version 9, JavaFX edition)*. Hobart and William Smith Colleges. https://math.hws.edu/javanotes/

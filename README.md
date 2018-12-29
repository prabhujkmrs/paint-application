# Paint
It is a simple java application that implements a simple text based drawing program.This system will  take the form of a command-line application and should allow the users to do the following:
1. Create a new canvas ( Example: **C 20 5**)
2. Draw on the canvas using text based commands (Example: **L 1 3 7 3** Or **R 15 2 20 5** where **L** means Line and **R** means Rectangle)
3. Quit the program (Example: **Q**)

## Tools used
```
Java8
Junit
Gradle
```

## Build

Run the below command to build:
```
./gradlew clean build
```

## Testing
To run the unit tests, execute:
```
./gradlew test
```

## To run
To run the application, execute:
```
java -jar build/libs/paint-application-1.0.0.jar
```







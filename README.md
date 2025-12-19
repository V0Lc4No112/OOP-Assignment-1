# OOP Assignment 1

**Course:** Object Orientated Programming (Java)  
**Teacher:** Traxel Xeniya Alexandrovna  
**Assignment:** Classes and Methods

## About this project

Assignment for OOP class containing 3 tasks:
- Rectangle class
- Book class
- Library app to manage books

## Files

- Rectangle.java - rectangle with width and height
- Book.java - book information
- LibraryApp.java - main program (run this one!)

## How to run

Can use IntelliJ IDEA or any other IDE.

Open LibraryApp.java and run it. A menu will appear in the console.

Using terminal:
```
javac *.java
java LibraryApp
```

## What each task does

### Task 1 - Rectangle
Makes rectangles and calculates area and perimeter. Each rectangle gets an ID automatically.

### Task 2 - Book
Stores book info like title, author and year. You can borrow and return books. Each book also gets an ID.

### Task 3 - Library App
This is the main program. It has a menu where you can:
1. See all books
2. Add new books
3. Search for books
4. Borrow books
5. Return books
6. Delete books
7. Exit

## Notes

The code includes input validation (year must be between 1500 and current year, title cannot be empty, etc.)

Book IDs start from 1 and increment. Deleted book IDs are not reused.

---

Made by: Mereikhan Sholanbayev  
Date: December 2025
# Experiment 06: XML Parser (DOM)
## Mini Project Theme: AniVerseX - Anime Recommendations and Reviews

## 1) Aim
To parse anime XML data using Java DOM Parser and display all anime records in console output.

## 2) What is XML Parser?
An XML Parser is a program/tool that reads XML documents and extracts structured data.
In this experiment, Java reads `anime.xml` and prints each anime record.

## 3) DOM Parser Explanation
DOM (Document Object Model) Parser loads the full XML file into memory as a tree.
Then we can access elements by tag names and read values easily.

Why DOM here:
- simple for beginners,
- easy to understand,
- good for small XML files used in lab assignments.

## 4) Files Used
```text
assignment-2/
└── 06-xml-parser/
    ├── anime.xml
    ├── sample-output.txt
    ├── README.md
    └── src/
        └── AniVerseXmlDomParser.java
```

## 5) How to Run (VS Code / Terminal)
### Prerequisite
- Install JDK 17 or above.

### In VS Code
1. Open folder: `assignment-2/06-xml-parser`
2. Open terminal in same folder.
3. Compile:
   ```bash
   javac -d out src/AniVerseXmlDomParser.java
   ```
4. Run:
   ```bash
   java -cp out AniVerseXmlDomParser anime.xml
   ```

### In Command Prompt / PowerShell
1. Go to folder:
   ```bash
   cd assignment-2/06-xml-parser
   ```
2. Compile:
   ```bash
   javac -d out src/AniVerseXmlDomParser.java
   ```
3. Run:
   ```bash
   java -cp out AniVerseXmlDomParser anime.xml
   ```

## 6) Expected Output
- Program prints total record count.
- Program prints all anime records with fields:
  - animeId
  - title
  - genre
  - episodes
  - rating
  - shortReview
  - recommendationType

Refer `sample-output.txt` for full expected console output.

## 7) Result
Successfully parsed `anime.xml` using Java DOM Parser and displayed all anime details in console.
The assignment is beginner-friendly, neat, and suitable for college submission.

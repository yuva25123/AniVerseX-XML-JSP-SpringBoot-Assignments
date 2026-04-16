# Experiment 02: XML + DTD
## Mini Project Theme: AniVerseX - Anime Recommendations and Reviews

## 1) Aim of the Experiment
To create a valid XML document for anime recommendations and validate it using an external DTD.

## 2) What is XML?
XML (eXtensible Markup Language) is used to store and transport data in a structured format.
In this experiment, XML is used to store anime details such as title, genre, rating, and review.

## 3) What is DTD?
DTD (Document Type Definition) defines the structure and rules of an XML file.
It tells:
- which elements are allowed,
- the order of elements,
- and how many times elements can appear.

Here, `anime.dtd` validates the structure of `anime.xml`.

## 4) File Structure
```text
assignment-2/
└── 02-xml-dtd/
    ├── anime.xml
    ├── anime.dtd
    └── README.md
```

## 5) How to Run / Validate
### Method 1: Basic Browser Check
1. Open `anime.xml` in a browser.
2. If no structure error appears, XML syntax is correct.

### Method 2: XML Validator Tool
1. Open any XML validation tool (online/offline).
2. Load `anime.xml`.
3. Ensure `anime.dtd` is in the same folder.
4. Run validation.
5. Output should show XML is valid against DTD.

## 6) Expected Output
- XML file loads successfully.
- DTD validation passes.
- 5 anime records are visible:
  - Naruto
  - One Piece
  - Attack on Titan
  - Demon Slayer
  - Death Note

## 7) Result
Successfully created and validated anime recommendation data using XML and external DTD.
This experiment is simple, beginner-friendly, and suitable for college submission.

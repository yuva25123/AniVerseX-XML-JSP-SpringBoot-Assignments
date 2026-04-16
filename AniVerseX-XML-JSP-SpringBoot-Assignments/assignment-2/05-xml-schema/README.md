# Experiment 05: XML Schema (XSD)
## Mini Project Theme: AniVerseX - Anime Recommendations and Reviews

## 1) Aim
To create an XML document and validate it using XML Schema (XSD) with proper data types and constraints.

## 2) What is XML Schema?
XML Schema (XSD) is used to define the structure and data type rules for XML files.
It allows strict validation such as numeric ranges and required element order.

## 3) Difference between DTD and XSD
- DTD:
  - Older schema language.
  - Limited data types.
  - Does not strongly support numeric range checks.
- XSD:
  - XML-based schema language.
  - Supports many built-in data types.
  - Supports validation rules like min/max values.

## 4) File Structure
```text
assignment-2/
└── 05-xml-schema/
    ├── anime.xml
    ├── anime.xsd
    └── README.md
```

## 5) XML Fields Used
- animeId (string)
- title (string)
- genre (string)
- episodes (integer - positive)
- rating (decimal between 0 and 10)
- shortReview (string)
- recommendationType (string)

## 6) Validation Rules Applied in XSD
- `episodes` must be a positive integer (`xs:positiveInteger`).
- `rating` must be between 0 and 10 (inclusive).

## 7) How to Validate
### Method 1: VS Code (Recommended)
1. Open folder `assignment-2/05-xml-schema` in VS Code.
2. Install extension: **XML (Red Hat)**.
3. Open `anime.xml`.
4. Ensure this line exists in root element:
   - `xsi:noNamespaceSchemaLocation="anime.xsd"`
5. Save file and check **Problems** panel.
   - No errors means XML is valid against XSD.

### Method 2: Online XML Validator
1. Open an XML/XSD validator website.
2. Upload `anime.xml` and `anime.xsd`.
3. Run validation.
4. Check result message.

## 8) Expected Output
- XML validates successfully with XSD.
- No schema errors.
- 5 anime records are accepted:
  - Naruto
  - One Piece
  - Attack on Titan
  - Demon Slayer
  - Death Note

## 9) Result
Successfully created anime XML data and validated it using XSD with proper data types and rules.
The assignment is simple, beginner-friendly, and suitable for college submission.

# Experiment 04: XQuery
## Mini Project Theme: AniVerseX - Anime Recommendations and Reviews

## 1) Aim
To write and execute basic XQuery programs on anime XML data for filtering and extracting recommendation information.

## 2) What is XQuery?
XQuery is a query language used to read and process XML data.
It is similar to SQL for XML files.
Using XQuery, we can filter records, count records, and create custom output.

## 3) Difference between XPath and XQuery
- XPath selects nodes from XML.
- XQuery can do everything XPath does plus:
  - loops (`for`)
  - conditions (`where`)
  - variables (`let`)
  - custom XML output (`return`)

So, XPath is mainly for selection, while XQuery is for selection + transformation.

## 4) XML Used
File: `anime.xml`

Fields used in each record:
- animeId
- title
- genre
- episodes
- rating
- shortReview

## 5) XQuery Programs
(Also available in `xquery-queries.txt`)

1. All anime titles
```xquery
for $a in doc("anime.xml")/animeCollection/anime
return $a/title
```

2. Anime with rating > 8.5
```xquery
for $a in doc("anime.xml")/animeCollection/anime
where xs:decimal($a/rating) > 8.5
return $a/title
```

3. Anime with episodes less than 100
```xquery
for $a in doc("anime.xml")/animeCollection/anime
where xs:integer($a/episodes) < 100
return $a/title
```

4. Anime by genre = Action
```xquery
for $a in doc("anime.xml")/animeCollection/anime
where $a/genre = "Action"
return $a/title
```

5. Count of anime records
```xquery
count(doc("anime.xml")/animeCollection/anime)
```

6. Title and shortReview
```xquery
for $a in doc("anime.xml")/animeCollection/anime
return
<animeSummary>
  {$a/title}
  {$a/shortReview}
</animeSummary>
```

7. animeId of highest rated anime
```xquery
let $maxRating := max(doc("anime.xml")/animeCollection/anime/rating/xs:decimal(.))
for $a in doc("anime.xml")/animeCollection/anime
where xs:decimal($a/rating) = $maxRating
return $a/animeId
```

## 6) Expected Output
1. All anime titles:
- Naruto
- One Piece
- Attack on Titan
- Demon Slayer
- Death Note

2. Rating > 8.5:
- One Piece
- Attack on Titan
- Demon Slayer
- Death Note

3. Episodes < 100:
- Attack on Titan
- Demon Slayer
- Death Note

4. Genre = Action:
- Naruto
- Attack on Titan
- Demon Slayer

5. Count of anime records:
- 5

6. Title and shortReview:
- XML output with `<animeSummary>` elements containing title and shortReview.

7. animeId of highest rated anime:
- A003

## 7) How to Run
### Option A: BaseX GUI (Beginner Friendly)
1. Install BaseX.
2. Open BaseX GUI.
3. Open `anime.xml` as database or use `doc("anime.xml")` query context.
4. Copy one query from `xquery-queries.txt`.
5. Execute and view result.

### Option B: BaseX Command Line
From this folder:
```bash
basex -q "for $a in doc('anime.xml')/animeCollection/anime return $a/title"
```
Run similarly for other queries.

## 8) Result
Successfully executed XQuery programs on AniVerseX XML data and retrieved required outputs.
The experiment is simple, neat, beginner-friendly, and suitable for college submission.

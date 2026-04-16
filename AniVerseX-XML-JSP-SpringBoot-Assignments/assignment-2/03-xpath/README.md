# Experiment 03: XPath
## Mini Project Theme: AniVerseX - Anime Recommendations and Reviews

## 1) Aim
To write and execute basic XPath queries on anime XML data for filtering and extracting useful recommendation information.

## 2) What is XPath?
XPath (XML Path Language) is used to select and filter data from XML documents.
It helps us query specific nodes like title, rating, genre, and reviews.

## 3) XML Used
File: `anime.xml`
Contains 5 anime records with these fields:
- animeId
- title
- genre
- episodes
- rating
- shortReview

## 4) XPath Queries
(Also available in `xpath-queries.txt`)

1. All anime titles
   - `/animeCollection/anime/title`

2. Anime with rating > 8.5
   - `/animeCollection/anime[number(rating) > 8.5]/title`

3. Anime with episodes less than 100
   - `/animeCollection/anime[number(episodes) < 100]/title`

4. Anime by genre = Action
   - `/animeCollection/anime[genre='Action']/title`

5. Count of anime records
   - `count(/animeCollection/anime)`

6. Title and shortReview
   - `/animeCollection/anime/*[self::title or self::shortReview]`

7. animeId of highest rated anime
   - `/animeCollection/anime[not(rating < /animeCollection/anime/rating)]/animeId`

## 5) Expected Output

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
- Naruto -> Classic ninja journey with strong character development.
- One Piece -> Amazing world-building and emotional storytelling.
- Attack on Titan -> Intense story with excellent plot twists.
- Demon Slayer -> Beautiful animation and emotional scenes.
- Death Note -> Brilliant mind game between Light and L.

7. animeId of highest rated anime:
- A003

## 6) How to Run
1. Open an XPath evaluator tool (online/offline) or XML IDE plugin.
2. Load `anime.xml`.
3. Run each XPath query from this README or `xpath-queries.txt`.
4. Compare result with expected output.

## 7) Result
Successfully performed XPath queries on AniVerseX anime data and extracted useful recommendation information.
This experiment is beginner-friendly, neat, and suitable for college submission.

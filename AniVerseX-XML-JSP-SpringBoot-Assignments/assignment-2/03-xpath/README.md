# 03 - XPath (AniVerseX Theme)

This assignment demonstrates basic XPath queries using anime recommendation data.

## Files in this folder

1. `anime-library.xml`
   - Source XML data for AniVerseX anime recommendations and reviews.
2. `xpath-queries.txt`
   - Beginner-friendly XPath expressions.
3. `expected-output.txt`
   - Expected result for each query.

## Learning Objective

- Understand XML node selection using XPath.
- Practice filtering using conditions.
- Use functions like `count()` and `last()`.

## How to Practice (Simple Method)

1. Open an XPath evaluator (browser-based XML/XPath tester).
2. Paste the XML from `anime-library.xml`.
3. Run one query at a time from `xpath-queries.txt`.
4. Compare your result with `expected-output.txt`.

## Sample Query Examples

- All titles:
  - `/animeLibrary/anime/title`
- Action anime:
  - `/animeLibrary/anime[genre='Action']/title`
- Highly rated anime (>=9):
  - `/animeLibrary/anime[number(rating) >= 9]/title`

## College Submission Note

Keep these 3 files together inside:
`assignment-2/03-xpath`

This module is intentionally simple and suitable for lab submission.

let $maxRating := max(/animeCollection/anime/rating ! xs:decimal(.))
for $a in /animeCollection/anime
where xs:decimal($a/rating) = $maxRating
return $a/animeId/text()

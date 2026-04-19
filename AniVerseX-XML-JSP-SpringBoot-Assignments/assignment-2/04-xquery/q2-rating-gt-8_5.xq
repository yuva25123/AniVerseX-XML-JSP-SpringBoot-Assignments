for $a in /animeCollection/anime
where xs:decimal($a/rating) > 8.5
return $a/title/text()

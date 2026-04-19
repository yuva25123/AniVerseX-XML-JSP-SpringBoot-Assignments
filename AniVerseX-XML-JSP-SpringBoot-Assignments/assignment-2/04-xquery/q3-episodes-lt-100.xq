for $a in /animeCollection/anime
where xs:integer($a/episodes) < 100
return $a/title/text()

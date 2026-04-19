for $a in /animeCollection/anime
where $a/genre = "Action"
return $a/title/text()

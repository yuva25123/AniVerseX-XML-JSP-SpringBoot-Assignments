for $a in /animeCollection/anime
return <animeSummary>
    <title>{data($a/title)}</title>
    <shortReview>{data($a/shortReview)}</shortReview>
</animeSummary>

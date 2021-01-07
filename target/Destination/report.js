$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Paytm/UpcomingMovies.feature");
formatter.feature({
  "line": 1,
  "name": "Movie export in excel",
  "description": "",
  "id": "movie-export-in-excel",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Get movies from paytm",
  "description": "",
  "id": "movie-export-in-excel;get-movies-from-paytm",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@API"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "API URL to fetch upcoming movies in paytm",
  "keyword": "Given "
});
formatter.match({
  "location": "UpcomingMovies.apiURLToFetchUpcomingMoviesInPaytm()"
});
formatter.result({
  "duration": 75907900,
  "status": "passed"
});
});
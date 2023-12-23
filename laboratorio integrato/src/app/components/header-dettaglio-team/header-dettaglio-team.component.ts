import { Component } from '@angular/core';

@Component({
  selector: 'app-header-dettaglio-team',
  templateUrl: './header-dettaglio-team.component.html',
  styleUrls: ['./header-dettaglio-team.component.scss']
})
export class HeaderDettaglioTeamComponent {
a = [
  {
    "team": "Trail Brazers",
    "conference": "West",
    "division": "Atlantic",
    "rank": 3,
    "stats": {
      "gamesPlayed": 30,
      "score": 200,
      "fieldGoalsMadePercentage": "20%",
      "threePointersMadePercentage": "20%"
    },
    "players": [
      {
        "name": "NOME COGNOME",
        "number": 71,
        "position": "Ruolo del giocatore",
        "stats": {
          "pointsPerGame": 200,
          "assists": 200,
          "rebounds": 200,
          "steals": 200,
          "something": 200
        }
      },
      // Altri giocatori...
    ],
    "teamInfo": "Lorem ipsum dolor sit amet consectetur. Velit urna vitae scelerisque nullam sed metus dictum pulvinar. Consectetur volutpat turpis nec congue.",
    "teamRecords": {
      "victoriesAtHome": 200,
      "defeatsAtHome": 200,
      "threePointersMade": 200,
      "threePointersAttempted": 200,
      "reboundsOffensive": 200,
      "reboundsDefensive": 200,
      "totalRebounds": 200,
      "assists": 200,
      "foulsCommitted": 200,
      "steals": 200,
      "turnovers": 200,
      "blocks": 200
    },
    "gameData": "Lorem ipsum dolor sit amet consectetur. Velit urna vitae scelerisque nullam sed metus dictum pulvinar. Consectetur volutpat turpis nec congue.",
    "shootingStats": {
      "fieldGoalsMade": 200,
      "totalPoints": 200,
      "fieldGoalsAttempted": 200,
      "pointsPerGame": 200,
      "fieldGoalsPercentage": "200%",
      "pointsAllowedPerGame": 200,
      "freeThrowsMade": 200,
      "freeThrowsAttempted": 200,
      "threePointersMade": 200,
      "threePointersAttempted": 200,
      "threePointersPercentage": "200%"
    }
  }
  
]

}

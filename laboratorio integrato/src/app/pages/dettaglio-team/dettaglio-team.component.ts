// dettaglio-team.component.ts

import { Component } from '@angular/core';


@Component({
  selector: 'app-dettaglio-team',
  templateUrl: './dettaglio-team.component.html',
  styleUrls: ['./dettaglio-team.component.scss']
})
export class DettaglioTeamComponent {
  data = [
    {
      team: "Trail Brazers",
      conference: "West",
      division: "Atlantic",
      rank: 3,
      stats: {
        gamesPlayed: 30,
        score: 200,
        fieldGoalsMadePercentage: "20%",
        threePointersMadePercentage: "20%"
      },
      players: [
        {
          name: "NOME COGNOME",
          number: 71,
          position: "Ruolo del giocatore",
          stats: {
            pointsPerGame: 200,
            assists: 200,
            rebounds: 200,
            steals: 200,
            something: 200
          }
        },
        {
          name: "NOME COGNOME",
          number: 71,
          position: "Ruolo del giocatore",
          stats: {
            pointsPerGame: 200,
            assists: 200,
            rebounds: 200,
            steals: 200,
            something: 200
          }
        },
        {
          name: "NOME COGNOME",
          number: 71,
          position: "Ruolo del giocatore",
          stats: {
            pointsPerGame: 200,
            assists: 200,
            rebounds: 200,
            steals: 200,
            something: 200
          }
        },
        {
          name: "NOME COGNOME",
          number: 71,
          position: "Ruolo del giocatore",
          stats: {
            pointsPerGame: 200,
            assists: 200,
            rebounds: 200,
            steals: 200,
            something: 200
          }
        },
        // Altri giocatori...
      ],
      tiri: {
        fieldGoalsMade: 200,
        fieldGoalsAttempted: 200,
        fieldGoalsPercentage: "200%",
        freeThrowsMade: 200,
        freeThrowsAttempted: 200,
        threePointersMade: 200,
        threePointersAttempted: 200,
        threePointersPercentage: "200%"
      },
      rimbalziAssist: {
        reboundsOffensive: 200,
        reboundsDefensive: 200,
        totalRebounds: 200,
        assists: 200,
      },
      punti: {
        totalPoints: 200,
        pointsPerGame: 200,
        pointsAllowedPerGame: 200
      },
      falliPalleBlocchi: {
        foulsCommitted: 200,
        steals: 200,
        turnovers: 200,
        blocks: 200
      },
      vittorieSconfitte: {
        victoriesAtHome: 200,
        defeatsAtHome: 200,
      },
      comparison: {
        points: {
          team: "30%",
          nbaAverage: "MEDIA NBA",
        },
        rebounds: {
          team: "10%",
          nbaAverage: "MEDIA NBA",
        },
        assists: {
          team: "30%",
          nbaAverage: "MEDIA NBA",
        },
        fieldGoalsMade: {
          team: "30%",
          nbaAverage: "MEDIA NBA",
        },
        twoPointersMade: {
          team: "10%",
          nbaAverage: "MEDIA NBA",
        },
        threePointersMade: {
          team: "10%",
          nbaAverage: "MEDIA NBA",
        },
      }
    }
  ];
  
}

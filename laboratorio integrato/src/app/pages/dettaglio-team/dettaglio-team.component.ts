// dettaglio-team.component.ts

import { Component } from '@angular/core';


@Component({
  selector: 'app-dettaglio-team',
  templateUrl: './dettaglio-team.component.html',
  styleUrls: ['./dettaglio-team.component.scss']
})
export class DettaglioTeamComponent {
  data: any[] = [
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
      tiri:{
        fieldGoalsMade: 200,
        fieldGoalsAttempted: 200,
        fieldGoalsPercentage: "200%",
        freeThrowsMade: 200,
        freeThrowsAttempted: 200,
        threePointersMade: 200,
        threePointersAttempted: 200,
        threePointersPercentage: "200%"

      },
      rimabalziAssist:{
        reboundsOffensive: 200,         // Rimbalzi offensivi: 200
        reboundsDefensive: 200,         // Rimbalzi difensivi: 200
        totalRebounds: 200,             // Rimbalzi totali: 200
        assists: 200, 
      },
      punti:{
        totalPoints: 200,               // Punti totali: 200
        pointsPerGame: 200,             // Punti per partita: 200
        pointsAllowedPerGame: 200 
      },
      falliPalleBlocchi: {
        foulsCommitted: 200,            // Falli commessi: 200
        steals: 200,                    // Palle rubate: 200
        turnovers: 200,                 // Palle perse: 200
        blocks: 200                     // Blocchi: 200
      },
      vittorieSconfitte: {
        victoriesAtHome: 200,           // Vittorie in casa: 200
        defeatsAtHome: 200,             // Sconfitte in casa: 200
      }
      
    }
    // Aggiungi altri oggetti dati se necessario
  ];
}

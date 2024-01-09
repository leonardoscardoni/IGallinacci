import { Component } from '@angular/core';

@Component({
  selector: 'app-dett-giocatore-indipendente',
  templateUrl: './dett-giocatore-indipendente.component.html',
  styleUrls: ['./dett-giocatore-indipendente.component.scss']
})
export class DettGiocatoreIndipendenteComponent {
  data: any[] = [
    {
      team: "Trail Brazers",
      conference: "West",
      division: "Atlantic",
      rank: 3,
      stats: {
        gamesPlayed: '30.6',
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
        fieldGoalsMade: 220,
        fieldGoalsAttempted: 454,
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

  a = {
    bgImg: "/assets/confronto-giocatori-header.jpg",
    nome1: "Clara Cosentino",
    nome2: "Alessio Strano",
    logo1: "/assets/s-l1200.webp",
    logo2: "/assets/s-l1200.webp",
    confrontoGiocatori: [
        {
            nomeGiocatore: "Clara Cosentino",
            eta: 25,
            peso: 50,
            stato: "Italia",
            altezza: "160",
            squadra: "nome squadra",
            annoIngressoNBA: 2000,
            college: "Torino",
            affiliation: "Bo",
            ruolo: "attaccante",
        },

    ],
};
}

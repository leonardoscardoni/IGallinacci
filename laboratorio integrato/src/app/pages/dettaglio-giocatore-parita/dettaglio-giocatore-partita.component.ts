import { Component } from "@angular/core";

@Component({
    selector: "app-dettaglio-giocatore-partita",
    templateUrl: "./dettaglio-giocatore-partita.component.html",
    styleUrls: ["./dettaglio-giocatore-partita.component.scss"],
})
export class DettaglioGiocatorePartitaComponent {
    a = {
        team: "Trail Brazers",
        conference: "West",
        division: "Atlantic",
        stadium: "Little Caesars Arena",
        city: "Detroit",
        squadre: [
            {
                nome: "Trail Brazers",
                logo: "/assets/s-l1200.webp",
                punteggio: 120,
            },
            {
                nome: "Raptors",
                logo: "/assets/s-l1200.webp",
                punteggio: 130,
            },
        ],
        giocatore: {
            nome: "Clara Cosentino",
            logo: "/assets/s-l1200.webp",
            ruolo: "Attaccante",
        },
        stats: {
            mins: 30,
            score: 200,
            totalRebounds: 200, // Rimbalzi totali: 200
            assists: 200,
        },
        tiri: {
            fieldGoalsMade: 200,
            fieldGoalsAttempted: 200,
            fieldGoalsPercentage: "200%",
            freeThrowsMade: 200,
            freeThrowsAttempted: 200,
            freeThrowsPercentage: "80%",
            threePointersMade: 200,
            threePointersAttempted: 200,
            threePointersPercentage: "200%",
        },
        rimabalziAssist: {
            reboundsOffensive: 200, // Rimbalzi offensivi: 200
            reboundsDefensive: 200, // Rimbalzi difensivi: 200
            totalRebounds: 200, // Rimbalzi totali: 200
            assists: 200,
        },
        falliPalleBlocchi: {
            foulsCommitted: 200, // Falli commessi: 200
            steals: 200, // Palle rubate: 200
            turnovers: 200, // Palle perse: 200
            blocks: 200, // Blocchi: 200
        },
    };
}

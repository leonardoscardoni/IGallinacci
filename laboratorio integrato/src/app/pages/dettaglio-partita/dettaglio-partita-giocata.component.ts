import { Component } from "@angular/core";

@Component({
    selector: "app-dettaglio-partita-giocata",
    templateUrl: "./dettaglio-partita-giocata.component.html",
    styleUrls: ["./dettaglio-partita-giocata.component.scss"],
})
export class DettaglioPartitaGiocataComponent {
    
    a = {
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
        date: "2024-12-22T20:30:00.000Z",
    };
}

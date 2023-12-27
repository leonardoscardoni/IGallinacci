import { Component, OnInit } from "@angular/core";
@Component({
    selector: "app-preferiti-dettaglio-partita",
    templateUrl: "./preferiti-dettaglio-partita.component.html",
    styleUrls: ["./preferiti-dettaglio-partita.component.scss"],
})
export class PreferitiDettaglioPartitaComponent implements OnInit {
    a = [
        {
            logo: "/assets/s-l1200.webp",
            giocatori: [
                {
                    nome: "Clara Cosentino",
                    numeroMaglia: "07",
                    punteggio: 30,
                    tipologia: "punti",
                },
                {
                    nome: "Mario Rossi",
                    numeroMaglia: "10",
                    punteggio: 80,
                    tipologia: "rimbalzi",
                },
                {
                    nome: "Gianluigi Ferrero",
                    numeroMaglia: "07",
                    punteggio: 0o5,
                    tipologia: "assist",
                },
            ],
        },
        {
            logo: "/assets/s-l1200.webp",
            giocatori: [
                {
                    nome: "Buon Natale",
                    numeroMaglia: "12",
                    punteggio: 70,
                    tipologia: "punti",
                },
                {
                    nome: "Matita Rossa",
                    numeroMaglia: "23",
                    punteggio: 80,
                    tipologia: "rimbalzi",
                },
                {
                    nome: "Jovanotti",
                    numeroMaglia: "07",
                    punteggio: 0o5,
                    tipologia: "assist",
                },
            ],
        },
    ];

    ngOnInit() {}
}

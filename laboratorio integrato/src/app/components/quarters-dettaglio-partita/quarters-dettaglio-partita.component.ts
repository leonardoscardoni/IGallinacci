import { Component, OnInit } from "@angular/core";

@Component({
    selector: "app-quarters-dettaglio-partita",
    templateUrl: "./quarters-dettaglio-partita.component.html",
    styleUrls: ["./quarters-dettaglio-partita.component.scss"],
})
export class QuartersDettaglioPartitaComponent implements OnInit {
    a = {
        squadre: [
            {
                nome: "STK",
                logo: "/assets/s-l1200.webp",
                punteggio: [
                    {
                        quarter: "Q1",
                        points: 120,
                    },
                    {
                        quarter: "Q2",
                        points: 130,
                    },
                    {
                        quarter: "Q3",
                        points: 135,
                    },
                    {
                        quarter: "Q4",
                        points: 160,
                    },
                ],
            },
            {
                nome: "CUL",
                logo: "/assets/s-l1200.webp",
                punteggio: [
                    {
                        quarter: "Q1",
                        points: 100,
                    },
                    {
                        quarter: "Q2",
                        points: 120,
                    },
                    {
                        quarter: "Q3",
                        points: 125,
                    },
                    {
                        quarter: "Q4",
                        points: 200,
                    },
                ],
            },
        ],
    };

    ngOnInit() {}
}

import { Component, OnInit } from "@angular/core";
@Component({
    selector: "app-statistiche-dettaglio-partita",
    templateUrl: "./statistiche-dettaglio-partita.component.html",
    styleUrls: ["./statistiche-dettaglio-partita.component.scss"],
})
export class StatisticheDettaglioPartitaComponent implements OnInit {
    a = [
        {
            titolo: "Punti da tre",
            squadre: [
                {
                    logo: "/assets/s-l1200.webp",
                    nome: "Trail brazers",
                    dato: "30%",
                },
                {
                    logo: "/assets/s-l1200.webp",
                    nome: "Cavaliers",
                    dato: "10%",
                },
            ],
        },
        {
            titolo: "Tiri da campo",
            squadre: [
                {
                    logo: "/assets/s-l1200.webp",
                    nome: "Trail brazers",
                    dato: "30%",
                },
                {
                    logo: "/assets/s-l1200.webp",
                    nome: "Cavaliers",
                    dato: "10%",
                },
            ],
        },
        {
            titolo: "Palle rubate",
            squadre: [
                {
                    logo: "/assets/s-l1200.webp",
                    nome: "Trail brazers",
                    dato: "12",
                },
                {
                    logo: "/assets/s-l1200.webp",
                    nome: "Cavaliers",
                    dato: "25",
                },
            ],
        },
    ];
    ngOnInit() {}
}

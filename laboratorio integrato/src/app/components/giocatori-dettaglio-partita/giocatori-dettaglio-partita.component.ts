import { Component, Input, OnInit } from "@angular/core";
@Component({
    selector: "app-giocatori-dettaglio-partita",
    templateUrl: "./giocatori-dettaglio-partita.component.html",
    styleUrls: ["./giocatori-dettaglio-partita.component.scss"],
})
export class GiocatoriDettaglioPartitaComponent implements OnInit {
    @Input() data!: any;
    @Input() homeTeamLogo!: string;
    @Input() visitorTeamLogo!: string;
    @Input() homeTeamName!: string;
    @Input() visitorTeamName!: string;

    a = [
        {
            logo: "/assets/s-l1200.webp",
            nome: "Nomello Squadra",
            giocatori: [
                {
                    nome: "Clara Cosentino",
                    numeroMaglia: "07",
                    ruolo: "attaccante",
                },
                {
                    nome: "Andrea Aquilino",
                    numeroMaglia: "10",
                    ruolo: "difensore",
                },
                {
                    nome: "Alessio Strano",
                    numeroMaglia: "07",
                    ruolo: "non so",
                },
                {
                    nome: "Leonardo Scardoni",
                    numeroMaglia: "27",
                    ruolo: "altro ruolo",
                },
                {
                    nome: "Ilaria Ghigliarano",
                    numeroMaglia: "30",
                    ruolo: "ruolo ruolo",
                },
            ],
        },
        {
            logo: "/assets/s-l1200.webp",
            nome: "Altra squadrina",
            giocatori: [
                {
                    nome: "Maria pia",
                    numeroMaglia: "07",
                    ruolo: "attaccante",
                },
                {
                    nome: "Padre pio",
                    numeroMaglia: "10",
                    ruolo: "difensore",
                },
                {
                    nome: "Un nome lunghinoino",
                    numeroMaglia: "07",
                    ruolo: "non so",
                },
                {
                    nome: "Super jordan",
                    numeroMaglia: "27",
                    ruolo: "altro ruolo",
                },
                {
                    nome: "Cazzo ne so",
                    numeroMaglia: "30",
                    ruolo: "ruolo ruolo",
                },
            ],
        },
    ];

    ngOnInit() {}
}

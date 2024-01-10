import { Component } from "@angular/core";

@Component({
    selector: "app-dettaglio-confronto-team",
    templateUrl: "./dettaglio-confronto-team.component.html",
    styleUrls: ["./dettaglio-confronto-team.component.scss"],
})
export class DettaglioConfrontoTeamComponent {
    a = {
        bgImg: "/assets/confronto-giocatori-header.jpg",
        nome1: "Clara Cosentino",
        nome2: "Alessio Strano",
        logo1: "/assets/s-l1200.webp",
        logo2: "/assets/s-l1200.webp",

        classifica: {
            squadra1: {
                nome: "Trail brazers",
                numero: "3",
            },
            squadra2: {
                nome: "Raptors",
                numero: "34",
            },
        },
    };
}

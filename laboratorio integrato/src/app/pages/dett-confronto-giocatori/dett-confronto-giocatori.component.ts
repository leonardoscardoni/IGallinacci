import { Component } from "@angular/core";

@Component({
    selector: "app-dett-confronto-giocatori",
    templateUrl: "./dett-confronto-giocatori.component.html",
    styleUrls: ["./dett-confronto-giocatori.component.scss"],
})
export class DettConfrontoGiocatoriComponent {
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
            },
            {
                nomeGiocatore: "Alessio Strano",
                eta: 25,
                peso: 50,
                stato: "Italia",
                altezza: "160",
                squadra: "nome squadra",
                annoIngressoNBA: 2000,
                college: "Torino",
                affiliation: "Bo",
            },
        ],
    };
}

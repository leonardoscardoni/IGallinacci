import { Component } from "@angular/core";

@Component({
    selector: "app-dett-confonto-giocatori",
    templateUrl: "./dett-confonto-giocatori.component.html",
    styleUrls: ["./dett-confonto-giocatori.component.scss"],
})
export class DettConfrontoGiocatoriComponent {
    a = {
        bgImg: "/assets/confronto-giocatori-header.jpg",
        nome1: "Clara Cosentino",
        nome2: "Alessio Strano",
        logo1: "/assets/s-l1200.webp",
        logo2: "/assets/s-l1200.webp",
    };
}

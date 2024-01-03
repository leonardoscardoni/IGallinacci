import { Component, OnInit } from "@angular/core";

@Component({
    selector: "app-elenco-giocatori",
    templateUrl: "./elenco-giocatori.component.html",
    styleUrls: ["./elenco-giocatori.component.scss"],
})
export class ElencoGiocatoriComponent implements OnInit {
    a = {
        squadre: ["squadrettina", "squadrona"],
        ruoli: ["attaccante", "difensore"],
        giocatori: [
            {
                logoSquadra: "/assets/s-l1200.webp",
                nomeGiocatore: "Clara Cosentino",
                nomeSquadra: "squadrettina",
                ruolo: "attaccante",
                provenienza: "italia",
                preferiti: false,
            },
            {
                logoSquadra: "/assets/s-l1200.webp",
                nomeGiocatore: "Lisa Bertinotti",
                nomeSquadra: "squadrona",
                ruolo: "portiere",
                provenienza: "italia",
                preferiti: false,
            },
        ],
    };

    squadraSelezionata: undefined | string = undefined;
    ruoloSelezionato: undefined | string = undefined;

    ngOnInit() {}
}

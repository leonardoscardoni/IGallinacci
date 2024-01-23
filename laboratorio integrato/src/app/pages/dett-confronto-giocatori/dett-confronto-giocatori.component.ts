import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { ConfrontoTeamType } from "src/app/_models/confrontoTeamApi.type";
import { ConfrontoPlayerType } from "src/app/_models/confrotoPlayerApi.type";
import { ApiService } from "src/app/api.service";

@Component({
    selector: "app-dett-confronto-giocatori",
    templateUrl: "./dett-confronto-giocatori.component.html",
    styleUrls: ["./dett-confronto-giocatori.component.scss"],
})
export class DettConfrontoGiocatoriComponent {
    constructor(private route: ActivatedRoute, private apiService: ApiService) {}
    data: ConfrontoPlayerType = {} as ConfrontoPlayerType;
    id1: any;
    id2: any;

    ngOnInit() {
        this.route.paramMap.subscribe((params) => {
            this.id1 = params.get("id1");
            this.id2 = params.get("id2");
            console.log("id1:", this.id1);
            console.log("id2:", this.id2);
            this.route.data.subscribe(({ getConfrontoPlayer }) => {
                this.data = getConfrontoPlayer;
                console.log(this.data);
            });
        });
    }

    bgImg = "/assets/confronto-giocatori-header.jpg";
    logo = "/assets/s-l1200.webp";
    titoli = [
        "PUNTEGGIO",
        "RIMBALZI",
        "ASSIST",
        "TIRI DA CAMPO SEGNATI",
        "TIRI DA 2 SEGNATI",
        "TIRI DA 3 SEGNATI",
    ];
}

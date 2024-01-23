import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { ConfrontoTeamType } from "src/app/_models/confrontoTeamApi.type";
import { ApiService } from "src/app/api.service";

@Component({
    selector: "app-dettaglio-confronto-team",
    templateUrl: "./dettaglio-confronto-team.component.html",
    styleUrls: ["./dettaglio-confronto-team.component.scss"],
})
export class DettaglioConfrontoTeamComponent {
    constructor(private route: ActivatedRoute, private apiService: ApiService) {}
    data: ConfrontoTeamType = {} as ConfrontoTeamType;
    id1: any;
    id2: any;

    ngOnInit() {
        this.route.paramMap.subscribe((params) => {
            this.id1 = params.get("id1");
            this.id2 = params.get("id2");
            console.log("id1:", this.id1);
            console.log("id2:", this.id2);

            this.route.data.subscribe(({ getConfrontoTeam }) => {
                this.data = getConfrontoTeam;
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

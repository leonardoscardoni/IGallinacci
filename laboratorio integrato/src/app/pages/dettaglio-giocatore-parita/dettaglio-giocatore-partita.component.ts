import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { PlayerMatchType } from "src/app/_models/playerMatchApi.type";
import { ApiService } from "src/app/api.service";

@Component({
    selector: "app-dettaglio-giocatore-partita",
    templateUrl: "./dettaglio-giocatore-partita.component.html",
    styleUrls: ["./dettaglio-giocatore-partita.component.scss"],
})
export class DettaglioGiocatorePartitaComponent {
    constructor(private route: ActivatedRoute, private apiService: ApiService) {}
    data: PlayerMatchType = {} as PlayerMatchType;
    idGame: any;
    idPlayer: any;

    ngOnInit() {
        this.route.paramMap.subscribe((params) => {
            this.idGame = params.get("idGame");
            console.log("idPartita:", this.idGame);

            this.idPlayer = params.get("idPlayer");
            console.log("idPartita:", this.idPlayer);

            this.route.data.subscribe(({ getPlayerMatch }) => {
                this.data = getPlayerMatch;
                console.log(this.data);
            });
        });
    }
}

import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { PlayerMatchType } from "src/app/_models/playerMatchApi.type";
import { ApiService } from "src/app/api.service";
import dayjs from "dayjs";
import "dayjs/locale/it"; // Importa la lingua italiana

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
    date = "";
    hour = "";

    ngOnInit() {
        this.route.paramMap.subscribe((params) => {
            this.idGame = params.get("idGame");
            console.log("idPartita:", this.idGame);

            this.idPlayer = params.get("idPlayer");
            console.log("idPlayer:", this.idPlayer);

            this.apiService.getPlayerMatchApi(this.idGame, this.idPlayer).subscribe((data) => {
                this.data = data;
                console.log("qeust", data);
            });
        });

        this.convertDate();
        this.convertHour();
    }

    convertDate() {
        const dateDayJs = dayjs(this.data.header.date).locale("it");
        this.date = dateDayJs.format("ddd D MMM, YYYY");
    }

    convertHour() {
        const hourDayJs = dayjs(this.data.header.time).locale("it");
        this.hour = hourDayJs.format("HH:mm");
    }
}

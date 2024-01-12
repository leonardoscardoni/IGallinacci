import { Component } from "@angular/core";
import { ApiService } from "../../api.service";

@Component({
    selector: "app-profilo",
    templateUrl: "./profilo.component.html",
    styleUrls: ["./profilo.component.scss"],
})
export class ProfiloComponent {
    constructor(private apiService: ApiService) {}

    numeroElementiDaVisualizzare = 3;

    a = {
        giocatoriPreferiti: [
            {
                firstname: "Clara",
                lastname: "Cosentino",
                numeroMaglia: 3,
                position: "attaccante",
                pointsForGame: 34,
                assist: 23,
                rebounds: 3,
                steals: 2,
            },
            {
                firstname: "Armando",
                lastname: "Maradona",
                numeroMaglia: 34,
                position: "attaccante",
                pointsForGame: 34,
                assist: 23,
                rebounds: 3,
                steals: 2,
            },
            {
                firstname: "Flavio",
                lastname: "Gazzelle",
                numeroMaglia: 34,
                position: "attaccante",
                pointsForGame: 34,
                assist: 23,
                rebounds: 3,
                steals: 2,
            },
            {
                firstname: "Cosa",
                lastname: "Scrivo",
                numeroMaglia: 34,
                position: "attaccante",
                pointsForGame: 34,
                assist: 23,
                rebounds: 3,
                steals: 2,
            },
        ],
        squadrePreferite: [],
    };

    get slicedPlayers(): any[] {
        if (this.a && this.a.giocatoriPreferiti.length > 0) {
            console.log("ok");
            return this.a.giocatoriPreferiti.slice(0, this.numeroElementiDaVisualizzare);
        } else {
            return [];
        }
    }

    mostraAltri() {
        this.numeroElementiDaVisualizzare = this.a.giocatoriPreferiti.length;
        console.log(this.slicedPlayers);
    }

    nascondi() {
        this.numeroElementiDaVisualizzare = 3;
        console.log(this.slicedPlayers);
    }
}

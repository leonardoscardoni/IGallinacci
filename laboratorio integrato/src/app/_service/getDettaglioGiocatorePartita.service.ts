import { Injectable, OnInit } from "@angular/core";
import { ApiService } from "../api.service";
import { ActivatedRoute } from "@angular/router";

@Injectable({
    providedIn: "root",
})
export class getDettaglioPartitaService implements OnInit {
    constructor(private apiService: ApiService) {}

    ngOnInit(): void {}

    getDettaglioGiocatorePartita(idGame: string, idPlayer: string) {
        return this.apiService.getDettaglioGiocatorePartita(idGame, idPlayer);
    }
}

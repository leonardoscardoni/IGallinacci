import { Injectable, OnInit } from "@angular/core";
import { ApiService } from "../api.service";
import { ActivatedRoute } from "@angular/router";

@Injectable({
    providedIn: "root",
})
export class getPlayerMatchResolver implements OnInit {
    constructor(private apiService: ApiService) {}

    ngOnInit(): void {}

    getPlayerMatch(idGame: string, idPlayer: string) {
        return this.apiService.getPlayerMatch(idGame, idPlayer);
    }
}

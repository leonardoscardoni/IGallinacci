import { Injectable, OnInit } from "@angular/core";
import { ApiService } from "../api.service";
import { ActivatedRoute } from "@angular/router";

@Injectable({
    providedIn: "root",
})
export class getPlayerMatchApiService implements OnInit {
    constructor(private apiService: ApiService) {}

    ngOnInit(): void {}

    getPlayerMatchApi(idGame: string, idPlayer: string) {
        return this.apiService.getPlayerMatchApi(idGame, idPlayer);
    }
}

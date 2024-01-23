import { Injectable, OnInit } from "@angular/core";
import { ApiService } from "../api.service";
import { ActivatedRoute } from "@angular/router";

@Injectable({
    providedIn: "root",
})
export class getElencoTeamResolver implements OnInit {
    constructor(private apiService: ApiService) {}

    ngOnInit(): void {}

    getElencoTeam(idPartita: string) {
        return this.apiService.getElencoTeam;
    }
}

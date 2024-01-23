import { Injectable, OnInit } from "@angular/core";
import { ApiService } from "../api.service";
import { ActivatedRoute } from "@angular/router";

@Injectable({
    providedIn: "root",
})
export class getConfrontoTeamResolver implements OnInit {
    constructor(private apiService: ApiService) {}

    ngOnInit(): void {}

    getConfrontoTeam(id1: string, id2: string) {
        return this.apiService.getConfrontoTeam(id1, id2);
    }
}

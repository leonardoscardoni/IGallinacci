import { Injectable, OnInit } from "@angular/core";
import { ApiService } from "../api.service";
import { ActivatedRoute } from "@angular/router";

@Injectable({
    providedIn: "root",
})
export class getTeamDetailResolver implements OnInit {
    constructor(private apiService: ApiService) {}

    ngOnInit(): void {}

    getTeamDetail(idPartita: string) {
        return this.apiService.getTeamDetail(idPartita);
    }
}

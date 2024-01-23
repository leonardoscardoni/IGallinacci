import { Injectable, OnInit } from "@angular/core";
import { ApiService } from "../api.service";
import { ActivatedRoute } from "@angular/router";

@Injectable({
    providedIn: "root",
})
export class getPlayerDetailIndResolver implements OnInit {
    constructor(private apiService: ApiService) {}

    ngOnInit(): void {}

    getPlayerDetailInd(id: string) {
        return this.apiService.getPlayerDetailInd(id);
    }
}

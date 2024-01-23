import { Injectable, OnInit } from "@angular/core";
import { ApiService } from "../api.service";
import { ActivatedRoute } from "@angular/router";

@Injectable({
    providedIn: "root",
})
export class getClassificaResolver implements OnInit {
    constructor(private apiService: ApiService) {}

    ngOnInit(): void {}

    getClassifica(stagione: string) {
        return this.apiService.getClassifica(stagione);
    }
}

import { Injectable, OnInit } from "@angular/core";
import { ApiService } from "../api.service";
import { ActivatedRoute } from "@angular/router";

@Injectable({
    providedIn: "root",
})
export class getDettaglioPartitaResolver implements OnInit {
    constructor(private apiService: ApiService) {}

    ngOnInit(): void {}

    getDettaglioPartita(idPartita: string) {
        return this.apiService.getDettaglioPartita(idPartita);
    }
}

import { Injectable, OnInit } from "@angular/core";
import { ApiService } from "../api.service";
import { ActivatedRoute } from "@angular/router";

@Injectable({
    providedIn: "root",
})
export class getConfrontoPlayerResolver implements OnInit {
    constructor(private apiService: ApiService) {}

    ngOnInit(): void {}

    getConfrontoPlayer(id1: string, id2: string) {
        return this.apiService.getConfrontoPlayer(id1, id2);
    }
}

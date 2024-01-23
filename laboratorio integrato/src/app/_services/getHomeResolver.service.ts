import { Injectable, OnInit } from "@angular/core";
import { ApiService } from "../api.service";
import { ActivatedRoute } from "@angular/router";

@Injectable({
    providedIn: "root",
})
export class getHomeResolver implements OnInit {
    constructor(private apiService: ApiService) {}

    ngOnInit(): void {}

    getHome() {
        return this.apiService.getHome();
    }
}

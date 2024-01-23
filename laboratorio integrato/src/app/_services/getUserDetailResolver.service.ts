import { Injectable, OnInit } from "@angular/core";
import { ApiService } from "../api.service";
import { ActivatedRoute } from "@angular/router";

@Injectable({
    providedIn: "root",
})
export class getUserDetailResolver implements OnInit {
    constructor(private apiService: ApiService) {}

    ngOnInit(): void {}

    getUserDetail() {
        return this.apiService.getUserDetail;
    }
}

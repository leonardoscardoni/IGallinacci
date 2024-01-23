import { Injectable, OnInit } from "@angular/core";
import { ApiService } from "../api.service";
import { ActivatedRoute } from "@angular/router";

@Injectable({
    providedIn: "root",
})
export class getBlogResolver implements OnInit {
    constructor(private apiService: ApiService) {}

    ngOnInit(): void {}

    getBlog(id: string) {
        return this.apiService.getBlog(id);
    }
}

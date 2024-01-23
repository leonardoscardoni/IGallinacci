import { Injectable, OnInit } from "@angular/core";
import { ApiService } from "../api.service";
import { ActivatedRoute } from "@angular/router";

@Injectable({
    providedIn: "root",
})
export class getAllBlogsResolver implements OnInit {
    constructor(private apiService: ApiService) {}

    ngOnInit(): void {}

    getAllBlogs() {
        return this.apiService.getAllBlogs();
    }
}

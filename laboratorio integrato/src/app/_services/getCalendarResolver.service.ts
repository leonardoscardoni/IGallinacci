import { Injectable, OnInit } from "@angular/core";
import { ApiService } from "../api.service";
import { ActivatedRoute } from "@angular/router";

@Injectable({
    providedIn: "root",
})
export class getCalendarResolver implements OnInit {
    constructor(private apiService: ApiService) {}

    ngOnInit(): void {}

    getCalendar(data: string) {
        return this.apiService.getDettaglioPartita(data);
    }
}

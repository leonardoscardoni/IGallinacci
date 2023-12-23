import { Component, OnInit } from "@angular/core";
import { MatchDataService } from "../../match-data.service";

@Component({
    selector: "app-today-matches",
    templateUrl: "./today-matches.component.html",
    styleUrls: ["./today-matches.component.scss"],
})
export class TodayMatchesComponent implements OnInit {
    a: any[] = [];

    constructor(private matchDataService: MatchDataService) {}

    ngOnInit() {
        this.a = this.matchDataService.getMatches();
    }
}

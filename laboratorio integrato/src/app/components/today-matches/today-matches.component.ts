import { Component, Input, OnInit } from "@angular/core";
import { MatchDataService } from "../../match-data.service";
import { TypeHome } from "src/app/_models/homeApi.type";
import dayjs from "dayjs";

@Component({
    selector: "app-today-matches",
    templateUrl: "./today-matches.component.html",
    styleUrls: ["./today-matches.component.scss"],
})
export class TodayMatchesComponent implements OnInit {
    hour = "";

    @Input() data: TypeHome = {} as TypeHome;

    ngOnInit() {

    }
    convertHour(orario:string) {
        const hourDayJs = dayjs(orario);
        return hourDayJs.format("HH:mm");
    }
}

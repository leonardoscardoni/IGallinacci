import { Component, Input, OnInit } from "@angular/core";
import { MatchDataService } from "../../match-data.service";
import { TypeHome } from "src/app/_models/homeApi.type";
import dayjs from "dayjs";
import localizedFormat from "dayjs/plugin/localizedFormat"; // Importa il plugin per il formato localizzato
import "dayjs/locale/it"; // Importa la lingua italiana
@Component({
    selector: "app-today-matches",
    templateUrl: "./today-matches.component.html",
    styleUrls: ["./today-matches.component.scss"],
})
export class TodayMatchesComponent implements OnInit {
    hour = "";

    @Input() data: TypeHome = {} as TypeHome;
    ngOnInit() {
        console.log(this.convertHour)
    }

    convertHour(time: string) {
        const dateTimeString = `2023-01-01 ${time}`;
        const hourDayJs = dayjs(dateTimeString);
        this.hour = hourDayJs.format("HH:mm");
    }
    
    
}

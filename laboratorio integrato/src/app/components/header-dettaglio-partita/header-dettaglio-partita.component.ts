import { Component, Input, OnInit } from "@angular/core";
import dayjs from "dayjs";
import localizedFormat from "dayjs/plugin/localizedFormat"; // Importa il plugin per il formato localizzato
import "dayjs/locale/it"; // Importa la lingua italiana
import { DettaglioPartitaType } from "src/app/_models/dettaglioPartita.type";

@Component({
    selector: "app-header-dettaglio-partita",
    templateUrl: "./header-dettaglio-partita.component.html",
    styleUrls: ["./header-dettaglio-partita.component.scss"],
})
export class HeaderDettaglioPartitaComponent implements OnInit {
    @Input() data: any;

    date = "";
    hour = "";

    ngOnInit() {
        this.convertDate();
        this.convertHour();
    }

    convertDate() {
        const dateDayJs = dayjs(this.data.date).locale("it");
        this.date = dateDayJs.format("ddd D MMM, YYYY");
    }

    convertHour() {
        const hourDayJs = dayjs(this.data.date).locale("it");
        this.hour = hourDayJs.format("HH:mm");
    }
}

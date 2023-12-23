import { Component, OnInit } from "@angular/core";
import dayjs from "dayjs";
import localizedFormat from "dayjs/plugin/localizedFormat"; // Importa il plugin per il formato localizzato
import "dayjs/locale/it"; // Importa la lingua italiana

@Component({
    selector: "app-header-dettaglio-partita",
    templateUrl: "./header-dettaglio-partita.component.html",
    styleUrls: ["./header-dettaglio-partita.component.scss"],
})
export class HeaderDettaglioPartitaComponent implements OnInit {
    a = {
        stadium: "Little Caesars Arena",
        city: "Detroit",
        squadre: [
            {
                nome: "Trail Brazers",
                logo: "/assets/s-l1200.webp",
                punteggio: 120,
            },
            {
                nome: "Raptors",
                logo: "/assets/s-l1200.webp",
                punteggio: 130,
            },
        ],
        date: "2024-12-22T20:30:00.000Z",
    };

    date = "";
    hour = "";

    ngOnInit() {
        this.convertDate();
        this.convertHour();
    }

    convertDate() {
        const dateDayJs = dayjs(this.a.date).locale("it");
        this.date = dateDayJs.format("ddd D MMM, YYYY");
    }

    convertHour() {
        const hourDayJs = dayjs(this.a.date).locale("it");
        this.hour = hourDayJs.format("HH:mm");
    }
}

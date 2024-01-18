import { Component, Input, OnInit } from "@angular/core";
import dayjs from "dayjs";
import localizedFormat from "dayjs/plugin/localizedFormat"; // Importa il plugin per il formato localizzato
import "dayjs/locale/it"; // Importa la lingua italiana
import { DettaglioPartitaType } from "src/app/_models/dettaglioPartita.type";

@Component({
    selector: "app-header-dettaglio-giocatore-partita",
    templateUrl: "./header-dettaglio-giocatore-partita.component.html",
    styleUrls: ["./header-dettaglio-giocatore-partita.component.scss"],
})
export class HeaderDettaglioGiocatorePartitaComponent implements OnInit {
    @Input() data: any;

    ngOnInit() {}
}

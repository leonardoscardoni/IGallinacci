import { Component, Input } from "@angular/core";
import dayjs from "dayjs";
import localizedFormat from "dayjs/plugin/localizedFormat"; // Importa il plugin per il formato localizzato
import "dayjs/locale/it"; // Importa la lingua italiana

@Component({
    selector: "app-articolo-elenco-articoli",
    templateUrl: "./articolo-elenco-articoli.component.html",
    styleUrls: ["./articolo-elenco-articoli.component.scss"],
})
export class ArticoloElencoArticoliComponent {
    @Input() data!: any;

    date = "";

    ngOnInit() {}

    convertDate(date: string) {
        const dateDayJs = dayjs(date).locale("it");
        return dateDayJs.format("D MMMM");
    }
}

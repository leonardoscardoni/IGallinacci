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

    ngOnInit() {
        this.convertDate();
        console.log(this.data);
    }

    convertDate() {
        const dateDayJs = dayjs(this.data.data).locale("it");
        this.date = dateDayJs.format("D MMMM");
    }
}

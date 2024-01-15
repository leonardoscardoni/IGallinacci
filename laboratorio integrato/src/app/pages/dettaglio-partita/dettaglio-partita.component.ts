import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { DettaglioPartitaType } from "src/app/_models/dettaglioPartita.type";
import { ApiService } from "src/app/api.service";

@Component({
    selector: "app-dettaglio-partita",
    templateUrl: "./dettaglio-partita.component.html",
    styleUrls: ["./dettaglio-partita.component.scss"],
})
export class DettaglioPartitaComponent {
    constructor(private route: ActivatedRoute, private apiService: ApiService) {}
    data: DettaglioPartitaType = {} as DettaglioPartitaType;
    idPartita: any;

    ngOnInit() {
        this.route.paramMap.subscribe((params) => {
            this.idPartita = params.get("idPartita");
            console.log("idPartita:", this.idPartita);

            this.route.data.subscribe(({ getDettaglioPartita }) => {
                this.data = getDettaglioPartita;
                console.log(this.data);
            });
        });
    }
}

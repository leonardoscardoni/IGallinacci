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

    constructor(private route: ActivatedRoute, private apiService: ApiService) {}
    data: DettaglioPartitaType = {} as DettaglioPartitaType;
    idPartita: any;
    boolGiocata: any;

    ngOnInit() {
        this.route.paramMap.subscribe((params) => {
            this.idPartita = params.get("idPartita");
            console.log("idPartita:", this.idPartita);

            this.boolGiocata = params.get("boolGiocata");
            console.log("boolGiocata:", this.boolGiocata);

            this.apiService.getDettaglioPartita(this.idPartita).subscribe((data) => {
                this.data = data;
                console.log("qeust", data);
            });
        });
    }
}

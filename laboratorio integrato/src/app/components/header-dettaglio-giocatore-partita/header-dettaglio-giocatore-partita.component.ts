import { Component, Input, OnInit } from "@angular/core";
import dayjs from "dayjs";
import localizedFormat from "dayjs/plugin/localizedFormat"; // Importa il plugin per il formato localizzato
import "dayjs/locale/it"; // Importa la lingua italiana
import { DettaglioPartitaType } from "src/app/_models/dettaglioPartita.type";
import { ApiService } from "src/app/api.service";
import { ActivatedRoute } from "@angular/router";

@Component({
    selector: "app-header-dettaglio-giocatore-partita",
    templateUrl: "./header-dettaglio-giocatore-partita.component.html",
    styleUrls: ["./header-dettaglio-giocatore-partita.component.scss"],
})
export class HeaderDettaglioGiocatorePartitaComponent {
    @Input() data: any;

    isFavourite!: boolean;
    constructor(private apiService: ApiService, private route: ActivatedRoute) {}
    data2: any = {} as any;
    ultimoSegmento!: string;

  
    ngOnInit(): void {
        const urlSegments = this.route.snapshot.url;
        this.ultimoSegmento = urlSegments[urlSegments.length - 1].path;
      }
    toggleFavourite(id:any) {
        this.apiService.getFavouritePlayer(id).subscribe((data) => {
            this.data2 = data;
            console.log(this.data);
            console.log(id);
        });
        this.isFavourite = !this.isFavourite;
    }
}

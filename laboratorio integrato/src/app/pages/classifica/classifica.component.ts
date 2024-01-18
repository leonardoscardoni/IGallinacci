import { Component } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { ApiService } from "src/app/api.service";

@Component({
    selector: "app-classifica",
    templateUrl: "./classifica.component.html",
    styleUrls: ["./classifica.component.scss"],
})
export class ClassificaComponent {
    constructor(private route: ActivatedRoute, private apiService: ApiService) {}
    stagione: string | null = "";

    ngOnInit() {
        this.route.paramMap.subscribe((params) => {
            this.stagione = params.get("stagione");
            console.log("stagione:", this.stagione);
            /* this.apiService.getClassifica(this.stagione).subscribe((data) => {
                this.data = data;
                console.log("qeust", data);
            }); */
        });
    }
    a = {
        squadreEst: [
            {
                posizioneClassifica: 1,
                idSquadra: 34,
                logo: "/assets/s-l1200.webp",
                nickName: "Nome Squadra",
                vittorie: 23,
                sconfitte: 32,
                vittorieInCasa: 20,
                vittorieFuoriCasa: 3,
                mediaPuntiPerPartita: 32,
                mediaPuntiSubitiPerPartita: 2,
                vittorieOSconfitteConsecutive: "W2",
            },
            {
                posizioneClassifica: 2,
                idSquadra: 32,
                logo: "/assets/s-l1200.webp",
                nickName: "Nomettino",
                vittorie: 23,
                sconfitte: 32,
                vittorieInCasa: 20,
                vittorieFuoriCasa: 3,
                mediaPuntiPerPartita: 32,
                mediaPuntiSubitiPerPartita: 2,
                vittorieOSconfitteConsecutive: "W2",
            },
            {
                posizioneClassifica: 3,
                idSquadra: 32,
                logo: "/assets/s-l1200.webp",
                nickName: "Ciaoneeee",
                vittorie: 23,
                sconfitte: 32,
                vittorieInCasa: 20,
                vittorieFuoriCasa: 3,
                mediaPuntiPerPartita: 32,
                mediaPuntiSubitiPerPartita: 2,
                vittorieOSconfitteConsecutive: "W2",
            },
            {
                posizioneClassifica: 4,
                idSquadra: 32,
                logo: "/assets/s-l1200.webp",
                nickName: "Che palle",
                vittorie: 23,
                sconfitte: 32,
                vittorieInCasa: 20,
                vittorieFuoriCasa: 3,
                mediaPuntiPerPartita: 32,
                mediaPuntiSubitiPerPartita: 2,
                vittorieOSconfitteConsecutive: "W2",
            },
        ],
        squadreOvest: [
            {
                posizioneClassifica: 1,
                idSquadra: 34,
                logo: "/assets/s-l1200.webp",
                nickName: "Nome Squadra",
                vittorie: 23,
                sconfitte: 32,
                vittorieInCasa: 20,
                vittorieFuoriCasa: 3,
                mediaPuntiPerPartita: 32,
                mediaPuntiSubitiPerPartita: 2,
                vittorieOSconfitteConsecutive: "W2",
            },
            {
                posizioneClassifica: 2,
                idSquadra: 32,
                logo: "/assets/s-l1200.webp",
                nickName: "Nomettino",
                vittorie: 23,
                sconfitte: 32,
                vittorieInCasa: 20,
                vittorieFuoriCasa: 3,
                mediaPuntiPerPartita: 32,
                mediaPuntiSubitiPerPartita: 2,
                vittorieOSconfitteConsecutive: "W2",
            },
            {
                posizioneClassifica: 3,
                idSquadra: 32,
                logo: "/assets/s-l1200.webp",
                nickName: "Ciaoneeee",
                vittorie: 23,
                sconfitte: 32,
                vittorieInCasa: 20,
                vittorieFuoriCasa: 3,
                mediaPuntiPerPartita: 32,
                mediaPuntiSubitiPerPartita: 2,
                vittorieOSconfitteConsecutive: "W2",
            },
            {
                posizioneClassifica: 4,
                idSquadra: 32,
                logo: "/assets/s-l1200.webp",
                nickName: "Che palle",
                vittorie: 23,
                sconfitte: 32,
                vittorieInCasa: 20,
                vittorieFuoriCasa: 3,
                mediaPuntiPerPartita: 32,
                mediaPuntiSubitiPerPartita: 2,
                vittorieOSconfitteConsecutive: "W2",
            },
        ],
    };


}

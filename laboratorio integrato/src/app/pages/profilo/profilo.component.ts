import { Component } from "@angular/core";
import { ApiService } from "../../api.service";
import { ProfileType } from "src/app/_models/profile.type";
import { Router } from "@angular/router";

@Component({
    selector: "app-profilo",
    templateUrl: "./profilo.component.html",
    styleUrls: ["./profilo.component.scss"],
})
export class ProfiloComponent {
    constructor(private apiService: ApiService, private router: Router) {}

    data: ProfileType = {} as ProfileType;
    numeroGiocatoriDaVisualizzare = 3;
    numeroSquadreDaVisualizzare = 3;
    nomeUtente: string | null = "";

    a = {
        nicknameUtente: "Clara",
        giocatoriPreferiti: [
            {
                firstname: "Clara",
                lastname: "Cosentino",
                numeroMaglia: 3,
                position: "attaccante",
                pointsForGame: 34,
                assist: 23,
                rebounds: 3,
                steals: 2,
            },
            {
                firstname: "Armando",
                lastname: "Maradona",
                numeroMaglia: 34,
                position: "attaccante",
                pointsForGame: 34,
                assist: 23,
                rebounds: 3,
                steals: 2,
            },
            {
                firstname: "Flavio",
                lastname: "Gazzelle",
                numeroMaglia: 34,
                position: "attaccante",
                pointsForGame: 34,
                assist: 23,
                rebounds: 3,
                steals: 2,
            },
            {
                firstname: "Cosa",
                lastname: "Scrivo",
                numeroMaglia: 34,
                position: "attaccante",
                pointsForGame: 34,
                assist: 23,
                rebounds: 3,
                steals: 2,
            },
        ],
        squadrePreferite: [
            {
                logo: "/assets/s-l1200.webp",
                nickname: "Che due palle",
            },
            {
                logo: "/assets/s-l1200.webp",
                nickname: "Due coglioni",
            },
            {
                logo: "/assets/s-l1200.webp",
                nickname: "NBA DI MERA",
            },
            {
                logo: "/assets/s-l1200.webp",
                nickname: "Che due palle",
            },
        ],
    };

    ngOnInit() {
        this.apiService.getUserDetail().subscribe((data: ProfileType) => {
            this.data = data;
            console.log(this.data);
        });

        this.nomeUtente = localStorage.getItem("name");

        if (!this.data.idUser) {
            this.router.navigateByUrl("/login");
        }
    }

    get slicedPlayers(): any[] {
        if (this.a && this.a.giocatoriPreferiti.length > 0) {
            return this.a.giocatoriPreferiti.slice(0, this.numeroGiocatoriDaVisualizzare);
        } else {
            return [];
        }
    }

    mostraAltriGiocatori() {
        this.numeroGiocatoriDaVisualizzare = this.a.giocatoriPreferiti.length;
        console.log(this.slicedPlayers);
    }

    nascondiGiocatori() {
        this.numeroGiocatoriDaVisualizzare = 3;
        console.log(this.slicedPlayers);
    }

    get slicedTeams(): any[] {
        if (this.a && this.a.squadrePreferite.length > 0) {
            return this.a.squadrePreferite.slice(0, this.numeroSquadreDaVisualizzare);
        } else {
            return [];
        }
    }

    mostraAltreSquadre() {
        this.numeroSquadreDaVisualizzare = this.a.squadrePreferite.length;
        console.log(this.slicedPlayers);
    }

    nascondiSquadre() {
        this.numeroSquadreDaVisualizzare = 3;
        console.log(this.slicedPlayers);
    }
}

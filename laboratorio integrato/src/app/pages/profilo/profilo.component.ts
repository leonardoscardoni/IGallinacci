import { Component } from "@angular/core";
import { ApiService } from "../../api.service";
import { ProfileType } from "src/app/_models/profile.type";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
    selector: "app-profilo",
    templateUrl: "./profilo.component.html",
    styleUrls: ["./profilo.component.scss"],
})
export class ProfiloComponent {
    constructor(
        private route: ActivatedRoute,
        private apiService: ApiService,
        private router: Router
    ) {}

    data: ProfileType = {} as ProfileType;
    numeroGiocatoriDaVisualizzare = 3;
    numeroSquadreDaVisualizzare = 3;
    nomeUtente: string | null = "";

    ngOnInit() {
        this.route.paramMap.subscribe((params) => {
            this.route.data.subscribe(({ getUserDetail }) => {
                this.data = getUserDetail;
                console.log(this.data);
            });
        });

        this.nomeUtente = localStorage.getItem("name");

        if (!localStorage.getItem("loginToken")) {
            this.router.navigateByUrl("/home");
        }
    }

    get slicedPlayers(): any[] {
        if (this.data && this.data.favPlayers.length > 0) {
            return this.data.favPlayers.slice(0, this.numeroGiocatoriDaVisualizzare);
        } else {
            return [];
        }
    }

    mostraAltriGiocatori() {
        this.numeroGiocatoriDaVisualizzare = this.data.favPlayers.length;
        console.log(this.slicedPlayers);
    }

    nascondiGiocatori() {
        this.numeroGiocatoriDaVisualizzare = 3;
        console.log(this.slicedPlayers);
    }

    get slicedTeams(): any[] {
        if (this.data && this.data.favTeam.length > 0) {
            return this.data.favTeam.slice(0, this.numeroSquadreDaVisualizzare);
        } else {
            return [];
        }
    }

    mostraAltreSquadre() {
        this.numeroSquadreDaVisualizzare = this.data.favTeam.length;
        console.log(this.slicedPlayers);
    }

    nascondiSquadre() {
        this.numeroSquadreDaVisualizzare = 3;
        console.log(this.slicedPlayers);
    }
    logout() {
        localStorage.clear();
        window.location.reload();
    }
}

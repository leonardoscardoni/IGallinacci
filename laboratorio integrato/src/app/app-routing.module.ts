import { NgModule, inject } from "@angular/core";
import { ActivatedRouteSnapshot, RouterModule, Routes } from "@angular/router";
import { HomePageComponent } from "./pages/home-page/home-page.component";
import { DettaglioPartitaComponent } from "./pages/dettaglio-partita/dettaglio-partita.component";
import { CalendarioPartiteComponent } from "./pages/calendario-partite/calendario-partite.component";
import { DettaglioTeamComponent } from "./pages/dettaglio-team/dettaglio-team.component";
import { DettConfrontoGiocatoriComponent } from "./pages/dett-confronto-giocatori/dett-confronto-giocatori.component";
import { ElencoGiocatoriComponent } from "./pages/elenco-giocatori/elenco-giocatori.component";
import { SceltaConfrontoTeamComponent } from "./pages/scelta-confronto-team/scelta-confronto-team.component";
import { DettaglioGiocatorePartitaComponent } from "./pages/dettaglio-giocatore-parita/dettaglio-giocatore-partita.component";
import { SceltaConfrontoGiocatoriComponent } from "./pages/scelta-confronto-giocatori/scelta-confronto-giocatori.component";
import { DettGiocatoreIndipendenteComponent } from "./pages/dett-giocatore-indipendente/dett-giocatore-indipendente.component";
import { ElencoArticoliComponent } from "./pages/elenco-articoli/elenco-articoli.component";
import { ElencoTeamComponent } from "./pages/elenco-team/elenco-team.component";
import { DettaglioConfrontoTeamComponent } from "./pages/dettaglio-confronto-team/dettaglio-confronto-team.component";
import { ClassificaComponent } from "./pages/classifica/classifica.component";
import { ProfiloComponent } from "./pages/profilo/profilo.component";
import { DettaglioArticoloComponent } from "./pages/dettaglio-articolo/dettaglio-articolo.component";
import { LoginComponent } from "./pages/login/login.component";
import { RegisterComponent } from "./pages/register/register.component";
import { getDettaglioPartitaResolver } from "./_services/getDettaglioPartitaResolver.service";
import { getElencoTeamResolver } from "./_services/getElencoTeamResolver.service";
import { getTeamDetailResolver } from "./_services/getTeamDetailResolver.service";
import { getClassificaResolver } from "./_services/getClassificaResolver.service";
import { getPlayerDetailIndResolver } from "./_services/getPlayerDetailIndResolver.service";
import { getConfrontoTeamResolver } from "./_services/getConfrontoTeamResolver.service";
import { getConfrontoPlayerResolver } from "./_services/getConfrontoPlayerResolver.service";
import { getCalendarResolver } from "./_services/getCalendarResolver.service";
import { getUserDetailResolver } from "./_services/getUserDetailResolver.service";
import { getPlayerMatchResolver } from "./_services/getPlayerMatchResolver.service";

const routes: Routes = [
    { path: "login", component: LoginComponent },
    { path: "register", component: RegisterComponent },
    { path: "home", component: HomePageComponent },
    {
        path: "dettaglio-partita/:idPartita",
        component: DettaglioPartitaComponent,
        resolve: {
            getDettaglioPartita: (route: ActivatedRouteSnapshot) => {
                return inject(getDettaglioPartitaResolver).getDettaglioPartita(
                    route.paramMap.get("idPartita")!
                );
            },
        },
    },
    {
        path: "elenco-team",
        component: ElencoTeamComponent,
        resolve: {
            getElencoTeam: (route: ActivatedRouteSnapshot) => {
                return inject(getElencoTeamResolver).getElencoTeam;
            },
        },
    },
    {
        path: "dettaglio-team/:id",
        component: DettaglioTeamComponent,
        resolve: {
            getTeamDetail: (route: ActivatedRouteSnapshot) => {
                return inject(getTeamDetailResolver).getTeamDetail(route.paramMap.get("id")!);
            },
        },
    },
    {
        path: "classifica/:stagione",
        component: ClassificaComponent,
        resolve: {
            getClassifica: (route: ActivatedRouteSnapshot) => {
                return inject(getClassificaResolver).getClassifica(route.paramMap.get("stagione")!);
            },
        },
    },
    {
        path: "dett-giocatore-ind/:id",
        component: DettGiocatoreIndipendenteComponent,
        resolve: {
            getPlayerDetailInd: (route: ActivatedRouteSnapshot) => {
                return inject(getPlayerDetailIndResolver).getPlayerDetailInd(
                    route.paramMap.get("id")!
                );
            },
        },
    },
    {
        path: "dettaglio-confronto-team/:id1/:id2",
        component: DettaglioConfrontoTeamComponent,
        resolve: {
            getConfrontoTeam: (route: ActivatedRouteSnapshot) => {
                return inject(getConfrontoTeamResolver).getConfrontoTeam(
                    route.paramMap.get("id1")!,
                    route.paramMap.get("id2")!
                );
            },
        },
    },
    {
        path: "dett-confronto-giocatori/:id1/:id2",
        component: DettConfrontoGiocatoriComponent,
        resolve: {
            getConfrontoPlayer: (route: ActivatedRouteSnapshot) => {
                return inject(getConfrontoPlayerResolver).getConfrontoPlayer(
                    route.paramMap.get("id1")!,
                    route.paramMap.get("id2")!
                );
            },
        },
    },
    {
        path: "profilo",
        component: ProfiloComponent,
        resolve: {
            getUserDetail: (route: ActivatedRouteSnapshot) => {
                return inject(getUserDetailResolver).getUserDetail;
            },
        },
    },
    {
        path: "dett-giocatore-partita/:idGame/:idPlayer",
        component: DettaglioGiocatorePartitaComponent,
        resolve: {
            getPlayerMatch: (route: ActivatedRouteSnapshot) => {
                return inject(getPlayerMatchResolver).getPlayerMatch(
                    route.paramMap.get("idGame")!,
                    route.paramMap.get("idPlayer")!
                );
            },
        },
    },
    {
        path: "calendario-partite",
        component: CalendarioPartiteComponent,
    },
    { path: "elenco-giocatori", component: ElencoGiocatoriComponent },
    { path: "blog", component: ElencoArticoliComponent },
    { path: "scelta-confronto-team", component: SceltaConfrontoTeamComponent },
    { path: "scelta-confronto-giocatori", component: SceltaConfrontoGiocatoriComponent },
    {
        path: "dettaglio-articolo",
        component: DettaglioArticoloComponent,
    },
    { path: "", redirectTo: "home", pathMatch: "full" },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}

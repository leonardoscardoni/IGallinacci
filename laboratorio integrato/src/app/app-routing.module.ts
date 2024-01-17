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
import { getDettaglioPartitaService } from "./_service/getDettaglioPartita.service";

const routes: Routes = [
    { path: "login", component: LoginComponent },
    { path: "register", component: RegisterComponent },
    { path: "home", component: HomePageComponent },
    {
        path: "dettaglio-partita/:idPartita",
        component: DettaglioPartitaComponent,
        resolve: {
            getDettaglioPartita: (route: ActivatedRouteSnapshot) => {
                return inject(getDettaglioPartitaService).getDettaglioPartita(
                    route.paramMap.get("idPartita")!
                );
            },
        },
    },
    { path: "calendario-partite", component: CalendarioPartiteComponent },
    { path: "dettaglio-team/:id", component: DettaglioTeamComponent },
    { path: "dett-confronto-giocatori/:id1/:id2", component: DettConfrontoGiocatoriComponent },
    { path: "dett-giocatore-ind/:id", component: DettGiocatoreIndipendenteComponent },
    { path: "elenco-giocatori", component: ElencoGiocatoriComponent },
    { path: "elenco-articoli", component: ElencoArticoliComponent },
    { path: "scelta-confronto-team", component: SceltaConfrontoTeamComponent },
    { path: "dett-giocatore-partita", component: DettaglioGiocatorePartitaComponent },
    { path: "scelta-confronto-giocatori", component: SceltaConfrontoGiocatoriComponent },
    { path: "elenco-team", component: ElencoTeamComponent },
    {
        path: "dettaglio-confronto-team/:id1/:id2",
        component: DettaglioConfrontoTeamComponent,
    },
    {
        path: "classifica/:stagione",
        component: ClassificaComponent,
    },
    {
        path: "profilo",
        component: ProfiloComponent,
    },
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

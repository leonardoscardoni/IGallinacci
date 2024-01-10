import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HomePageComponent } from "./pages/home-page/home-page.component";
import { DettaglioPartitaGiocataComponent } from "./pages/dettaglio-partita/dettaglio-partita-giocata.component";
import { CalendarioPartiteComponent } from "./pages/calendario-partite/calendario-partite.component";
import { DettaglioTeamComponent } from "./pages/dettaglio-team/dettaglio-team.component";
import { DettConfrontoGiocatoriComponent } from "./pages/dett-confronto-giocatori/dett-confronto-giocatori.component";
import { ElencoGiocatoriComponent } from "./pages/elenco-giocatori/elenco-giocatori.component";
import { SceltaConfrontoTeamComponent } from "./pages/scelta-confronto-team/scelta-confronto-team.component";
import { DettaglioGiocatorePartitaComponent } from "./pages/dettaglio-giocatore-parita/dettaglio-giocatore-partita.component";
import { SceltaConfrontoGiocatoriComponent } from "./pages/scelta-confronto-giocatori/scelta-confronto-giocatori.component";
import { DettGiocatoreIndipendenteComponent } from "./pages/dett-giocatore-indipendente/dett-giocatore-indipendente.component";
import { ElencoArticoliComponent } from "./pages/elenco-articoli/elenco-articoli.component";
import { ElencoTeamComponent } from "./elenco-team/elenco-team.component";
import { DettaglioConfrontoTeamComponent } from "./pages/dettaglio-confronto-team/dettaglio-confronto-team.component";


const routes: Routes = [
    { path: "home", component: HomePageComponent },
    { path: "dett-partita-giocata", component: DettaglioPartitaGiocataComponent },
    { path: "calendario-partite", component: CalendarioPartiteComponent },
    { path: "dettaglio-team", component: DettaglioTeamComponent },
    { path: "dett-confronto-giocatori", component: DettConfrontoGiocatoriComponent },
    { path: "dett-giocatore-ind", component: DettGiocatoreIndipendenteComponent },
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
      
    { path: "", redirectTo: "home", pathMatch: "full" },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}

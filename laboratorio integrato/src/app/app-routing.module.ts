import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HomePageComponent } from "./pages/home-page/home-page.component";
import { DettaglioPartitaComponent } from "./pages/dettaglio-partita/dettaglio-partita-giocata.component";
import { CalendarioPartiteComponent } from "./pages/calendario-partite/calendario-partite.component";
import { DettaglioTeamComponent } from "./pages/dettaglio-team/dettaglio-team.component";
import { DettConfrontoGiocatoriComponent } from "./pages/dett-confronto-giocatori/dett-confronto-giocatori.component";
import { ElencoGiocatoriComponent } from "./pages/elenco-giocatori/elenco-giocatori.component";
import { SceltaConfrontoTeamComponent } from "./pages/scelta-confronto-team/scelta-confronto-team.component";
import { DettaglioArticoloNonLoggatoComponent } from "./pages/dettaglio-articolo-non-loggato/dettaglio-articolo-non-loggato.component";
import { DettaglioArticoloLoggatoComponent } from "./pages/dettaglio-articolo-loggato/dettaglio-articolo-loggato.component";




const routes: Routes = [
    { path: "home", component: HomePageComponent },
    { path: "dett", component: DettaglioPartitaComponent },
    { path: "calendario-partite", component: CalendarioPartiteComponent },
    { path: "dettaglio-team", component: DettaglioTeamComponent },
    { path: "dett-confronto-giocatori", component: DettConfrontoGiocatoriComponent },
    { path: "elenco-giocatori", component: ElencoGiocatoriComponent },
    { path: "scelta-confronto-team", component: SceltaConfrontoTeamComponent },
    { path: "dettaglio-articolo-non-loggato", component: DettaglioArticoloNonLoggatoComponent },
    { path: "dettaglio-articolo-loggato", component: DettaglioArticoloLoggatoComponent },
    { path: "", redirectTo: "home", pathMatch: "full" },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}

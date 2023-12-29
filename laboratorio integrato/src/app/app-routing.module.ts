import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HomePageComponent } from "./pages/home-page/home-page.component";
import { DettaglioPartitaComponent } from "./pages/dettaglio-partita/dettaglio-partita-giocata.component";
import { CalendarioPartiteComponent } from "./pages/calendario-partite/calendario-partite.component";
import { DettaglioTeamComponent } from "./pages/dettaglio-team/dettaglio-team.component";
import { DettConfrontoGiocatoriComponent } from "./pages/dett-confronto-giocatori/dett-confronto-giocatori.component";
import { ProvaApiComponent } from "./prova-api/prova-api.component";

const routes: Routes = [
    { path: "home", component: HomePageComponent },
    { path: "dett", component: DettaglioPartitaComponent },
    { path: "calendario-partite", component: CalendarioPartiteComponent },
    { path: "dettaglio-team", component: DettaglioTeamComponent },
    { path: "dett-confronto-giocatori", component: DettConfrontoGiocatoriComponent },
    { path: "a", component: ProvaApiComponent },
    { path: "", redirectTo: "home", pathMatch: "full" },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}

import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HomePageComponent } from "./pages/home-page/home-page.component";
import { DettaglioPartitaComponent } from "./pages/dettaglio-partita/dettaglio-partita-giocata.component";
import { CalendarioPartiteComponent } from "./pages/calendario-partite/calendario-partite.component";
import { DettConfrontoGiocatoriComponent } from "./pages/dett-confronto-giocatori/dett-confonto-giocatori.component";

const routes: Routes = [
    { path: "home", component: HomePageComponent },
    { path: "dett", component: DettaglioPartitaComponent },
    { path: "calendario-partite", component: CalendarioPartiteComponent },
    { path: "dett-confronto-giocatori", component: DettConfrontoGiocatoriComponent },
    { path: "", redirectTo: "home", pathMatch: "full" },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}

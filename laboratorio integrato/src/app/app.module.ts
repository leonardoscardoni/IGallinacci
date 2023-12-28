import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { NavbarComponent } from "./components/navbar/navbar.component";
import { HeaderComponent } from "./components/header/header.component";
import { HomePageComponent } from "./pages/home-page/home-page.component";
import { DettaglioPartitaComponent } from "./pages/dettaglio-partita/dettaglio-partita-giocata.component";
import { PerTeComponent } from "./components/per-te/per-te.component";
import { TodayMatchesComponent } from "./components/today-matches/today-matches.component";
import { FooterComponent } from "./components/footer/footer.component";
import { CalendarioPartiteComponent } from "./pages/calendario-partite/calendario-partite.component";
import { HeaderDettaglioPartitaComponent } from "./components/header-dettaglio-partita/header-dettaglio-partita.component";
import { QuattroConfrontiComponent } from "./components/quattro-confronti/quattro-confronti.component";
import { TitoloSezioneComponent } from "./components/titolo-sezione/titolo-sezione.component";
import { StatisticheDettaglioPartitaComponent } from "./components/statistiche-dettaglio-partita/statistiche-dettaglio-partita.component";
import { PreferitiDettaglioPartitaComponent } from "./components/preferiti-dettaglio-partita/preferiti-dettaglio-partita.component";
import { GiocatoriDettaglioPartitaComponent } from "./components/giocatori-dettaglio-partita/giocatori-dettaglio-partita.component";
import { CardConfrontoDatiComponent } from "./components/card-confronto-dati/card-confronto-dati.component";
import { HeaderConfrontoComponent } from "./components/header-confronto/header-confronto.component";
import { DettConfrontoGiocatoriComponent } from "./pages/dett-confronto-giocatori/dett-confonto-giocatori.component";

@NgModule({
    declarations: [
        AppComponent,
        NavbarComponent,
        HeaderComponent,
        HomePageComponent,
        DettaglioPartitaComponent,
        PerTeComponent,
        TodayMatchesComponent,
        FooterComponent,
        CalendarioPartiteComponent,
        HeaderDettaglioPartitaComponent,
        TitoloSezioneComponent,
        QuattroConfrontiComponent,
        StatisticheDettaglioPartitaComponent,
        PreferitiDettaglioPartitaComponent,
        GiocatoriDettaglioPartitaComponent,
        CardConfrontoDatiComponent,
        HeaderConfrontoComponent,
        DettConfrontoGiocatoriComponent,
    ],
    imports: [BrowserModule, AppRoutingModule],
    providers: [],
    bootstrap: [AppComponent],
})
export class AppModule {}

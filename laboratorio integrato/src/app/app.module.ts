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
import { DettaglioTeamComponent } from "./pages/dettaglio-team/dettaglio-team.component";
import { HeaderDettaglioTeamComponent } from "./components/header-dettaglio-team/header-dettaglio-team.component";
import { PosizioneInClassificaComponent } from "./components/posizione-in-classifica/posizione-in-classifica.component";
import { DatiPrincipaliComponent } from "./components/dati-principali/dati-principali.component";
import { LaSquadraComponent } from "./components/la-squadra/la-squadra.component";
import { DatiGeneraliComponent } from "./components/dati-generali/dati-generali.component";
import { ContainerDatiGeneraliComponent } from "./components/container-dati-generali/container-dati-generali.component";
import { ProvaApiComponent } from './prova-api/prova-api.component';
import { HttpClientModule } from "@angular/common/http";
import { UltimiRisultatiHomeComponent } from './components/ultimi-risultati-home/ultimi-risultati-home.component';

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
        DettaglioTeamComponent,
        HeaderDettaglioTeamComponent,
        PosizioneInClassificaComponent,
        DatiPrincipaliComponent,
        LaSquadraComponent,
        DatiGeneraliComponent,
        ContainerDatiGeneraliComponent,
        ProvaApiComponent,
        UltimiRisultatiHomeComponent,
    ],
    imports: [BrowserModule, AppRoutingModule,HttpClientModule],
    providers: [],
    bootstrap: [AppComponent],
})
export class AppModule {}

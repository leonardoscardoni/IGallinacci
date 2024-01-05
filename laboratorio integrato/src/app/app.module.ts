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
import { ContenitoreCardConfrontoDatiComponent } from "./components/contenitore-card-confronto-dati/contenitore-card-confronto-dati.component";
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
import { HeaderConfrontoDettaglioComponent } from "./components/header-confronto-dettaglio/header-confronto-dettaglio.component";
import { DettConfrontoGiocatoriComponent } from "./pages/dett-confronto-giocatori/dett-confronto-giocatori.component";
import { BioGiocatoreComponent } from "./components/bio-giocatore/bio-giocatore.component";
import { HttpClientModule } from "@angular/common/http";
import { UltimiRisultatiHomeComponent } from "./components/ultimi-risultati-home/ultimi-risultati-home.component";
import { ElencoGiocatoriComponent } from "./pages/elenco-giocatori/elenco-giocatori.component";
import { DropdownModule } from "primeng/dropdown";
import { ReactiveFormsModule, FormsModule } from "@angular/forms";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { SceltaConfrontoTeamComponent } from "./pages/scelta-confronto-team/scelta-confronto-team.component";
import { HeaderBgTitoloComponent } from "./components/header-bg-titolo/header-bg-titolo.component";
import { SelezioneConfrontoSquadreComponent } from "./components/selezione-confronto-squadre/selezione-confronto-squadre.component";
import { ArticoloLoggatoComponent } from './components/articolo-loggato/articolo-loggato.component';
import { DettaglioArticoloNonLoggatoComponent } from './pages/dettaglio-articolo-non-loggato/dettaglio-articolo-non-loggato.component';
import { ArticoloLoggatoTxtComponent } from './components/articolo-loggato-txt/articolo-loggato-txt.component';
import { ArticoloLoggatoSectionComponent } from './components/articolo-loggato-section/articolo-loggato-section.component';
import { DettaglioArticoloLoggatoComponent } from './pages/dettaglio-articolo-loggato/dettaglio-articolo-loggato.component';

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
        ContenitoreCardConfrontoDatiComponent,
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
        HeaderConfrontoDettaglioComponent,
        DettConfrontoGiocatoriComponent,
        BioGiocatoreComponent,
        UltimiRisultatiHomeComponent,
        ElencoGiocatoriComponent,
        SceltaConfrontoTeamComponent,
        HeaderBgTitoloComponent,
        SelezioneConfrontoSquadreComponent,
        ArticoloLoggatoComponent,
        DettaglioArticoloNonLoggatoComponent,
        ArticoloLoggatoTxtComponent,
        ArticoloLoggatoSectionComponent,
        DettaglioArticoloLoggatoComponent,
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        DropdownModule,
        ReactiveFormsModule,
        FormsModule,
        BrowserAnimationsModule,
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
    ],
    providers: [],
    bootstrap: [AppComponent],
})
export class AppModule {}

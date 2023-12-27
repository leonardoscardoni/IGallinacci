import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HeaderComponent } from './header/header.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { DettaglioPartitaComponent } from './pages/dettaglio-partita/dettaglio-partita.component';
import { PerTeComponent } from './per-te/per-te.component';
import { TodayMatchesComponent } from './today-matches/today-matches.component';
import { FooterComponent } from './footer/footer.component';
import { CalendarioPartiteComponent } from './pages/calendario-partite/calendario-partite.component';
import { ElencoTeamComponent } from './elenco-team/elenco-team.component';
import { DatiConfrontoTeamComponent } from './dati-confronto-team/dati-confronto-team.component';

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
    ElencoTeamComponent,
    DatiConfrontoTeamComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

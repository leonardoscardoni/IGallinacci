import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { DettaglioPartitaComponent } from './pages/dettaglio-partita/dettaglio-partita.component';
import { CalendarioPartiteComponent } from './pages/calendario-partite/calendario-partite.component';
import { ElencoTeamComponent } from './elenco-team/elenco-team.component';

const routes: Routes = [
  { path: 'home', component: HomePageComponent },
  { path: 'dett', component: DettaglioPartitaComponent },
  { path: 'calendario-partite', component: CalendarioPartiteComponent },
  { path: 'elenco-team', component: ElencoTeamComponent },
  { path: '',   redirectTo: 'home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

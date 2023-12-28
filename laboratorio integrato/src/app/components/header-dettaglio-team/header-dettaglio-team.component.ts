import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-header-dettaglio-team',
  templateUrl: './header-dettaglio-team.component.html',
  styleUrls: ['./header-dettaglio-team.component.scss']
})
export class HeaderDettaglioTeamComponent {

@Input() data: any[] = [];

}

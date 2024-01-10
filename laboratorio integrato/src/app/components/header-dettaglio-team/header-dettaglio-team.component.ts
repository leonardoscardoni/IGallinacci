import { Component, Input } from '@angular/core';
import { TeamDetailType } from 'src/app/_models/TeamDetailApi.type';

@Component({
  selector: 'app-header-dettaglio-team',
  templateUrl: './header-dettaglio-team.component.html',
  styleUrls: ['./header-dettaglio-team.component.scss']
})
export class HeaderDettaglioTeamComponent {

  @Input() data: TeamDetailType | undefined;

  
}

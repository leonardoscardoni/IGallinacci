// dettaglio-team.component.ts

import { Component } from '@angular/core';
import { TeamDetailType } from 'src/app/_models/TeamDetailApi.type';
import { TeamType } from 'src/app/_models/divisionTeamApi.type';
import { ApiService } from 'src/app/api.service';


@Component({
  selector: 'app-dettaglio-team',
  templateUrl: './dettaglio-team.component.html',
  styleUrls: ['./dettaglio-team.component.scss']
})
export class DettaglioTeamComponent {
  constructor(private apiService: ApiService) {}
  data: TeamDetailType = {} as TeamDetailType
  
  ngOnInit() {
    this.apiService.getTeamDetailApi().subscribe((data) => {
      this.data = data;
      console.log(this.data)
    });
  }
  
}

// dettaglio-team.component.ts

import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TeamDetailType } from 'src/app/_models/TeamDetailApi.type';
import { TeamType } from 'src/app/_models/divisionTeamApi.type';
import { ApiService } from 'src/app/api.service';


@Component({
  selector: 'app-dettaglio-team',
  templateUrl: './dettaglio-team.component.html',
  styleUrls: ['./dettaglio-team.component.scss']
})
export class DettaglioTeamComponent {
  constructor(private route: ActivatedRoute,private apiService: ApiService) {}
  data: TeamDetailType = {} as TeamDetailType
  logo= "/assets/s-l1200.webp"
  id:any

  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      this.id = params.get('id');
      this.apiService.getTeamDetailApi(this.id).subscribe((data) => {
        this.data = data
        console.log('qeust',data);
      });
    });
  }
  
}

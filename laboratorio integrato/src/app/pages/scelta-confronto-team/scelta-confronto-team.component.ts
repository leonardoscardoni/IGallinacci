import { Component } from '@angular/core';
import { TeamType } from 'src/app/_models/divisionTeamApi.type';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-scelta-confronto-team',
  templateUrl: './scelta-confronto-team.component.html',
  styleUrls: ['./scelta-confronto-team.component.scss']
})
export class SceltaConfrontoTeamComponent {
  constructor(private apiService: ApiService) {}
  data: TeamType = {} as TeamType
  
  ngOnInit() {
    this.apiService.getDivisionApi().subscribe((data) => {
      this.data = data;
      console.log(this.data)
    });
  }
}

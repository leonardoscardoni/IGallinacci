import { Component } from '@angular/core';
import { TeamPlayerFilterType } from 'src/app/_models/teamPlayerFilter.type';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-scelta-confronto-giocatori',
  templateUrl: './scelta-confronto-giocatori.component.html',
  styleUrls: ['./scelta-confronto-giocatori.component.scss']
})
export class SceltaConfrontoGiocatoriComponent {
  
  constructor(private apiService: ApiService) {}
  data: TeamPlayerFilterType = {} as TeamPlayerFilterType
  ngOnInit() {
      this.apiService.getTeamPlayerFilter().subscribe((data) => {
        this.data = data;
        console.log(this.data)
      });
    }
}

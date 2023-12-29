import { Component } from '@angular/core';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-scelta-confronto-team',
  templateUrl: './scelta-confronto-team.component.html',
  styleUrls: ['./scelta-confronto-team.component.scss']
})
export class SceltaConfrontoTeamComponent {
  constructor(private apiService: ApiService) {}
  data: any
  
  ngOnInit() {
    this.apiService.getDivisionApi().subscribe((data) => {
      this.data = data;
      console.log(this.data)
    });
  }
}

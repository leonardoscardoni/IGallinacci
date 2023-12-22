import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MatchDataService {
  a = [
    {
      id: 0,
      match: {
        date: '2023-01-01',
        location: 'Stadium A',
        squadra1: {
          name: 'Lakers',
          point: 103,
        },
        squadra2: {
          name: 'Bulls',
          point: 95,
        },
        ora:'18:00',
      }
    },
    {
      id: 1,
      match: {
        date: '2023-01-02',
        location: 'Stadium B',
        squadra1: {
          name: 'celtic',
          point: 102
        },
        squadra2: {
          name: 'raptor',
          point: 140
        }
        ,
        ora:'18:00',
      }
    },
    {
      id: 2,
      match: {
        date: '2023-01-02',
        location: 'Stadium B',
        squadra1: {
          name: 'altro',
          point: 75
        },
        squadra2: {
          name: 'qualcosa',
          point: 121
        }
        ,
        ora:'18:00',
      }
    },
    {
      id: 3,
      match: {
        date: '2023-01-02',
        location: 'Stadium B',
        squadra1: {
          name: 'Timberwolves',
          point: 175
        },
        squadra2: {
          name: 'Timberwolves',
          point: 173
        },
        ora:'18:00',
      }
    },
    {
      id: 4,
      match: {
        date: '2023-01-02',
        location: 'Stadium B',
        squadra1: {
          name: 'altro',
          point: 20
        },
        squadra2: {
          name: 'qualcosa',
          point: 57
        },
        ora:'18:00',
      }
    },
  ];

  getMatches() {
    return this.a;
  }

}

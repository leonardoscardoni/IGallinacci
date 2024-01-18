export interface TypeHome {
    pastGames: PastGame[];
    nextGames: NextGame[];
}

interface NextGame {
    id:          number;
    time:        string;
    homeTeam:    Team;
    visitorTeam: Team;
}

interface Team {
    id:       number;
    nickname: string;
    logo:     string;
    points?:  number;
}

interface PastGame {
    id:          number;
    homeTeam:    Team;
    visitorTeam: Team;
}

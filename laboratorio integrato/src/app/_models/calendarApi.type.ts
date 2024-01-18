export interface CalendarType {
    game: Game[];
}

export interface Game {
    id:          number;
    date:        Date;
    time:        string;
    homeTeam:    Team;
    visitorTeam: Team;
}

export interface Team {
    id:       number;
    nickname: string;
    logo:     string;
}

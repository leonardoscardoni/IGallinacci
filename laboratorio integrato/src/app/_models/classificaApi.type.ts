export interface ClassificaType {
    eastTeams: StTeam[];
    westTeams: StTeam[];
}

export interface StTeam {
    rank:                        number;
    idTeam:                      number;
    logo:                        string;
    nickname:                    string;
    win:                         number;
    loss:                        number;
    winHome:                     number;
    winAway:                     number;
    averagePointsByGame:         number;
    averagePointsConcededByGame: number;
    consecutiveWinsOrLosses:     number;
}

export interface ConfrontoTeamType {
    team1:              Team;
    team2:              Team;
    dataCompareTeamNba: DataCompareTeamNba[];
}

export interface DataCompareTeamNba {
    dataName:  string;
    dataTeam1: number;
    datateam2: number;
}

export interface Team {
    name:           string;
    logo:           string;
    conference:     string;
    rankConference: number;
}

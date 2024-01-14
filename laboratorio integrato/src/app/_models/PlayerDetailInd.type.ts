export interface PlayerDetailIndType {
    favourite:        boolean;
    idPlayer:         number;
    firstName:        string;
    lastName:         string;
    idTeam:           number;
    logo:             string;
    nameTeam:         string;
    games:            Games;
    playerBio:        PlayerBio;
    shots:            Shots;
    assistRebounds:   AssistRebounds;
    foulsBallsBlocks: FoulsBallsBlocks;
    points:           Points;
}

export interface AssistRebounds {
    reboundsOffensive: number;
    reboundsDefensive: number;
    totalRebounds:     number;
    assists:           number;
}

export interface FoulsBallsBlocks {
    foulsCommitted: number;
    steals:         number;
    turnovers:      number;
    blocks:         number;
}

export interface Games {
    gamesPlayed:  number;
    jerseyNumber: number;
    averageScore: number;
    seasonScore:  number;
}

export interface PlayerBio {
    age:          Date;
    country:      string;
    weight:       number;
    height:       number;
    pos:          string;
    startYearNba: number;
    college:      string;
    affiliation:  string;
}

export interface Points {
    totalPoints:  number;
    pointsByGame: number;
}

export interface Shots {
    fieldShotsScored:             number;
    fieldShotsAttempted:          number;
    fieldShotsPercentage:         number;
    freeThrowsScored:             number;
    freeThrowsAttempted:          number;
    freeThrowsPercentage:         number;
    threePointersShotsScored:     number;
    threePointersShotsAttempted:  number;
    threePointersShotsPercentage: number;
}

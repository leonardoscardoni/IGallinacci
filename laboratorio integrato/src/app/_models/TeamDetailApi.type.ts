export interface TeamDetailType {
    idTeam:            number;
    favourite:         boolean;
    name:              string;
    conference:        string;
    division:          string;
    rankConference:    number;
    rankDivision:      number;
    stats:             TeamDetailTypeStats;
    players:           Player[];
    shots:             Shots;
    assistRebounds:    AssistRebounds;
    points:            Points;
    foulsBallsBlocks:  FoulsBallsBlocks;
    winLoss:           WinLoss;
    dataComparisonNba: DataComparisonNba[];
}

export interface AssistRebounds {
    reboundsOffensive: number;
    reboundsDefensive: number;
    totalRebounds:     number;
    assists:           number;
}

export interface DataComparisonNba {
    dataName: string;
    dataTeam: number;
    dataNba:  number;
}

export interface FoulsBallsBlocks {
    foulsCommitted: number;
    steals:         number;
    turnovers:      number;
    blocks:         number;
}

export interface Player {
    ruolo: any;
    firstname: string;
    lastname:  string;
    number:    number | null;
    position:  string;
    stats:     PlayerStats;
}

export interface PlayerStats {
    pointsForGame: number;
    assist:        number;
    rebounds:      number;
    steals:        number;
    blocks:        number;
}

export interface Points {
    totalPoints:          number;
    pointsPerGame:        number;
    pointsAllowedPerGame: number;
}

export interface Shots {
    fieldGoalsMade:          number;
    fieldGoalsAttempted:     number;
    fieldGoalsPercentage:    number;
    freeTrowMade:            number;
    freeTrowAttempted:       number;
    freeTrowPercentage:      number;
    threePointersMade:       number;
    threePointersAttempted:  number;
    threePointersPercentage: number;
}

export interface TeamDetailTypeStats {
    gamePlayed:                  number;
    points:                      number;
    freeTrowMadePercentage:      number;
    threePointersMadePercentage: number;
}

export interface WinLoss {
    victoriesAtHome: number;
    defeatsAtHome:   number;
}

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Dic 21, 2023 alle 17:28
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `nbastat`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `arena`
--

CREATE TABLE `arena` (
  `nameArena` varchar(255) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `arena`
--

INSERT INTO `arena` (`nameArena`, `city`, `state`, `country`) VALUES
('Ball Arena', 'Denver', 'CO', NULL),
('Chase Center', 'San Francisco', 'CA', NULL),
('crypto.com Arena', 'Los Angeles', 'CA', NULL),
('Delta Center', 'Salt Lake City', 'UT', NULL),
('Gainbridge Fieldhouse', 'Indianapolis', 'IN', NULL),
('Golden 1 Center', 'Sacramento', 'CA', NULL),
('Kaseya Center', 'Miami', 'FL', NULL),
('Paycom Center', 'Oklahoma City', 'OK', NULL),
('Rocket Mortgage FieldHouse', 'Cleveland', 'OH', NULL),
('Scotiabank Arena', 'Toronto', 'ON', NULL),
('State Farm Arena', 'Atlanta', 'GA', NULL),
('Wells Fargo Center', 'Philadelphia', 'PA', NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `game`
--

CREATE TABLE `game` (
  `id` int(11) NOT NULL,
  `season` smallint(5) UNSIGNED NOT NULL,
  `gameDate` date DEFAULT NULL,
  `startTime` time DEFAULT NULL,
  `stage` tinyint(4) DEFAULT NULL,
  `totPeriods` tinyint(4) DEFAULT NULL,
  `nameArena` varchar(255) DEFAULT NULL,
  `id_visitor` int(11) DEFAULT NULL,
  `id_home` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `game`
--

INSERT INTO `game` (`id`, `season`, `gameDate`, `startTime`, `stage`, `totPeriods`, `nameArena`, `id_visitor`, `id_home`) VALUES
(12897, 2023, '2023-12-19', '01:00:00', 2, 4, 'Rocket Mortgage FieldHouse', 14, 7),
(12910, 2023, '2023-12-20', '04:00:00', 2, 4, 'Chase Center', 2, 11);

-- --------------------------------------------------------

--
-- Struttura della tabella `player`
--

CREATE TABLE `player` (
  `id` int(11) NOT NULL,
  `idTeam` int(11) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `startYear` smallint(6) DEFAULT NULL,
  `pro` tinyint(4) DEFAULT NULL,
  `height` float DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `college` varchar(255) DEFAULT NULL,
  `affiliation` varchar(255) DEFAULT NULL,
  `jersey` tinyint(4) DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT NULL,
  `pos` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `statsgame`
--

CREATE TABLE `statsgame` (
  `idTeam` int(11) NOT NULL,
  `idGame` int(11) NOT NULL,
  `win` smallint(5) UNSIGNED DEFAULT NULL,
  `lose` smallint(5) UNSIGNED DEFAULT NULL,
  `seriesWin` tinyint(4) DEFAULT NULL,
  `seriesLose` tinyint(4) DEFAULT NULL,
  `pointsPeriod` varchar(255) DEFAULT NULL,
  `fastBreakPoint` smallint(5) UNSIGNED DEFAULT NULL,
  `pointsInPaint` smallint(5) UNSIGNED DEFAULT NULL,
  `biggestLead` tinyint(4) DEFAULT NULL,
  `secondChancePoints` smallint(5) UNSIGNED DEFAULT NULL,
  `pointsOffTurnovers` smallint(5) UNSIGNED DEFAULT NULL,
  `longestRun` tinyint(4) DEFAULT NULL,
  `points` smallint(5) UNSIGNED DEFAULT NULL,
  `fgm` smallint(5) UNSIGNED DEFAULT NULL,
  `fga` smallint(5) UNSIGNED DEFAULT NULL,
  `fgp` float DEFAULT NULL,
  `ftm` smallint(5) UNSIGNED DEFAULT NULL,
  `fta` smallint(5) UNSIGNED DEFAULT NULL,
  `ftp` float DEFAULT NULL,
  `tpm` smallint(5) UNSIGNED DEFAULT NULL,
  `tpa` smallint(5) UNSIGNED DEFAULT NULL,
  `tpp` float DEFAULT NULL,
  `offReb` smallint(5) UNSIGNED DEFAULT NULL,
  `defReb` smallint(5) UNSIGNED DEFAULT NULL,
  `totReb` smallint(5) UNSIGNED DEFAULT NULL,
  `assists` smallint(5) UNSIGNED DEFAULT NULL,
  `pFouls` smallint(5) UNSIGNED DEFAULT NULL,
  `steals` smallint(5) UNSIGNED DEFAULT NULL,
  `turnovers` smallint(5) UNSIGNED DEFAULT NULL,
  `blocks` smallint(5) UNSIGNED DEFAULT NULL,
  `plusMinus` smallint(6) DEFAULT NULL,
  `min` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `statsgame`
--

INSERT INTO `statsgame` (`idTeam`, `idGame`, `win`, `lose`, `seriesWin`, `seriesLose`, `pointsPeriod`, `fastBreakPoint`, `pointsInPaint`, `biggestLead`, `secondChancePoints`, `pointsOffTurnovers`, `longestRun`, `points`, `fgm`, `fga`, `fgp`, `ftm`, `fta`, `ftp`, `tpm`, `tpa`, `tpp`, `offReb`, `defReb`, `totReb`, `assists`, `pFouls`, `steals`, `turnovers`, `blocks`, `plusMinus`, `min`) VALUES
(2, 12910, 0, 0, 0, 0, '[40, 25, 32, 24, 5]', NULL, NULL, NULL, NULL, NULL, NULL, 126, 47, 114, 85.7, 15, 17, 88.2, 17, 58, 29.3, 18, 37, 55, 28, 13, 6, 8, 5, -6, '240:00'),
(7, 12897, 0, 0, 0, 0, '[33, 24, 42, 23, 13]', NULL, NULL, NULL, NULL, NULL, NULL, 135, 47, 98, 48, 22, 34, 64.7, 19, 48, 39.6, 15, 24, 39, 29, 25, 7, 12, 8, 5, '240:00'),
(11, 12910, 0, 0, 0, 0, '[30, 32, 24, 35, 11]', NULL, NULL, NULL, NULL, NULL, NULL, 132, 50, 109, 45.9, 12, 14, 85.7, 20, 50, 40, 18, 41, 59, 29, 15, 4, 10, 5, 6, '240:00'),
(14, 12897, 0, 0, 0, 0, '[34, 25, 39, 24, 8]', NULL, NULL, NULL, NULL, NULL, NULL, 130, 47, 102, 64.7, 24, 27, 88.9, 12, 33, 36.4, 15, 32, 47, 34, 32, 9, 14, 5, -5, '240:00');

-- --------------------------------------------------------

--
-- Struttura della tabella `statsplayer`
--

CREATE TABLE `statsplayer` (
  `idPlayer` int(11) NOT NULL,
  `idTeam` int(11) NOT NULL,
  `idGame` int(11) NOT NULL,
  `points` tinyint(4) DEFAULT NULL,
  `pos` varchar(2) DEFAULT NULL,
  `min` float DEFAULT NULL,
  `fgm` smallint(5) UNSIGNED DEFAULT NULL,
  `fga` smallint(5) UNSIGNED DEFAULT NULL,
  `fgp` float DEFAULT NULL,
  `ftm` smallint(5) UNSIGNED DEFAULT NULL,
  `fta` smallint(5) UNSIGNED DEFAULT NULL,
  `ftp` float DEFAULT NULL,
  `tpm` smallint(5) UNSIGNED DEFAULT NULL,
  `tpa` smallint(5) UNSIGNED DEFAULT NULL,
  `tpp` float DEFAULT NULL,
  `offReb` smallint(5) UNSIGNED DEFAULT NULL,
  `defReb` smallint(5) UNSIGNED DEFAULT NULL,
  `totReb` smallint(5) UNSIGNED DEFAULT NULL,
  `assists` smallint(5) UNSIGNED DEFAULT NULL,
  `pFouls` smallint(5) UNSIGNED DEFAULT NULL,
  `steals` smallint(5) UNSIGNED DEFAULT NULL,
  `turnovers` smallint(5) UNSIGNED DEFAULT NULL,
  `blocks` smallint(5) UNSIGNED DEFAULT NULL,
  `plusMinus` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `statsteam`
--

CREATE TABLE `statsteam` (
  `idTeam` int(11) NOT NULL,
  `season` smallint(5) UNSIGNED NOT NULL,
  `games` smallint(5) UNSIGNED DEFAULT NULL,
  `fastBreakPoints` smallint(5) UNSIGNED DEFAULT NULL,
  `pointsInPaint` smallint(5) UNSIGNED DEFAULT NULL,
  `biggestLead` smallint(5) UNSIGNED DEFAULT NULL,
  `secondChancePoints` smallint(5) UNSIGNED DEFAULT NULL,
  `pointsOffTurnovers` smallint(5) UNSIGNED DEFAULT NULL,
  `longestRun` smallint(5) UNSIGNED DEFAULT NULL,
  `points` smallint(5) UNSIGNED DEFAULT NULL,
  `fgm` smallint(5) UNSIGNED DEFAULT NULL,
  `fga` smallint(5) UNSIGNED DEFAULT NULL,
  `fgp` float DEFAULT NULL,
  `ftm` smallint(5) UNSIGNED DEFAULT NULL,
  `fta` smallint(5) UNSIGNED DEFAULT NULL,
  `ftp` float DEFAULT NULL,
  `tpm` smallint(5) UNSIGNED DEFAULT NULL,
  `tpa` smallint(5) UNSIGNED DEFAULT NULL,
  `tpp` float DEFAULT NULL,
  `offReb` smallint(5) UNSIGNED DEFAULT NULL,
  `defReb` smallint(5) UNSIGNED DEFAULT NULL,
  `totReb` smallint(5) UNSIGNED DEFAULT NULL,
  `assists` smallint(5) UNSIGNED DEFAULT NULL,
  `pFouls` smallint(5) UNSIGNED DEFAULT NULL,
  `steals` smallint(5) UNSIGNED DEFAULT NULL,
  `turnovers` smallint(5) UNSIGNED DEFAULT NULL,
  `blocks` smallint(5) UNSIGNED DEFAULT NULL,
  `plusMinus` smallint(6) DEFAULT NULL,
  `rankConference` smallint(5) DEFAULT NULL,
  `winConference` smallint(5) DEFAULT NULL,
  `lossConference` smallint(5) DEFAULT NULL,
  `rankDivision` smallint(5) DEFAULT NULL,
  `winDivision` smallint(5) DEFAULT NULL,
  `lossDivision` smallint(5) DEFAULT NULL,
  `winHome` smallint(5) DEFAULT NULL,
  `winAway` smallint(5) DEFAULT NULL,
  `winPerc` float DEFAULT NULL,
  `lossHome` smallint(5) DEFAULT NULL,
  `lossAway` smallint(5) DEFAULT NULL,
  `lossPerc` float DEFAULT NULL,
  `gamesBehind` smallint(5) DEFAULT NULL,
  `streak` smallint(5) DEFAULT NULL,
  `winStreak` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `team`
--

CREATE TABLE `team` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `code` varchar(3) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `allstar` tinyint(1) DEFAULT NULL,
  `conference` varchar(255) DEFAULT NULL,
  `division` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `team`
--

INSERT INTO `team` (`id`, `name`, `nickname`, `code`, `city`, `logo`, `allstar`, `conference`, `division`) VALUES
(2, 'Boston Celtics', 'Celtics', 'BOS', 'Boston', 'https://upload.wikimedia.org/wikipedia/fr/thumb/6/65/Celtics_de_Boston_logo.svg/1024px-Celtics_de_Boston_logo.svg.png', 0, 'East', 'Atlantic'),
(6, 'Chicago Bulls', 'Bulls', NULL, 'CHI', 'https://upload.wikimedia.org/wikipedia/fr/thumb/d/d1/Bulls_de_Chicago_logo.svg/1200px-Bulls_de_Chicago_logo.svg.png', 0, 'East', 'Central'),
(7, 'Cleveland Cavaliers', 'Cavaliers', NULL, 'CLE', 'https://upload.wikimedia.org/wikipedia/fr/thumb/0/06/Cavs_de_Cleveland_logo_2017.png/150px-Cavs_de_Cleveland_logo_2017.png', 0, 'East', 'Central'),
(11, 'Golden State Warriors', 'Warriors', 'GSW', 'Golden State', 'https://upload.wikimedia.org/wikipedia/fr/thumb/d/de/Warriors_de_Golden_State_logo.svg/1200px-Warriors_de_Golden_State_logo.svg.png', 0, 'West', 'Pacific'),
(14, 'Houston Rockets', 'Rockets', NULL, 'HOU', 'https://upload.wikimedia.org/wikipedia/fr/thumb/d/de/Houston_Rockets_logo_2003.png/330px-Houston_Rockets_logo_2003.png', 0, 'West', 'Southwest'),
(15, 'Indiana Pacers', 'Pacers', NULL, 'IND', 'https://upload.wikimedia.org/wikipedia/fr/thumb/c/cf/Pacers_de_l%27Indiana_logo.svg/1180px-Pacers_de_l%27Indiana_logo.svg.png', 0, 'East', 'Central'),
(16, 'LA Clippers', 'Clippers', NULL, 'LAC', 'https://upload.wikimedia.org/wikipedia/fr/d/d6/Los_Angeles_Clippers_logo_2010.png', 0, 'West', 'Pacific'),
(27, 'Philadelphia 76ers', '76ers', NULL, 'PHI', 'https://upload.wikimedia.org/wikipedia/fr/4/48/76ers_2016.png', 0, 'East', 'Atlantic');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `arena`
--
ALTER TABLE `arena`
  ADD PRIMARY KEY (`nameArena`);

--
-- Indici per le tabelle `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_arena` (`nameArena`),
  ADD KEY `fk_home_team` (`id_home`),
  ADD KEY `fk_visitor_team` (`id_visitor`);

--
-- Indici per le tabelle `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_player_team` (`idTeam`);

--
-- Indici per le tabelle `statsgame`
--
ALTER TABLE `statsgame`
  ADD PRIMARY KEY (`idTeam`,`idGame`),
  ADD KEY `fk_statGame_game` (`idGame`),
  ADD KEY `fk_statGame_team` (`idTeam`);

--
-- Indici per le tabelle `statsplayer`
--
ALTER TABLE `statsplayer`
  ADD PRIMARY KEY (`idPlayer`,`idTeam`,`idGame`),
  ADD KEY `fk_statsPlayer_team` (`idTeam`),
  ADD KEY `fk_statsPlayer_game` (`idGame`);

--
-- Indici per le tabelle `statsteam`
--
ALTER TABLE `statsteam`
  ADD PRIMARY KEY (`idTeam`,`season`),
  ADD KEY `fk_statsTeam_team` (`idTeam`);

--
-- Indici per le tabelle `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`id`);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `game`
--
ALTER TABLE `game`
  ADD CONSTRAINT `fk_arena` FOREIGN KEY (`nameArena`) REFERENCES `arena` (`nameArena`),
  ADD CONSTRAINT `fk_home_team` FOREIGN KEY (`id_home`) REFERENCES `team` (`id`),
  ADD CONSTRAINT `fk_visitor_team` FOREIGN KEY (`id_visitor`) REFERENCES `team` (`id`);

--
-- Limiti per la tabella `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `fk_player_team` FOREIGN KEY (`idTeam`) REFERENCES `team` (`id`);

--
-- Limiti per la tabella `statsgame`
--
ALTER TABLE `statsgame`
  ADD CONSTRAINT `fk_statGame_game` FOREIGN KEY (`idGame`) REFERENCES `game` (`id`),
  ADD CONSTRAINT `fk_statGame_team` FOREIGN KEY (`idTeam`) REFERENCES `team` (`id`);

--
-- Limiti per la tabella `statsplayer`
--
ALTER TABLE `statsplayer`
  ADD CONSTRAINT `fk_statsPlayer_game` FOREIGN KEY (`idGame`) REFERENCES `game` (`id`),
  ADD CONSTRAINT `fk_statsPlayer_player` FOREIGN KEY (`idPlayer`) REFERENCES `player` (`id`),
  ADD CONSTRAINT `fk_statsPlayer_team` FOREIGN KEY (`idTeam`) REFERENCES `team` (`id`);

--
-- Limiti per la tabella `statsteam`
--
ALTER TABLE `statsteam`
  ADD CONSTRAINT `fk_statsTeam_team` FOREIGN KEY (`idTeam`) REFERENCES `team` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

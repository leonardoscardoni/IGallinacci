-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Dic 14, 2023 alle 10:45
-- Versione del server: 10.4.28-MariaDB
-- Versione PHP: 8.2.4 
DROP DATABASE IF EXISTS `nbastat`;

CREATE DATABASE IF NOT EXISTS `nbastat` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

use nbastat;

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
  `name` varchar(255) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `game`
--

CREATE TABLE `game` (
  `id` int(11) NOT NULL,
  `season` smallint(5) UNSIGNED NOT NULL,
  `date` date DEFAULT NULL,
  `time` time DEFAULT NULL,
  `stage` tinyint(4) DEFAULT NULL,
  `totPeriods` tinyint(4) DEFAULT NULL,
  `nameArena` varchar(255) DEFAULT NULL,
  `idVisitor` int(11) DEFAULT NULL,
  `idHome` int(11) DEFAULT NULL
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

-- --------------------------------------------------------

--
-- Struttura della tabella `player`
--

CREATE TABLE `player` (
  `id` int(11) NOT NULL,
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
-- Struttura della tabella `playerteam`
--

CREATE TABLE `playerteam` (
  `idPlayer` int(11) NOT NULL,
  `idTeam` int(11) NOT NULL,
  `season` smallint(5) UNSIGNED NOT NULL
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
-- Indici per le tabelle
--

--
-- Indici per le tabelle `arena`
--
ALTER TABLE `arena`
  ADD PRIMARY KEY (`name`);

--
-- Indici per le tabelle `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_arena` (`nameArena`),
  ADD KEY `fk_home_team` (`idHome`),
  ADD KEY `fk_visitor_team` (`idVisitor`);

--
-- Indici per le tabelle `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `playerteam`
--
ALTER TABLE `playerteam`
  ADD PRIMARY KEY (`idPlayer`,`idTeam`,`season`),
  ADD KEY `fk_playerteam_player` (`idPlayer`),
  ADD KEY `fk_playerteam_team` (`idTeam`);

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
-- Limiti per le tabelle
--

--
-- Limiti per la tabella `game`
--
ALTER TABLE `game`
  ADD CONSTRAINT `fk_arena` FOREIGN KEY (`nameArena`) REFERENCES `arena` (`name`),
  ADD CONSTRAINT `fk_home_team` FOREIGN KEY (`idHome`) REFERENCES `team` (`id`),
  ADD CONSTRAINT `fk_visitor_team` FOREIGN KEY (`idVisitor`) REFERENCES `team` (`id`);

--
-- Limiti per la tabella `playerteam`
--
ALTER TABLE `playerteam`
  ADD CONSTRAINT `fk_playerteam_player` FOREIGN KEY (`idPlayer`) REFERENCES `player` (`id`),
  ADD CONSTRAINT `fk_playerteam_team` FOREIGN KEY (`idTeam`) REFERENCES `team` (`id`);

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


CREATE USER IF NOT EXISTS 'backend-lastgame'@'localhost' IDENTIFIED BY '5lE;R230LO_%*v{(3+ECbd:';
GRANT SELECT, INSERT, UPDATE, DELETE ON nbastat.* TO 'backend-lastgame'@'localhost';
FLUSH PRIVILEGES;


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

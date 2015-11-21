-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Sam 21 Novembre 2015 à 10:23
-- Version du serveur :  10.1.8-MariaDB-log
-- Version de PHP :  5.6.15-pl3-gentoo

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `GestionCabinet`
--

-- --------------------------------------------------------

--
-- Structure de la table `consultations`
--

CREATE TABLE `consultations` (
  `id` int(11) NOT NULL,
  `datedebut` datetime DEFAULT NULL,
  `datefin` datetime DEFAULT NULL,
  `compterendu` varchar(255) DEFAULT NULL,
  `patient` int(11) NOT NULL,
  `medecin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `consultations`
--

INSERT INTO `consultations` (`id`, `datedebut`, `datefin`, `compterendu`, `patient`, `medecin`) VALUES
(1, '2015-11-09 10:00:00', '2015-11-09 10:30:00', 'RAS', 1, 6);

-- --------------------------------------------------------

--
-- Structure de la table `interactions`
--

CREATE TABLE `interactions` (
  `id` int(11) NOT NULL,
  `severite` varchar(255) DEFAULT NULL,
  `risques` varchar(255) DEFAULT NULL,
  `precautions` varchar(255) DEFAULT NULL,
  `produita` int(11) DEFAULT NULL,
  `produitb` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `interactions`
--

INSERT INTO `interactions` (`id`, `severite`, `risques`, `precautions`, `produita`, `produitb`) VALUES
(1, 'aucune', 'aucun', 'aucune', 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `personnes`
--

CREATE TABLE `personnes` (
  `id` int(11) NOT NULL,
  `nom` varchar(32) NOT NULL,
  `prenom` varchar(32) NOT NULL,
  `compte` varchar(32) DEFAULT NULL,
  `motdepasse` varchar(128) DEFAULT NULL,
  `sexe` varchar(8) DEFAULT NULL,
  `dateNaissance` datetime DEFAULT NULL,
  `rpps` varchar(128) DEFAULT NULL,
  `type` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `personnes`
--

INSERT INTO `personnes` (`id`, `nom`, `prenom`, `compte`, `motdepasse`, `sexe`, `dateNaissance`, `rpps`, `type`) VALUES
(1, 'Greene', 'Mark', NULL, NULL, 'H', '1970-01-01 00:00:00', NULL, 'patient'),
(2, 'Douglas', 'Ross', NULL, NULL, 'H', '1970-01-02 00:00:00', NULL, 'patient'),
(3, 'Carter', 'John', NULL, NULL, 'H', '1970-01-03 00:00:00', NULL, 'patient'),
(4, 'Weaver', 'Kerry', NULL, NULL, 'F', '1970-01-04 00:00:00', NULL, 'patient'),
(5, 'Corday', 'Elizabeth', NULL, NULL, 'F', '1970-01-05 00:00:00', NULL, 'patient'),
(6, 'Kovač', 'Luka', 'lkovac', 'mdpkovac', NULL, NULL, 'ABCDEF', 'medecin'),
(7, 'Benton', 'Peter', 'pbenton', 'mdpbenton', NULL, NULL, 'ZYXWVU', 'medecin');

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

CREATE TABLE `produits` (
  `id` int(11) NOT NULL,
  `cis` varchar(255) NOT NULL,
  `nom` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `produits`
--

INSERT INTO `produits` (`id`, `cis`, `nom`) VALUES
(1, '763575', 'Doliprane'),
(2, '124756', 'Efferalgan'),
(3, '678475', 'Ludélagé'),
(4, '231467', 'Titanoréine');

-- --------------------------------------------------------

--
-- Structure de la table `traitements`
--

CREATE TABLE `traitements` (
  `id` int(11) NOT NULL,
  `posologie` varchar(255) NOT NULL,
  `consultation` int(11) NOT NULL,
  `produit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `traitements`
--

INSERT INTO `traitements` (`id`, `posologie`, `consultation`, `produit`) VALUES
(1, '1 cachet tous les soirs', 1, 1),
(2, '1 cachet tous les matins et tous les soirs', 1, 2);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `consultations`
--
ALTER TABLE `consultations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_consultation_patient_idx` (`patient`),
  ADD KEY `fk_consultation_medecin_idx` (`medecin`);

--
-- Index pour la table `interactions`
--
ALTER TABLE `interactions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_interaction_produit_a_idx` (`produita`),
  ADD KEY `fk_interaction_produit_b_idx` (`produitb`);

--
-- Index pour la table `personnes`
--
ALTER TABLE `personnes`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produits`
--
ALTER TABLE `produits`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `traitements`
--
ALTER TABLE `traitements`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_traitement_produit_idx` (`produit`),
  ADD KEY `fk_traitement_consultation_idx` (`consultation`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `consultations`
--
ALTER TABLE `consultations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `interactions`
--
ALTER TABLE `interactions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `personnes`
--
ALTER TABLE `personnes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `produits`
--
ALTER TABLE `produits`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `traitements`
--
ALTER TABLE `traitements`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `consultations`
--
ALTER TABLE `consultations`
  ADD CONSTRAINT `fk_consultation_medecin` FOREIGN KEY (`medecin`) REFERENCES `personnes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_consultation_patient` FOREIGN KEY (`patient`) REFERENCES `personnes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `interactions`
--
ALTER TABLE `interactions`
  ADD CONSTRAINT `fk_interaction_produit_a` FOREIGN KEY (`produita`) REFERENCES `produits` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_interaction_produit_b` FOREIGN KEY (`produitb`) REFERENCES `produits` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `traitements`
--
ALTER TABLE `traitements`
  ADD CONSTRAINT `fk_traitement_consultation` FOREIGN KEY (`consultation`) REFERENCES `consultations` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_traitement_produit` FOREIGN KEY (`produit`) REFERENCES `produits` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

drop database if exists championnat;
create database championnat;
use championnat;

create table pays (
   idpays               int not null auto_increment,
   nom                  varchar(30) not null,
   constraint pk_pays primary key (idpays)
);

create table personne (
   idpersonne           int not null auto_increment,
   numero_licence        char(8) not null,
   date_licence          date not null,
   nom                  varchar(30) not null,
   prenom               varchar(50),
   photo                varchar(100) not null,
   date_naissance        date not null,
   idpays_naissance               int not null,
   constraint pk_personne primary key (idpersonne),
   constraint fk_personne_pays foreign key (idpays_naissance) references pays (idpays)
   
);

create table nationalites (
   idpays               int not null,
   idpersonne           int not null,
   constraint pk_nationalites primary key (idpays, idpersonne),
   constraint fk_nationalites_pays foreign key (idpays) references pays (idpays),
   constraint fk_nationalites_joueur foreign key (idpersonne) references personne (idpersonne)
);

create table joueur (
   idjoueur           int not null,
   constraint pk_joueur primary key (idjoueur),
   constraint fk_joueur_personne foreign key (idjoueur) references personne (idpersonne)
);

create table entraineur (
   identraineur           int not null,
   constraint pk_entraineur primary key (identraineur),
   constraint fk_entraineur_personne foreign key (identraineur) references personne (idpersonne)
);

create table ville (
   idville              int not null auto_increment,
   idpays               int not null,
   nom                  varchar(30) not null,
   constraint pk_ville primary key (idville),
   constraint fk_ville_pays foreign key (idpays) references pays (idpays)
);

create table stade (
   idstade              int not null auto_increment,
   idville              int not null,
   nom                  varchar(30) not null,
   capacite             int,
   constraint pk_stade primary key (idstade),
   constraint fk_stade_ville foreign key (idville) references ville (idville)
);

create table equipe (
   idequipe             int not null auto_increment,
   nom                  varchar(30) not null,
   couleur_domicile1    int not null default 0,
   couleur_domicile2    int not null default 0,
   couleur_exterieure1  int not null default 0,
   couleur_exterieure2  int not null default 0,
   idstade              int not null,
   constraint pk_equipe primary key (idequipe),
   constraint fk_equipe_stade foreign key (idstade) references stade (idstade)
);

create table saison (
   idsaison             int not null,
   datedebut            date not null,
   datefin              date not null,
   constraint pk_saison primary key (idsaison)
);

create table competir (
   idsaison             int not null,
   idequipe             int not null,
   constraint competir primary key (idsaison, idequipe),
   constraint fk_competir_saison foreign key (idsaison) references saison (idsaison),
   constraint fk_competir_equipe foreign key (idequipe) references equipe (idequipe)
);

create table contrat (
   idcontrat            int not null auto_increment,
   idequipe             int not null,
   idpersonne           int not null,
   datesignature        date not null,
   constraint pk_contrat primary key (idcontrat),
   constraint fk_contrat_equipe foreign key (idequipe) references equipe (idequipe),
   constraint fk_contrat_personne foreign key (idpersonne) references personne (idpersonne)
);

create table contrat_saison (
   idcontrat            int not null,
   idsaison             int not null,
   numeromaillot        smallint comment 'pour les entraineurs, le numéro de maillot sera à null',
   constraint pk_contrat_saison primary key (idcontrat, idsaison),
   constraint fk_contrat foreign key (idcontrat) references contrat (idcontrat),
   constraint fk_contrat_saison foreign key (idsaison) references saison (idsaison)
);

create table journee (
   idjournee            smallint not null,
   idsaison             int not null,
   constraint pk_journee primary key (idjournee, idsaison),
   constraint fk_journee_saison foreign key (idsaison) references saison (idsaison)
);

create table `match` (
   idmatch              int not null auto_increment,
   idjournee            smallint not null,
   idsaison             int not null,
   idequipe_domicile    int not null,
   idequipe_exterieur   int not null,
   datematch            date not null,
   heuredebut           time not null,
   duree                bigint,
   nbbuts_eqdomicile    smallint unsigned,
   nbbuts_eqexterieur   smallint unsigned,
   constraint pk_match primary key (idmatch),
   constraint fk_match_journee foreign key (idjournee, idsaison) references journee (idjournee, idsaison),
   constraint fk_match_eq_dom foreign key (idequipe_domicile) references equipe (idequipe),
   constraint fk_match_eq_ext foreign key (idequipe_exterieur) references equipe (idequipe)
);

create table feuilledematch (
   idfeuille            int not null auto_increment,
   idmatch              int not null,
   idjoueur_entrant     int not null,
   idpersonne_sortant   int default null,
   `minute`             int default null comment 'minute entrée de jeu',
   poste                enum('attaque', 'milieu', 'defense', 'gardien', 'banc') not null default 'banc',
   constraint pk_feuille primary key (idfeuille),
   constraint fk_feuille_match foreign key (idmatch) references `match` (idmatch),
   constraint fk_feuille_entrant foreign key (idjoueur_entrant) references joueur (idjoueur),
   constraint fk_feuille_sortant foreign key (idpersonne_sortant) references joueur (idjoueur)
);

create table carton (
   `minute`             smallint unsigned not null,
   idfeuille            int not null,
   couleur              enum('jaune', 'rouge') not null,
   constraint pk_carton primary key (`minute`, idfeuille),
   constraint fk_carton_feuille foreign key (idfeuille) references feuilledematch (idfeuille)
);

create table but (
   `minute`             smallint unsigned not null,
   idfeuille            int not null,
   autogoal             boolean default false not null comment 'marquer contre son camp',
   constraint pk_but primary key (`minute`, idfeuille),
   constraint fk_but_feuille foreign key (idfeuille) references feuilledematch (idfeuille)
);

CREATE VIEW appartenir_equipe AS
SELECT idPersonne AS idJoueur, idEquipe, idSaison 
FROM contrat NATURAL JOIN contrat_saison;

CREATE VIEW listes_convocation AS 
SELECT idJoueur , idMatch, idEquipe FROM (feuilledematch NATURAL JOIN `match` M) JOIN appartenir_equipe A ON (idJoueur_entrant = idJoueur AND M.idSaison = A.idSaison);

-- Modification du délimiter de fin d'instruction
delimiter $

CREATE TRIGGER ins_but BEFORE INSERT ON But
FOR EACH ROW
	BEGIN
		DECLARE minuteDentreeEnJeu INT;
		SELECT IFNULL(`minute`, -1) INTO minuteDentreeEnJeu FROM feuilledematch WHERE idfeuille = NEW.idfeuille;
		
		IF(minuteDentreeEnJeu = -1 OR minuteDentreeEnJeu > NEW.`minute`)THEN
			SIGNAL SQLSTATE '04040' 
						SET MESSAGE_TEXT = 'Le joueur n\'est pas encore entré en jeu.', MYSQL_ERRNO = 4040, TABLE_NAME = 'but', CONSTRAINT_NAME = 'But fantôme';
		END IF;
	END$

delimiter ;

INSERT INTO pays (idpays, nom) VALUES (1, 'Sénégal'), (2, 'Mali'), (3, 'Gambie'), (4, 'Mauritanie'), (5, 'Guinée Bissau'), (6, 'Guinée Conakry');

INSERT INTO ville (idville, idpays, nom) VALUES (1, 1, 'Dakar'), (2, 1, 'Pikine'), (3, 1, 'Guédiawaye'), (4, 1, 'Thiès'), (5, 1, 'Louga'), (6, 1, 'Saint-Louis'), (7, 1, 'Kaolack'), (8, 1, 'Ziguinchor'), (9, 1, 'Mbour');

INSERT INTO stade (idstade, idville, nom, capacite) VALUES (1, 1, 'Léopold Sédar Senghor', 60000), (2, 1, 'Demba Diop', 15000), (3, 2, 'Alassane Djigo', 4000), (4, 3, 'Amadou Barry', 4000), (5, 4, 'Lat Dior', 1500), (6, 5, 'Alboury Ndiaye', 15000), (7, 6, 'Mawade Wade', 1500), (8, 7, 'Lamine Gueye', 1000), (9, 8, 'Aline Sitoe Diatta', 10000), (10, 9, 'Caroline Faye', 5000);

INSERT INTO equipe (idequipe, nom, couleur_domicile1, couleur_domicile2, couleur_exterieure1, couleur_exterieure2, idstade) VALUES (1, 'Génération Foot', 0, 0, 255100, 255, 10), (2, 'Olympique de Ngor', 124056, 0, 0, 156110, 1), (3, 'FC Guédiawaye', 0, 129080, 0, 11000, 4);
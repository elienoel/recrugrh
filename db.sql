/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  20/07/2022 14:03:17                      */
/*==============================================================*/


drop table if exists CANDIDAT;

drop table if exists COMPETENCE;

drop table if exists DIPLOME;

drop table if exists DIPLOMER;

drop table if exists ECOLE;

drop table if exists EXP_PROF;

drop table if exists OFFRE;

drop table if exists POSTULER;

/*==============================================================*/
/* Table : CANDIDAT                                             */
/*==============================================================*/
create table CANDIDAT
(
   NUMCANDIDAT          varchar(15) not null,
   DATEPOST             date,
   NOMCANDIDAT          varchar(15),
   PRENOMCANDIDAT       varchar(30),
   DATENAISS            date,
   CONTACTS             varchar(30),
   NOTE                 int,
   primary key (NUMCANDIDAT)
);

/*==============================================================*/
/* Table : COMPETENCE                                           */
/*==============================================================*/
create table COMPETENCE
(
   IDCOMPETENCE         int not null,
   NUMCANDIDAT          varchar(15) not null,
   DOMAINE              varchar(30),
   NIVEAU               varchar(30),
   primary key (IDCOMPETENCE)
);

/*==============================================================*/
/* Table : DIPLOME                                              */
/*==============================================================*/
create table DIPLOME
(
   CODEDIPLOME          int not null,
   INTITULE             varchar(30),
   primary key (CODEDIPLOME)
);

/*==============================================================*/
/* Table : DIPLOMER                                             */
/*==============================================================*/
create table DIPLOMER
(
   CODEDIPLOME          int not null,
   NUMCANDIDAT          varchar(15) not null,
   NUMECOLE             int not null,
   ANNEE_OPT            date,
   MENTION              text,
   primary key (CODEDIPLOME, NUMCANDIDAT, NUMECOLE)
);

/*==============================================================*/
/* Table : ECOLE                                                */
/*==============================================================*/
create table ECOLE
(
   NUMECOLE             int not null,
   SIGLE                varchar(30),
   NOMCOMPLET           varchar(30),
   TYPEECOLE            varchar(30),
   PAYS                 varchar(30),
   primary key (NUMECOLE)
);

/*==============================================================*/
/* Table : EXP_PROF                                             */
/*==============================================================*/
create table EXP_PROF
(
   IDEXP                int not null,
   NUMCANDIDAT          varchar(15) not null,
   DOMAINE              varchar(30),
   PERIODE              varchar(30),
   RECOMMANDATION       text,
   primary key (IDEXP)
);

/*==============================================================*/
/* Table : OFFRE                                                */
/*==============================================================*/
create table OFFRE
(
   IDOFFRE              int not null,
   TITRE                varchar(50),
   DESCRIPTION          text,
   primary key (IDOFFRE)
);

/*==============================================================*/
/* Table : POSTULER                                             */
/*==============================================================*/
create table POSTULER
(
   IDOFFRE              int not null,
   NUMCANDIDAT          varchar(15) not null,
   LETTREMOTIV          text,
   primary key (IDOFFRE, NUMCANDIDAT)
);

alter table COMPETENCE add constraint FK_AVOIR foreign key (NUMCANDIDAT)
      references CANDIDAT (NUMCANDIDAT) on delete restrict on update restrict;

alter table DIPLOMER add constraint FK_DIPLOMER foreign key (CODEDIPLOME)
      references DIPLOME (CODEDIPLOME) on delete restrict on update restrict;

alter table DIPLOMER add constraint FK_DIPLOMER2 foreign key (NUMCANDIDAT)
      references CANDIDAT (NUMCANDIDAT) on delete restrict on update restrict;

alter table DIPLOMER add constraint FK_DIPLOMER3 foreign key (NUMECOLE)
      references ECOLE (NUMECOLE) on delete restrict on update restrict;

alter table EXP_PROF add constraint FK_POSSEDER foreign key (NUMCANDIDAT)
      references CANDIDAT (NUMCANDIDAT) on delete restrict on update restrict;

alter table POSTULER add constraint FK_POSTULER foreign key (IDOFFRE)
      references OFFRE (IDOFFRE) on delete restrict on update restrict;

alter table POSTULER add constraint FK_POSTULER2 foreign key (NUMCANDIDAT)
      references CANDIDAT (NUMCANDIDAT) on delete restrict on update restrict;


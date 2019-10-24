create table ACTIONS
(
    ID           INTEGER  auto_increment,
    SOURCEIP     VARCHAR(50),
    DESTIP       VARCHAR(50),
    SOURCEPORT   INTEGER,
    DESTPORT     INTEGER,
    PROTOCOL     VARCHAR(20),
    PACKAGESIZE  DOUBLE,
    GMTTIMESTAMP BIGINT,
    CLS          VARCHAR(20),
    constraint ACTIONS_PK
        primary key (ID)
);
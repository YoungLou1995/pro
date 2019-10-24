create table URLSPREDICT
(
    ID      INTEGER auto_increment,
    URL     VARCHAR(200),
    CLS     INTEGER,
    APPNAME VARCHAR(100),
    constraint URLSPREDICT_PK
        primary key (ID)
);
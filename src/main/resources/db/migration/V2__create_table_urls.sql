create table URLS
(
    ID      INTEGER auto_increment,
    URL     VARCHAR(200),
    APPNAME VARCHAR(50),
    CLS     BOOLEAN default FALSE,
    constraint URLS_PK
        primary key (ID)
);

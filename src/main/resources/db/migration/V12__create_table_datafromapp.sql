create table dataFromApp
(
	id int auto_increment,
	srcIP varchar(100),
	destIP varchar(100),
	srcPort int,
	destPort int,
	uid int,
	Length int,
	hasUrl boolean,
	url varchar(500),
	urlMethod varchar(10),
	timeStamp bigint,
	constraint dataFromApp_pk
		primary key (id)
);


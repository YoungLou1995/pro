create table Url2app
(
	id int auto_increment,
	url varchar(500),
	urlMethod varchar(10),
	timeStamp bigint,
	property int,
	propertyNum float,
	uid int,
	constraint Url2app_pk
		primary key (id)
);


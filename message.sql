drop table if exists message;
create table message(
	id int not null auto_increment,
	author varchar(255) not null,
	name varchar(255) not null,
	time varchar(255) not null,
	content text not null,
	primary key(id)
);
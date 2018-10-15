# play-java-ebean-start-example
This code was modified with reference to the play-java-start-exmaple
(https://github.com/playframework/play-java-starter-example.git)

## Build with
* [Play Framework](https://www.playframework.com/) - Web Play Framework(2.6.19)
* [SBT](https://www.scala-sbt.org/) - Dependency Management sbt(2.6.19)
* [JAVA](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java SDK (1.8)
* [MYSQL](https://dev.mysql.com/downloads/installer) - mysql(5.1.41)
* [SCALA](https://www.scala-lang.org/) - scala(2.12)
* [EBEAN](http://ebean-orm.github.io) - io.ebean(4.1.3)

## Getting Started
First, you are going to create mysql schema and create table and then insert sample data. below example

### Download Mysql Install

CREATE SCHEMA `playdb` DEFAULT CHARACTER SET utf8 ;

create table users (
    id int unsigned auto_increment not null,
    first_name varchar(32) not null,
    last_name varchar(32) not null,
    date_created timestamp default now(),
    is_admin boolean,
    num_points int,
    primary key (id)
);

insert into users (id, first_name, last_name, date_created, is_admin, num_points) values(1, 'Fred', 'Flinstone', now(),'0', '6000');
insert into users (id, first_name, last_name, date_created, is_admin, num_points) values(2, 'Barney', 'Rubble', now(),'0', '5000');
insert into users (id, first_name, last_name, date_created, is_admin, num_points) values(3, '영진', '김', now(),'0', '10000');

select * from users;

CREATE TABLE Studen(
 id char(5),
 name nvarchar(50) not null,
 age int not null,
 PRIMARY KEY(id)
);
CREATE TABLE Class(
 id char(5),
 class_name nvarchar(50) not null,
 PRIMARY KEY(id)
);
CREATE TABLE DayOff(
 id char(5),
 student_id char(5)NOT NULL FOREIGN KEY(student_id) references Studen(id),
 day_of date not null,
 PRIMARY KEY(id)
);
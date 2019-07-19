DROP TABLE IF EXISTS SKILLS1;
DROP TABLE IF EXISTS MENTORS1;
DROP TABLE IF EXISTS TRAININGS1;

CREATE TABLE SKILLS1 (
  skill_id INT AUTO_INCREMENT  PRIMARY KEY,
  description VARCHAR(250) NOT NULL,
  mentor_id int
);


CREATE TABLE TRAININGS1 (
  training_id INT AUTO_INCREMENT  PRIMARY KEY,
  description VARCHAR(250) NOT NULL,
  mentor_id int
);


CREATE TABLE MENTORS1 (
  mentor_id INT AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  role VARCHAR(250) DEFAULT NULL,
  no_training INT NOT NULL,
  years_of_experience INT NOT NULL,
  fee NUMBER(15,0) DEFAULT NULL
);

alter table SKILLS1 add constraint foreign key (mentor_id) references MENTORS1;
alter table TRAININGS1 add constraint foreign key (mentor_id) references MENTORS1;

INSERT INTO MENTORS1 (mentor_id, user_name, password, first_name, last_name, no_trainings, years_of_experience, fee) VALUES
(123,  'peter@yahoo.com', '', 'Peter', 'Dinklage', 2, 4, 30),
(124,  'johanna@gmail.com','', 'Johanna', 'Monton', 7, 6, 45),
(125,  'arun@yahoo.com','', 'Arun', 'Kumar', 2, 3, 32),
(126,  'tony@yahoo.com','', 'Anthony', 'Marony', 2, 2, 25),
(127,  'frank@yahoo.com','', 'Frank', 'Groener', 5, 4, 35);


INSERT INTO SKILLS1 (skill_id, description, mentor_id) VALUES
  ('1', 'Java', 123),
  ('2', 'Spring', 123),
  ('3', 'SQL', 124),
  ('4', 'Oracle', 124),
  ('5', 'Angular', 125),
  ('6', 'Docker', 125),
  ('7', 'MongoDB', 126),
  ('8', 'Cloud', 126),
  ('9', 'Hibernate', 123),
  ('10', 'C++', 127),
  ('11', 'Java', 127);
  
INSERT INTO TRAININGS1 (training_id, description, mentor_id) VALUES
  ('1', 'JPA Complete Course', 123),
  ('2', 'Full Stak Developer Course', 123),
  ('3', 'Spring Explained', 126),
  ('4', 'Learn Docker By Example', 124),
  ('5', 'Angular From Zero To Hero', 125),
  ('6', 'Java 8 Training', 125);
  

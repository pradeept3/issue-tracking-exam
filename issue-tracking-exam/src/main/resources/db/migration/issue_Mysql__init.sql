CREATE SCHEMA ISSUE_TRACKER;

CREATE TABLE ISSUE_TRACKER.USER (
  id BIGINT NOT NULL AUTO_INCREMENT,
  username varchar(50) not null,
  PRIMARY KEY (id)
);


CREATE TABLE ISSUE_TRACKER.ISSUE (
  id BIGINT AUTO_INCREMENT,
  title varchar(255) not null,
  description varchar(255) not null,
  status varchar(20) not null,
  reporter BIGINT not null,
  assignee BIGINT,
  created DATE NOT NULL,
  completed DATE,
  primary key(id)
);


ALTER TABLE ISSUE_TRACKER.ISSUE
ADD FOREIGN KEY (reporter)
REFERENCES ISSUE_TRACKER.USER(id);


ALTER TABLE ISSUE_TRACKER.ISSUE
ADD FOREIGN KEY (assignee)
REFERENCES ISSUE_TRACKER.USER(id);


INSERT INTO ISSUE_TRACKER.USER (username) VALUES ('j.jones');
INSERT INTO ISSUE_TRACKER.USER (username) VALUES ('h.humble');


INSERT INTO ISSUE_TRACKER.ISSUE (title, description, status, reporter, created)
VALUES (
    'Issue number one',
    'This is issue number one',
    'backlog',
    (select id from ISSUE_TRACKER.USER where USER.username = 'j.jones'),
    '2017-08-01'
);

INSERT INTO ISSUE_TRACKER.ISSUE (title, description, status, reporter, created)
VALUES (
  'Issue number two',
  'This is issue number two',
  'backlog',
  (select id from ISSUE_TRACKER.USER where USER.username = 'h.humble'),
  '2017-08-01'
);

INSERT INTO ISSUE_TRACKER.ISSUE (title, description, status, reporter, assignee, created, completed)
VALUES (
  'Issue number three',
  'This is issue number three',
  'done',
  (select id from ISSUE_TRACKER.USER where USER.username = 'h.humble'),
  (select id from ISSUE_TRACKER.USER where USER.username = 'h.humble'),
  '2017-07-22',
  '2017-08-02'
);

INSERT INTO ISSUE_TRACKER.ISSUE (title, description, status, reporter, assignee, created, completed)
VALUES (
  'Issue number four',
  'This is issue number four',
  'done',
  (select id from ISSUE_TRACKER.USER where USER.username = 'h.humble'),
  (select id from ISSUE_TRACKER.USER where USER.username = 'j.jones'),
  '2017-08-02',
  '2017-08-02'
);

INSERT INTO ISSUE_TRACKER.ISSUE (title, description, status, reporter, assignee, created)
VALUES (
  'Issue number five',
  'This is issue number five',
  'in_progress',
  (select id from ISSUE_TRACKER.USER where USER.username = 'j.jones'),
  (select id from ISSUE_TRACKER.USER where USER.username = 'j.jones'),
  '2017-08-02'
);

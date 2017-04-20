DROP TABLE eventapp.EVENTS;
DROP TABLE eventapp.ev_users;

CREATE TABLE eventapp.EV_USERS(
USER_ID smallint not null auto_increment,
NAME varchar(80),
LAST_NAME varchar(80),
USER_NAME varchar(80),
PASSWORD varchar(80),
EMAIL varchar(80),
TEL  varchar(80),
primary key(user_id));

CREATE INDEX EV_USERS_TEL on EV_USERS(TEL);

CREATE TABLE eventapp.EVENTS(
  EVENT_ID smallint not null auto_increment,
  EVENT_TITLE varchar(80),
  EVENT_DATE DATE,
  EVENT_HRS TIME,
  EVENT_EH  TIME,
  EVENT_PLACE varchar(80),
  EVENT_DESC varchar(255),  
  EVENT_HOSTID smallint,
  primary key(event_id),
  FOREIGN KEY(EVENT_HOSTID)
  REFERENCES EV_USERS(USER_ID) ON DELETE CASCADE  
);
CREATE INDEX events_desc ON EVENTS(EVENT_DESC);
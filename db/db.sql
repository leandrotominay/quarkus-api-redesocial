CREATE TABLE quarkus-social;

CREATE TABLE Users (
	id bigserial NOT NULL PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	age INT NOT NULL
);

CREATE TABLE POSTS (
    id bigserial NOT NULL PRIMARY KEY,
    post_text VARCHAR(150) NOT NULL,
    dateTime timestamp NOT NULL,
    user_id bigint NOT NULL REFERENCES USERS(id)
)

CREATE TABLE FOLLOWERS (
		id bigserial not null primary key,
		user_id bigint not null references USERS(id),
		follower_id bigint not null  references USERS(id)
)


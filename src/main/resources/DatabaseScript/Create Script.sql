
-- Database Creation
DROP DATABASE bad;
CREATE DATABASE bad;


-- Tables Creation

DROP TABLE bad."Game";
CREATE TABLE bad."Game"(
	game_id character varying(30) NOT NULL DEFAULT ('BAD'::text || lpad((nextval('bad."Match_id_seq"'::regclass))::text, 15, '0'::text)),
 	is_active Boolean,
	que_master  character varying(30),
	created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMPTZ);

DROP TABLE bad."Game_Player";
CREATE TABLE bad."Game_Player"(
 	game_id character varying(30) NOT NULL,
	player_id character varying(30) NOT NULL,
	created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
	primary key(game_id, player_id)
)	






DROP TABLE Match;
CREATE TABLE bad."Match"
(
    match_id character varying(30) NOT NULL DEFAULT ('MATCH'::text || lpad((nextval('bad."Match_id_seq"'::regclass))::text, 15, '0'::text)),
    game_id character varying(30),
	court_number character varying(30) COLLATE pg_catalog."default",
	created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMPTZ)

DROP TABLE Set;
CREATE TABLE bad."Set"(
match_id character varying(30), 
player_id character varying(30),
created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMPTZ)

CREATE TABLE bad."Game"(
game_id character varying(30) NOT NULL DEFAULT ('BAD'::text || lpad((nextval('bad."Match_id_seq"'::regclass))::text, 15, '0'::text)),
 is_active Boolean,
	que_master  character varying(30),
created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMPTZ);
	
DROP TABLE bad."Player";
CREATE TABLE bad."Player"(
	player_id character varying(30) NOT NULL DEFAULT ('P'::text || lpad((nextval('bad."Match_id_seq"'::regclass))::text, 15, '0'::text)),
 	alias character varying(30) NOT NULL UNIQUE,
	first_name character varying(30),
	last_name character varying(30),	
	priority_level  character varying(30),
	player_level character varying(30),
	gender character varying(30),
	created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMPTZ);


INSERT INTO bad."Match" (game_id, court_number,created_at,updated_at)
values('GAME23132133',1,'NOW()', 'NOW()')


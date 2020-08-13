drop table if exists oauth_client_details;
create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

drop table if exists oauth_client_token;
create table oauth_client_token (
token_id VARCHAR(255),
token bytea ,
authentication_id VARCHAR(255),
user_name VARCHAR(255),
client_id VARCHAR(255)
);

drop table if exists oauth_access_token;
create table oauth_access_token (
token_id VARCHAR(255),
token bytea,
authentication_id VARCHAR(255),
user_name VARCHAR(255),
client_id VARCHAR(255),
authentication bytea,
refresh_token VARCHAR(255)
);

drop table if exists oauth_refresh_token;
create table oauth_refresh_token (
token_id VARCHAR(255),
token bytea,
authentication bytea
);

drop table if exists oauth_code;
create table oauth_code (
code VARCHAR(255), authentication bytea
);

-- client_secret : secret
INSERT INTO oauth_client_details
   (client_id, client_secret, scope, authorized_grant_types,
   authorities, access_token_validity, refresh_token_validity)
VALUES
   ('test-company', '$2a$10$RUWef9AgJwb88NXmCoYvtudYmXkb6o/6aq65t34Mhxr/VPpO/tIOC', 'read,write', 'password,refresh_token,client_credentials,authorization_code', '', 43200, 2592000);




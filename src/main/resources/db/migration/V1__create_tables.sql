create table category_questions
(
	category_id bigint not null,
	questions_id bigint not null
		constraint uk_p8ds2ofm52rr7hucj8jfu9rkx
			unique,
	constraint category_questions_pkey
		primary key (category_id, questions_id)
)
;

create table question_answers
(
	question_id bigint not null,
	answers_id bigint not null
		constraint uk_4qtn1pf4ea4ougou3ewipk9qx
			unique,
	constraint question_answers_pkey
		primary key (question_id, answers_id)
)
;

create table question_tags
(
	question_id bigint not null,
	tags_id bigint not null,
	constraint question_tags_pkey
		primary key (question_id, tags_id)
)
;

create table question_response_answers
(
	question_response_id bigint not null,
	answers_id bigint not null
		constraint uk_kxlbacguj952sqrlrlasoxw7j
			unique,
	constraint question_response_answers_pkey
		primary key (question_response_id, answers_id)
)
;

create table quiz_responses
(
	quiz_id bigint not null,
	responses_id bigint not null
		constraint uk_5bae7ki8ngah0j45p4t4gj66v
			unique,
	constraint quiz_responses_pkey
		primary key (quiz_id, responses_id)
)
;

create table answer
(
	id bigserial not null
		constraint answer_pkey
			primary key,
	description varchar(255),
	is_correct boolean not null
)
;

create table category
(
	id bigserial not null
		constraint category_pkey
			primary key,
	create_date timestamp,
	is_active boolean not null,
	modify_date timestamp,
	name varchar(255),
	created_by_id bigint,
	modify_by_id bigint
)
;

create table person
(
	id bigserial not null
		constraint person_pkey
			primary key,
	date timestamp,
	is_active boolean not null,
	login varchar(255),
	name varchar(255),
	password varchar(255),
	user_access_id bigint
)
;

alter table category
	add constraint fkdacy1oxt66aviic39fb3tmcm8
		foreign key (created_by_id) references person
;

alter table category
	add constraint fkn3hjmynxskww1xgykrttqnpoj
		foreign key (modify_by_id) references person
;

create table question
(
	id bigserial not null
		constraint question_pkey
			primary key,
	create_date timestamp,
	description varchar(255),
	is_active boolean,
	modify_date timestamp,
	title varchar(255),
	answer1_id bigint
		constraint fkbxq9nr8tcssitbmv68pkcmj92
			references answer,
	answer2_id bigint
		constraint fkoxl98on7aaqf9v35crwvyknk1
			references answer,
	answer3_id bigint
		constraint fk8jkv6lcxroifyusy4ydiy794t
			references answer,
	answer4_id bigint
		constraint fkh41byef6hg3wnk2ctumq1dr1i
			references answer,
	category_id bigint
		constraint fk7jaqbm9p4prg7n91dd1uabrvj
			references category,
	created_by_id bigint
		constraint fko8jpg19f9syrhiboctf8qsa3j
			references person,
	modify_by_id bigint
		constraint fk4dgusm6nsnwhbw44cs5h7wqwy
			references person
)
;

create table question_response
(
	id bigserial not null
		constraint question_response_pkey
			primary key,
	answer varchar(255),
	question_id bigint
		constraint fkiyouge03ev5tbesn70iofwubp
			references question,
	quiz_id bigint
)
;

create table quiz
(
	id bigserial not null
		constraint quiz_pkey
			primary key,
	start_date timestamp,
	create_by_id bigint
		constraint fkd9n4cysm2vmbuyet1gvae1knr
			references person
)
;

alter table question_response
	add constraint fkk1r5o719b3fvfvar27ycmmekl
		foreign key (quiz_id) references quiz
;

create table tag
(
	id bigserial not null
		constraint tag_pkey
			primary key,
	create_date timestamp,
	modify_date timestamp,
	name varchar(255),
	created_by_id bigint
		constraint fkskja41r8c46o1dauki15yh7t3
			references person,
	modify_by_id bigint
		constraint fk380694s8kuc9lge4d783niajh
			references person
)
;

create table tag_questions
(
	tags_id bigint not null
		constraint fkh3g6p31yi3sniivbhi7ty765
			references tag,
	questions_id bigint not null
		constraint fk68tkq6v01licnu7uu7lco5rdm
			references question,
	constraint tag_questions_pkey
		primary key (tags_id, questions_id)
)
;

create table user_access
(
	id bigserial not null
		constraint user_access_pkey
			primary key,
	name varchar(255)
)
;

alter table person
	add constraint fks9rgwabxb42iccib5d78xanqa
		foreign key (user_access_id) references user_access
;


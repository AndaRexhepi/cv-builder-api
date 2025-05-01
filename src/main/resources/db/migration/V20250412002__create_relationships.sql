ALTER TABLE accolades
    ADD resume_id BIGINT;

ALTER TABLE educations
    ADD resume_id BIGINT;

ALTER TABLE experiences
    ADD resume_id BIGINT;

ALTER TABLE objectives
    ADD resume_id BIGINT;

ALTER TABLE profiles
    ADD resume_id BIGINT;

ALTER TABLE pursuits
    ADD resume_id BIGINT;

ALTER TABLE referees
    ADD resume_id BIGINT;

ALTER TABLE skills
    ADD resume_id BIGINT;

ALTER TABLE users
    ADD resume_id BIGINT;

ALTER TABLE objectives
    ADD CONSTRAINT uc_objectives_resume UNIQUE (resume_id);

ALTER TABLE profiles
    ADD CONSTRAINT uc_profiles_resume UNIQUE (resume_id);

ALTER TABLE users
    ADD CONSTRAINT uc_users_resume UNIQUE (resume_id);

ALTER TABLE accolades
    ADD CONSTRAINT FK_ACCOLADES_ON_RESUME FOREIGN KEY (resume_id) REFERENCES resumes (id);

ALTER TABLE educations
    ADD CONSTRAINT FK_EDUCATIONS_ON_RESUME FOREIGN KEY (resume_id) REFERENCES resumes (id);

ALTER TABLE experiences
    ADD CONSTRAINT FK_EXPERIENCES_ON_RESUME FOREIGN KEY (resume_id) REFERENCES resumes (id);

ALTER TABLE objectives
    ADD CONSTRAINT FK_OBJECTIVES_ON_RESUME FOREIGN KEY (resume_id) REFERENCES resumes (id);

ALTER TABLE profiles
    ADD CONSTRAINT FK_PROFILES_ON_RESUME FOREIGN KEY (resume_id) REFERENCES resumes (id);

ALTER TABLE pursuits
    ADD CONSTRAINT FK_PURSUITS_ON_RESUME FOREIGN KEY (resume_id) REFERENCES resumes (id);

ALTER TABLE referees
    ADD CONSTRAINT FK_REFEREES_ON_RESUME FOREIGN KEY (resume_id) REFERENCES resumes (id);

ALTER TABLE skills
    ADD CONSTRAINT FK_SKILLS_ON_RESUME FOREIGN KEY (resume_id) REFERENCES resumes (id);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_RESUME FOREIGN KEY (resume_id) REFERENCES resumes (id);
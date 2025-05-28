ALTER TABLE users
DROP
CONSTRAINT fk_users_on_resume;

ALTER TABLE users
    ADD role VARCHAR(100);

ALTER TABLE users
    ALTER COLUMN role SET NOT NULL;

ALTER TABLE users
DROP
COLUMN resume_id;
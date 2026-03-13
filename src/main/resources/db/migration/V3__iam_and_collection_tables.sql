-- =====================================================
-- ENUMS
-- =====================================================

CREATE TYPE iam.user_status AS ENUM (
    'APPROVED',
    'PENDING',
    'BANNED'
);

CREATE TYPE iam.user_profile AS ENUM (
    'USER',
    'ADMIN',
    'APP'
);

CREATE TYPE collection.collection_status AS ENUM (
    'OWN',
    'WANT',
    'READING',
    'DROPPED'
);

CREATE TYPE collection.item_condition AS ENUM (
    'MINT',
    'NM',
    'VF',
    'F',
    'P'
);

-- =====================================================
-- USERS
-- =====================================================

CREATE TABLE iam.users (
                           id BIGSERIAL PRIMARY KEY,

                           username VARCHAR(50) NOT NULL,
                           password_hash VARCHAR(255) NOT NULL,
                           email VARCHAR(255),

                           avatar VARCHAR(255),
                           cover VARCHAR(255),
                           about_you TEXT,

                           status iam.user_status NOT NULL,
                           profile iam.user_profile NOT NULL DEFAULT 'USER',
                           signup_date TIMESTAMPTZ NOT NULL,

                           CONSTRAINT uq_users_username UNIQUE (username),
                           CONSTRAINT uq_users_email UNIQUE (email)
);

-- =====================================================
-- USER ISSUES
-- =====================================================

CREATE TABLE collection.user_issues (
                                        user_id BIGINT NOT NULL,
                                        issue_id BIGINT NOT NULL,

                                        status collection.collection_status NOT NULL DEFAULT 'OWN',
                                        collected_date TIMESTAMPTZ,

                                        condition collection.item_condition,
                                        notes TEXT,
                                        quantity INTEGER NOT NULL DEFAULT 1,

                                        active_cover_id BIGINT,

                                        PRIMARY KEY (user_id, issue_id),

                                        CONSTRAINT fk_user_issues_user
                                            FOREIGN KEY (user_id)
                                                REFERENCES iam.users(id)
                                                ON DELETE CASCADE,

                                        CONSTRAINT fk_user_issues_issue
                                            FOREIGN KEY (issue_id)
                                                REFERENCES catalog.issues(id)
                                                ON DELETE CASCADE,

                                        CONSTRAINT fk_user_issues_active_cover
                                            FOREIGN KEY (active_cover_id)
                                                REFERENCES catalog.covers(id)
                                                ON DELETE SET NULL,

                                        CONSTRAINT ck_user_issues_quantity
                                            CHECK (quantity > 0)
);

-- =====================================================
-- USER COVERS
-- =====================================================

CREATE TABLE collection.user_covers (
                                        user_id BIGINT NOT NULL,
                                        issue_id BIGINT NOT NULL,
                                        cover_id BIGINT NOT NULL,

                                        collected_date TIMESTAMPTZ,

                                        PRIMARY KEY (user_id, cover_id),

                                        CONSTRAINT fk_user_covers_user_issue
                                            FOREIGN KEY (user_id, issue_id)
                                                REFERENCES collection.user_issues(user_id, issue_id)
                                                ON DELETE CASCADE,

                                        CONSTRAINT fk_user_covers_issue_cover
                                            FOREIGN KEY (issue_id, cover_id)
                                                REFERENCES catalog.issue_covers(issue_id, cover_id)
                                                ON DELETE CASCADE
);
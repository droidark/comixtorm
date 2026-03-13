-- =====================================================
-- ENUMS
-- =====================================================

CREATE TYPE catalog.publication_status AS ENUM (
    'ANNOUNCED',
    'PUBLISHED',
    'CANCELLED',
    'UNKNOWN'
);

-- =====================================================
-- BASE TABLES
-- =====================================================

CREATE TABLE catalog.publishers (
                                    id BIGSERIAL PRIMARY KEY,
                                    name VARCHAR(255) NOT NULL,
                                    lookup_key VARCHAR(255) NOT NULL UNIQUE,
                                    information TEXT,
                                    logo VARCHAR(255),
                                    url VARCHAR(255)
);

CREATE TABLE catalog.authors (
                                 id BIGSERIAL PRIMARY KEY,
                                 name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE catalog.roles (
                               id BIGSERIAL PRIMARY KEY,
                               role VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE catalog.genres (
                                id BIGSERIAL PRIMARY KEY,
                                genre VARCHAR(100) NOT NULL UNIQUE
);

-- =====================================================
-- WORKS
-- =====================================================

CREATE TABLE catalog.works (
                               id BIGSERIAL PRIMARY KEY,
                               name VARCHAR(255) NOT NULL,
                               lookup_key VARCHAR(255) NOT NULL UNIQUE
);

-- =====================================================
-- TITLES
-- =====================================================

CREATE TABLE catalog.titles (
                                id BIGSERIAL PRIMARY KEY,

                                publisher_id BIGINT NOT NULL,
                                work_id BIGINT,

                                name VARCHAR(255) NOT NULL,
                                lookup_key VARCHAR(255) NOT NULL UNIQUE,

                                cover VARCHAR(255),

                                demography VARCHAR(100),
                                format VARCHAR(100),
                                frequency VARCHAR(100),

                                release_date DATE,

                                status VARCHAR(50),
                                type VARCHAR(100),

                                total_issues INTEGER,

                                publication_status catalog.publication_status NOT NULL DEFAULT 'PUBLISHED',

                                CONSTRAINT fk_titles_publisher
                                    FOREIGN KEY (publisher_id)
                                        REFERENCES catalog.publishers(id),

                                CONSTRAINT fk_titles_work
                                    FOREIGN KEY (work_id)
                                        REFERENCES catalog.works(id)
);

-- =====================================================
-- TITLE RELATIONS
-- =====================================================

CREATE TABLE catalog.titles_genres (
                                       title_id BIGINT NOT NULL,
                                       genre_id BIGINT NOT NULL,

                                       PRIMARY KEY (title_id, genre_id),

                                       CONSTRAINT fk_titles_genres_title
                                           FOREIGN KEY (title_id)
                                               REFERENCES catalog.titles(id)
                                               ON DELETE CASCADE,

                                       CONSTRAINT fk_titles_genres_genre
                                           FOREIGN KEY (genre_id)
                                               REFERENCES catalog.genres(id)
);

CREATE TABLE catalog.titles_authors_roles (
                                              title_id BIGINT NOT NULL,
                                              author_id BIGINT NOT NULL,
                                              role_id BIGINT NOT NULL,

                                              PRIMARY KEY (title_id, author_id, role_id),

                                              CONSTRAINT fk_tar_title
                                                  FOREIGN KEY (title_id)
                                                      REFERENCES catalog.titles(id)
                                                      ON DELETE CASCADE,

                                              CONSTRAINT fk_tar_author
                                                  FOREIGN KEY (author_id)
                                                      REFERENCES catalog.authors(id),

                                              CONSTRAINT fk_tar_role
                                                  FOREIGN KEY (role_id)
                                                      REFERENCES catalog.roles(id)
);

-- =====================================================
-- ISSUES
-- =====================================================

CREATE TABLE catalog.issues (
                                id BIGSERIAL PRIMARY KEY,

                                title_id BIGINT NOT NULL,

                                name VARCHAR(500) NOT NULL,
                                lookup_key VARCHAR(500) NOT NULL UNIQUE,

                                number NUMERIC(6,2),

                                pages INTEGER,

                                printed_price NUMERIC(10,2),
                                digital_price NUMERIC(10,2),

                                currency VARCHAR(3),

                                release_date DATE,

                                short_review TEXT,

                                event VARCHAR(255),
                                story_arch VARCHAR(255),

                                isbn VARCHAR(17),
                                barcode VARCHAR(20),

                                edition INTEGER,
                                variant BOOLEAN DEFAULT FALSE,

                                variant_of BIGINT,

                                likes_counter INTEGER DEFAULT 0,
                                dislikes_counter INTEGER DEFAULT 0,

                                publication_status catalog.publication_status NOT NULL DEFAULT 'PUBLISHED',

                                CONSTRAINT fk_issue_title
                                    FOREIGN KEY (title_id)
                                        REFERENCES catalog.titles(id),

                                CONSTRAINT fk_issue_variant
                                    FOREIGN KEY (variant_of)
                                        REFERENCES catalog.issues(id)
);

-- =====================================================
-- COVERS
-- =====================================================

CREATE TABLE catalog.covers (
                                id BIGSERIAL PRIMARY KEY,

                                image_url VARCHAR(500) NOT NULL,

                                variant_name VARCHAR(255),

                                is_default BOOLEAN DEFAULT FALSE
);

CREATE TABLE catalog.issue_covers (
                                      issue_id BIGINT NOT NULL,
                                      cover_id BIGINT NOT NULL,

                                      PRIMARY KEY (issue_id, cover_id),

                                      CONSTRAINT fk_issue_covers_issue
                                          FOREIGN KEY (issue_id)
                                              REFERENCES catalog.issues(id)
                                              ON DELETE CASCADE,

                                      CONSTRAINT fk_issue_covers_cover
                                          FOREIGN KEY (cover_id)
                                              REFERENCES catalog.covers(id)
                                              ON DELETE CASCADE
);

-- =====================================================
-- EVENTS
-- =====================================================

CREATE TABLE catalog.events (
                                id BIGSERIAL PRIMARY KEY,

                                publisher_id BIGINT NOT NULL,

                                name VARCHAR(255) NOT NULL,

                                description TEXT,

                                CONSTRAINT fk_events_publisher
                                    FOREIGN KEY (publisher_id)
                                        REFERENCES catalog.publishers(id)
);

-- =====================================================
-- ARCS
-- =====================================================

CREATE TABLE catalog.arcs (
                              id BIGSERIAL PRIMARY KEY,

                              publisher_id BIGINT NOT NULL,

                              name VARCHAR(255) NOT NULL,

                              description TEXT,

                              CONSTRAINT fk_arcs_publisher
                                  FOREIGN KEY (publisher_id)
                                      REFERENCES catalog.publishers(id)
);

-- =====================================================
-- ISSUE EVENTS
-- =====================================================

CREATE TABLE catalog.issue_events (
                                      issue_id BIGINT NOT NULL,
                                      event_id BIGINT NOT NULL,

                                      PRIMARY KEY (issue_id, event_id),

                                      CONSTRAINT fk_issue_events_issue
                                          FOREIGN KEY (issue_id)
                                              REFERENCES catalog.issues(id)
                                              ON DELETE CASCADE,

                                      CONSTRAINT fk_issue_events_event
                                          FOREIGN KEY (event_id)
                                              REFERENCES catalog.events(id)
);

-- =====================================================
-- ISSUE ARCS
-- =====================================================

CREATE TABLE catalog.issue_arcs (
                                    issue_id BIGINT NOT NULL,
                                    arc_id BIGINT NOT NULL,

                                    PRIMARY KEY (issue_id, arc_id),

                                    CONSTRAINT fk_issue_arcs_issue
                                        FOREIGN KEY (issue_id)
                                            REFERENCES catalog.issues(id)
                                            ON DELETE CASCADE,

                                    CONSTRAINT fk_issue_arcs_arc
                                        FOREIGN KEY (arc_id)
                                            REFERENCES catalog.arcs(id)
);
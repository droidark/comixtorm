-- =====================================================
-- PUBLISHERS
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_publishers_name
    ON catalog.publishers (name);

-- =====================================================
-- PUBLISHER SOCIAL NETWORKS
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_publisher_social_networks_publisher_id
    ON catalog.publisher_social_networks (publisher_id);

CREATE INDEX IF NOT EXISTS idx_publisher_social_networks_platform
    ON catalog.publisher_social_networks (platform);

-- =====================================================
-- AUTHORS
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_authors_name
    ON catalog.authors (name);

-- =====================================================
-- ROLES
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_roles_role
    ON catalog.roles (role);

-- =====================================================
-- GENRES
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_genres_genre
    ON catalog.genres (genre);

-- =====================================================
-- WORKS
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_works_name
    ON catalog.works (name);

-- =====================================================
-- TITLES
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_titles_publisher_id
    ON catalog.titles (publisher_id);

CREATE INDEX IF NOT EXISTS idx_titles_work_id
    ON catalog.titles (work_id);

CREATE INDEX IF NOT EXISTS idx_titles_name
    ON catalog.titles (name);

CREATE INDEX IF NOT EXISTS idx_titles_status
    ON catalog.titles (status);

CREATE INDEX IF NOT EXISTS idx_titles_type
    ON catalog.titles (type);

CREATE INDEX IF NOT EXISTS idx_titles_publication_status
    ON catalog.titles (publication_status);

CREATE INDEX IF NOT EXISTS idx_titles_release_date
    ON catalog.titles (release_date);

CREATE INDEX IF NOT EXISTS idx_titles_publisher_lookup_key
    ON catalog.titles (publisher_id, lookup_key);

-- =====================================================
-- TITLES GENRES
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_titles_genres_genre_id
    ON catalog.titles_genres (genre_id);

-- =====================================================
-- TITLES AUTHORS ROLES
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_titles_authors_roles_author_id
    ON catalog.titles_authors_roles (author_id);

CREATE INDEX IF NOT EXISTS idx_titles_authors_roles_role_id
    ON catalog.titles_authors_roles (role_id);

CREATE INDEX IF NOT EXISTS idx_titles_authors_roles_title_id
    ON catalog.titles_authors_roles (title_id);

CREATE INDEX IF NOT EXISTS idx_titles_authors_roles_title_role
    ON catalog.titles_authors_roles (title_id, role_id);

-- =====================================================
-- ISSUES
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_issues_title_id
    ON catalog.issues (title_id);

CREATE INDEX IF NOT EXISTS idx_issues_title_lookup_key
    ON catalog.issues (title_id, lookup_key);

CREATE INDEX IF NOT EXISTS idx_issues_title_number
    ON catalog.issues (title_id, number);

CREATE INDEX IF NOT EXISTS idx_issues_release_date
    ON catalog.issues (release_date);

CREATE INDEX IF NOT EXISTS idx_issues_publication_status
    ON catalog.issues (publication_status);

CREATE INDEX IF NOT EXISTS idx_issues_variant
    ON catalog.issues (variant);

CREATE INDEX IF NOT EXISTS idx_issues_variant_of
    ON catalog.issues (variant_of);

CREATE INDEX IF NOT EXISTS idx_issues_isbn
    ON catalog.issues (isbn);

CREATE INDEX IF NOT EXISTS idx_issues_barcode
    ON catalog.issues (barcode);

-- =====================================================
-- COVERS
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_covers_is_default
    ON catalog.covers (is_default);

CREATE INDEX IF NOT EXISTS idx_covers_variant_name
    ON catalog.covers (variant_name);

-- =====================================================
-- ISSUE COVERS
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_issue_covers_cover_id
    ON catalog.issue_covers (cover_id);

CREATE INDEX IF NOT EXISTS idx_issue_covers_issue_id
    ON catalog.issue_covers (issue_id);

-- =====================================================
-- EVENTS
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_events_publisher_id
    ON catalog.events (publisher_id);

CREATE INDEX IF NOT EXISTS idx_events_name
    ON catalog.events (name);

-- =====================================================
-- ARCS
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_arcs_publisher_id
    ON catalog.arcs (publisher_id);

CREATE INDEX IF NOT EXISTS idx_arcs_name
    ON catalog.arcs (name);

-- =====================================================
-- ISSUE EVENTS
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_issue_events_event_id
    ON catalog.issue_events (event_id);

CREATE INDEX IF NOT EXISTS idx_issue_events_issue_id
    ON catalog.issue_events (issue_id);

-- =====================================================
-- ISSUE ARCS
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_issue_arcs_arc_id
    ON catalog.issue_arcs (arc_id);

CREATE INDEX IF NOT EXISTS idx_issue_arcs_issue_id
    ON catalog.issue_arcs (issue_id);

-- =====================================================
-- IAM.USERS
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_users_status
    ON iam.users (status);

CREATE INDEX IF NOT EXISTS idx_users_profile
    ON iam.users (profile);

CREATE INDEX IF NOT EXISTS idx_users_signup_date
    ON iam.users (signup_date);

-- =====================================================
-- COLLECTION.USER_ISSUES
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_user_issues_user_id
    ON collection.user_issues (user_id);

CREATE INDEX IF NOT EXISTS idx_user_issues_issue_id
    ON collection.user_issues (issue_id);

CREATE INDEX IF NOT EXISTS idx_user_issues_status
    ON collection.user_issues (status);

CREATE INDEX IF NOT EXISTS idx_user_issues_collected_date
    ON collection.user_issues (collected_date);

CREATE INDEX IF NOT EXISTS idx_user_issues_active_cover_id
    ON collection.user_issues (active_cover_id);

CREATE INDEX IF NOT EXISTS idx_user_issues_user_status
    ON collection.user_issues (user_id, status);

-- =====================================================
-- COLLECTION.USER_COVERS
-- =====================================================

CREATE INDEX IF NOT EXISTS idx_user_covers_user_id
    ON collection.user_covers (user_id);

CREATE INDEX IF NOT EXISTS idx_user_covers_issue_id
    ON collection.user_covers (issue_id);

CREATE INDEX IF NOT EXISTS idx_user_covers_cover_id
    ON collection.user_covers (cover_id);

CREATE INDEX IF NOT EXISTS idx_user_covers_collected_date
    ON collection.user_covers (collected_date);

CREATE INDEX IF NOT EXISTS idx_user_covers_user_issue
    ON collection.user_covers (user_id, issue_id);
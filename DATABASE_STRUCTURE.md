# Collector Database

## Enums
- `user_status`

  **Valores:** APPROVED, PENDING, BANNED

- `user_profile`

  **Valores:** USER, ADMIN, APP

- `collection_status`

  **Valores:** OWN, WANT, READING, DROPPED

- `item_condition`

  **Valores:** MINT, NM, VF, F, P

- `publication_status`

  **Valores:** ANNOUNCED, PUBLISHED, CANCELLED, UNKNOWN

## Tablas

### 1) publishers

**Propósito:** Editorial/sello (Panini MX, Marvel, etc.)

#### Campos
- `id` BIGINT identity, **PK**
- `name` TEXT NOT NULL
- `key` TEXT NOT NULL (slug)
- `information` TEXT NULL
- `logo` TEXT NULL
- `url` TEXT NULL
#### Llaves / constraints
- **PK:** (`id`)
- **UNIQUE:** (key)
#### Índices recomendados
- `uq_publishers_key` (unique index por key) (Postgres lo crea con `UNIQUE`)
- *(Opcional)* index por name si harás búsqueda rápida

---

### 2) publisher_social_networks

**Propósito:** Redes sociales de una editorial.

#### Campos
- `id` BIGINT identity, **PK**
- `publisher_id` BIGINT NOT NULL
- `platform` TEXT NOT NULL (TW/FB/IG...)
- `username` TEXT NULL
- `url` TEXT NOT NULL

#### Llaves / constraints
- **PK:** (`id`)
- **FK:** `publisher_id` -> publishers(`id`) **ON DELETE CASCADE**
- **UNIQUE:** (`publisher_id`, `platform`, `username`)
#### Índices
- `idx_psn_publisher` en (`publisher_id`)

---

### 3) works

**Propósito:** Agrupar ediciones (obra) dentro de una editorial. Opcional.

#### Campos
- `id` BIGINT identity, **PK**
- `publisher_id` BIGINT NOT NULL
- `key` TEXT NOT NULL
- `name` TEXT NOT NULL
#### Llaves / constraints
- **PK:** (`id`)
- **FK:** `publisher_id` -> publishers(`id`) **ON DELETE CASCADE**
- **UNIQUE:** (`publisher_id`, `key`) (evita colisiones entre publishers)
#### Índices
- `idx_works_publisher` en (`publisher_id`)

---

### 4) titles

**Propósito:** Título/serie (una edición específica). Slug único por editorial.

#### Campos
- `id` BIGINT identity, **PK**
- `publisher_id` BIGINT NOT NULL
- `work_id` BIGINT NULL (opcional)
- `name` TEXT NOT NULL
- `key` TEXT NOT NULL (slug)
- `cover` TEXT NULL (cover general del título; opcional)
- `demography` TEXT NULL
- `format` TEXT NULL
- `frequency` TEXT NULL
- `release_date` DATE NULL
- `status` TEXT NULL (ongoing/completed/hiatus...)
- `type` TEXT NOT NULL (manga/comic/guide/etc)
- `total_issues` INT NULL
- `publication_status` publication_status NOT NULL **DEFAULT** `'PUBLISHED'`
#### Llaves / constraints
- **PK:** (`id`)
- **FK:** `publisher_id` -> publishers(`id`) **ON DELETE CASCADE**
- **FK:** work_id -> works(id) ON DELETE SET NULL
- **UNIQUE:** (`publisher_id`, `key`) (slug scoped por editorial)
#### Índices
- `idx_titles_publisher` en (`publisher_id`)
- `idx_titles_work` en (`work_id`)

---

### 5) genres

**Propósito:** Catálogo normalizado de géneros.

#### Campos
- `id` BIGINT identity, **PK**
- `key` TEXT NOT NULL (slug)
- `name` TEXT NOT NULL
#### Llaves / constraints
- **PK:** (`id`)
- **UNIQUE:** (`key`)
- **UNIQUE:** (`name`)

---

### 6) titles_genres

**Propósito:** M:N entre títulos y géneros.

#### Campos
- `title_id` BIGINT NOT NULL
- `genre_id` BIGINT NOT NULL
#### Llaves / constraints
- **PK:** (`title_id`, `genre_id`)
- **FK**: `title_id` -> titles(`id`) **ON DELETE CASCADE**
- **FK:** genre_id -> genres(`id`) **ON DELETE RESTRICT**
#### Índices
- *(Opcional)* `idx_titles_genres_genre` en (`genre_id`) para buscar títulos por género

---

### 7) issues

**Propósito:** Tomo/Issue/Volumen dentro de un título.

#### Campos
- `id` BIGINT identity, **PK**
- `title_id` BIGINT NOT NULL
- `name` TEXT NULL
- `key` TEXT NOT NULL (identity pública dentro del título: "0","1","annual-1")
- `number` NUMERIC(10,2) NULL (para orden; opcional)
- `edition` INT NULL (impresión/edición de este issue)
- `isbn` TEXT NULL
- `barcode` TEXT NULL
- `pages` INT NULL
- `printed_price` NUMERIC(10,2) NULL
- `digital_price` NUMERIC(10,2) NULL
- `currency` CHAR(3) NULL
- `release_date` DATE NULL
- `short_review` TEXT NULL
- `event_text` TEXT NULL *(legacy opcional)*
- `story_arc_text` TEXT NULL *(legacy opcional)*
- `publication_status` publication_status NOT NULL DEFAULT 'PUBLISHED'

#### Llaves / constraints
- **PK:** (`id`)
- **FK:** `title_id` -> titles(`id`) **ON DELETE CASCADE**
- **UNIQUE:** (`title_id`, `key`)
#### Índices
- `idx_issues_title` en (`title_id`)
- `idx_issues_title_number` en (`title_id`, `number`) (para ordenar/paginar)

---

### 8) covers

**Propósito:** Portadas (default + variantes) por issue.

#### Campos
- `id` BIGINT identity, **PK**
- `issue_id` BIGINT NOT NULL
- `key` TEXT NOT NULL (default/A/B/foil/1:10...)
- `image_url` TEXT NULL
- `is_default` BOOLEAN NOT NULL DEFAULT FALSE
#### Llaves / constraints
- PK: (id)
- FK: issue_id -> issues(id) ON DELETE CASCADE
- UNIQUE: (issue_id, key)
- UNIQUE parcial: solo 1 default por issue
- UNIQUE(issue_id) WHERE is_default = true
#### Índices
- idx_covers_issue en (issue_id)

---

### 9) persons

**Propósito:** Personas acreditadas (autor, artista, etc.)

#### Campos
- `id` BIGINT identity, **PK**
- `name` TEXT NOT NULL
- `key` TEXT NOT NULL (slug estable)
#### Llaves / constraints
- **PK:** (`id`)
- **UNIQUE:** (`key`)
- **UNIQUE:** (name) (recomendado para evitar duplicados; si prefieres homónimos, lo quitamos)
#### Índices
- unique indexes por key y name (por UNIQUE)

---

### 10) roles

**Propósito:** Roles estándar para créditos (CREATOR, WRITER, etc.)

#### Campos
- `id` BIGINT identity, **PK**
- `code` TEXT NOT NULL (CREATOR, WRITER...)
- `label` TEXT NOT NULL (texto humano)
#### Llaves / constraints
- **PK:** (id)
- **UNIQUE:** (code)

---

### 11) credits

**Propósito:** Créditos con scope único (title OR issue OR cover).

#### Campos
- `id` BIGINT identity, **PK**
- `title_id` BIGINT NULL
- `issue_id` BIGINT NULL
- `cover_id` BIGINT NULL
- `person_id` BIGINT NOT NULL
- `role_id` BIGINT NOT NULL
- `source_label` TEXT NULL (*"created by"*, *"art by"*... para trazabilidad)
- `sort_order` INT NULL
#### Llaves / constraints
- **PK:** (`id`)
- **FK:** `title_id` -> titles(`id`) **ON DELETE CASCADE**
- **FK:** `issue_id` -> issues(`id`) **ON DELETE CASCADE**
- **FK:** `cover_id` -> covers(`id`) **ON DELETE CASCADE**
- **FK:** `person_id` -> persons(`id`) **ON DELETE CASCADE**
- **FK:** `role_id` -> roles(`id`) **ON DELETE RESTRICT**
- **CHECK (XOR):** exactamente uno de `title_id`/`issue_id`/`cover_id` debe ser **NOT NULL**:
    - ((`title_id` **is not null**) :: int + (`issue_id` **is not null**)::int + (`cover_id` **is not null**) :: int) = 1
- **UNIQUES** (para evitar duplicados por scope)

> En Postgres se implementa mejor con índices únicos parciales:

- UNIQUE(`title_id`, `person_id`, `role_id`) WHERE `title_id` IS NOT NULL
- UNIQUE(`issue_id`, `person_id`, `role_id`) WHERE `issue_id` IS NOT NULL
- UNIQUE(`cover_id`, `person_id`, `role_id`) WHERE `cover_id` IS NOT NULL

#### Índices
- `idx_credits_title` en (`title_id`)
- `idx_credits_issue` en (`issue_id`)
- `idx_credits_cover` en (`cover_id`)

---

### 12) users

**Propósito:** Usuarios del sistema (incluye service accounts con profile=APP).

#### Campos
- `id` BIGINT identity, **PK**
- `username` TEXT NOT NULL
- `password_hash` TEXT NOT NULL
- `email` TEXT NOT NULL
- `avatar` TEXT NULL
- `cover` TEXT NULL
- `about_you` TEXT NULL
- `status` user_status NOT NULL
- `profile` user_profile NOT NULL DEFAULT 'USER'
- `signup_date` TIMESTAMPTZ NOT NULL
#### Llaves / constraints
- **PK:** (`id`)
- **UNIQUE:** (`username`)
- **UNIQUE:** (`email`)

---

### 13) user_issue

**Propósito:** Inventario del usuario a nivel issue (“mi copia”), con metadata.

#### Campos
- `user_id` BIGINT NOT NULL
- `issue_id` BIGINT NOT NULL
- `status` collection_status NOT NULL **DEFAULT 'OWN'**
- `collected_date` TIMESTAMPTZ NULL
- `condition` item_condition NULL
- `notes` TEXT NULL
- `quantity` INT NOT NULL DEFAULT 1
- `active_cover_id` BIGINT NULL (portada preferida para UI)
#### Llaves / constraints
- **PK:** (`user_id`, `issue_id`)
- **FK:** `user_id` -> users(`id`) **ON DELETE CASCADE**
- **FK:** `issue_id` -> issues(`id`) **ON DELETE CASCADE**
- **FK:** `active_cover_id` -> covers(`id`) (sin cascade; recomendado **ON DELETE SET NULL** si quieres)
#### Índices
- `idx_user_issue_user` en (`user_id`)
- `idx_user_issue_issue` en (`issue_id`)

---

### 14) user_cover

**Propósito:** Qué portadas (variantes) posee el usuario.
**Regla fuerte:** no puede existir si no existe user_issue.

#### Campos
- user_id BIGINT NOT NULL
- issue_id BIGINT NOT NULL
- cover_id BIGINT NOT NULL
- collected_date TIMESTAMPTZ NULL
#### Llaves / constraints
- PK: (user_id, cover_id) (evita duplicados de la misma portada por usuario)
- FK: cover_id -> covers(id) ON DELETE CASCADE
- FK compuesta (regla “si y solo si”):
    - (user_id, issue_id) -> user_issue(user_id, issue_id) ON DELETE CASCADE
#### Índices
- idx_user_cover_user en (user_id)
- idx_user_cover_issue en (issue_id)

> **Nota:** La consistencia `cover.issue_id == user_cover.issue_id` no se puede forzar con **FK** simple (porque el issue_id está "derivado"). Se valida en app o con trigger. En práctica, basta con validación en service/DAO al insertar.

### 15) events

**Propósito:** Eventos editoriales por publisher (Civil War en Marvel US vs Panini MX).

#### Campos
- `id` BIGINT identity, **PK**
- `publisher_id` BIGINT NOT NULL
- `key` TEXT NOT NULL *(slug)*
- `name` TEXT NOT NULL
- `description` TEXT NULL
#### Llaves / constraints
- **PK:** (`id`)
- **FK:** `publisher_id` -> publishers(`id`) **ON DELETE CASCADE**
- **UNIQUE:** (`publisher_id`, `key`)
#### Índices
- `idx_events_publisher` en (`publisher_id`) (recomendado)

---

### 16) event_issues

**Propósito:** M:N event→issues con orden de lectura.

#### Campos
- `event_id` BIGINT NOT NULL
- `issue_id` BIGINT NOT NULL
- `reading_order` INT NULL
- `notes` TEXT NULL
#### Llaves / constraints
- **PK:** (`event_id`, `issue_id`)
- **FK:** `event_id` -> events(`id`) **ON DELETE CASCADE**
- **FK:** `issue_id` -> issues(`id`) **ON DELETE CASCADE**
#### Índices
- `idx_event_issues_issue` en (`issue_id`) (para *"en qué eventos aparece este issue"*)

---

### 17) story_arcs

**Propósito:** Arcos/sagas por publisher (Court of Owls).

#### Campos
- `id` BIGINT identity, **PK**
- `publisher_id` BIGINT NOT NULL
- `key` TEXT NOT NULL (slug)
- `name` TEXT NOT NULL
- `description` TEXT NULL
#### Llaves / constraints
- **PK:** (`id`)
- **FK:** `publisher_id` -> publishers(`id`) **ON DELETE CASCADE**
- **UNIQUE:** (`publisher_id`, `key`)
#### Índices
- `idx_story_arcs_publisher` en (`publisher_id`) (recomendado)

---

### 18) arc_issues

**Propósito:** M:N arc→issues con orden de lectura.

#### Campos
- `arc_id` BIGINT NOT NULL
- `issue_id` BIGINT NOT NULL
- `reading_order` INT NULL
#### Llaves / constraints
- **PK:** (`arc_id`, `issue_id`)
- **FK:** `arc_id` -> story_arcs(`id`) **ON DELETE CASCADE**
- **FK:** `issue_id` -> issues(`id`) **ON DELETE CASCADE**
#### Índices
- `idx_arc_issues_issue` en (`issue_id`)
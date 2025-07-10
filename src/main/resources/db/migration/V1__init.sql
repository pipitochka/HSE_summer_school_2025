-- Таблица учреждений
CREATE TABLE institutions (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    website_url VARCHAR(255)
);

-- Таблица аудиогидов
CREATE TABLE audio_tours (
    id UUID PRIMARY KEY,
    institution_id UUID NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    audio_url VARCHAR(255) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT fk_institution
        FOREIGN KEY (institution_id) REFERENCES institutions(id)
        ON DELETE CASCADE
);

-- Таблица тегов
CREATE TABLE tags (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

-- Таблица связей между аудиогидами и тегами (многие-ко-многим)
CREATE TABLE audio_tour_tags (
    audio_tour_id UUID NOT NULL,
    tag_id UUID NOT NULL,
    PRIMARY KEY (audio_tour_id, tag_id),
    CONSTRAINT fk_audio_tour FOREIGN KEY (audio_tour_id) REFERENCES audio_tours(id) ON DELETE CASCADE,
    CONSTRAINT fk_tag FOREIGN KEY (tag_id) REFERENCES tags(id) ON DELETE CASCADE
);

-- Таблица вложений (например, изображения или доп. материалы к аудиогиду)
CREATE TABLE attachments (
    id UUID PRIMARY KEY,
    audio_tour_id UUID NOT NULL,
    filename VARCHAR(255) NOT NULL,
    s3_key VARCHAR(255) NOT NULL UNIQUE,
    size_bytes BIGINT NOT NULL,
    uploaded_at TIMESTAMP WITH TIME ZONE NOT NULL,
    CONSTRAINT fk_audio_tour_attachment FOREIGN KEY (audio_tour_id) REFERENCES audio_tours(id) ON DELETE CASCADE
);


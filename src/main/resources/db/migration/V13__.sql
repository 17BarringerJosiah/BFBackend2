ALTER TABLE widget_variant
    ADD variant_image_url VARCHAR(255);

ALTER TABLE widget_variant
DROP
COLUMN image_url;
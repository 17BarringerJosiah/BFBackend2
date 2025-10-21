ALTER TABLE widget_variant
    ADD widget_id BIGINT;

ALTER TABLE widget_variant
    ADD CONSTRAINT pk_widget_variant PRIMARY KEY (widget_id);

ALTER TABLE widget_variant
    ADD CONSTRAINT FK_WIDGET_VARIANT_ON_WIDGET FOREIGN KEY (widget_id) REFERENCES widget (id);
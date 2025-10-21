ALTER TABLE widget
    ADD color_id BIGINT;

ALTER TABLE widget
    ADD lifecycle_status_id BIGINT;

ALTER TABLE widget
    ADD metrics_id BIGINT;

ALTER TABLE widget
    ADD CONSTRAINT uc_widget_metrics UNIQUE (metrics_id);


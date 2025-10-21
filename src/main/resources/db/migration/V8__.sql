CREATE TABLE widget_variant
(
    color_id            BIGINT,
    metrics_id          BIGINT,
    lifecycle_status_id BIGINT
);

ALTER TABLE widget_variant
    ADD CONSTRAINT uc_widget_variant_metrics UNIQUE (metrics_id);

ALTER TABLE widget_variant
    ADD CONSTRAINT FK_WIDGET_VARIANT_ON_COLOR FOREIGN KEY (color_id) REFERENCES color (color_id);

ALTER TABLE widget_variant
    ADD CONSTRAINT FK_WIDGET_VARIANT_ON_LIFECYCLE_STATUS FOREIGN KEY (lifecycle_status_id) REFERENCES lifecycle_status (lifecycle_status_id);

ALTER TABLE widget_variant
    ADD CONSTRAINT FK_WIDGET_VARIANT_ON_METRICS FOREIGN KEY (metrics_id) REFERENCES widget_metrics (widget_metrics_id);
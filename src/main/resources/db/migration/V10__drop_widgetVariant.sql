ALTER TABLE widget_variant
DROP
CONSTRAINT fk_widget_variant_on_color;

ALTER TABLE widget_variant
DROP
CONSTRAINT fk_widget_variant_on_lifecycle_status;

ALTER TABLE widget_variant
DROP
CONSTRAINT fk_widget_variant_on_metrics;

ALTER TABLE widget_variant
DROP
CONSTRAINT fk_widget_variant_on_widget;

ALTER TABLE widget
    ADD CONSTRAINT FK_WIDGET_ON_COLOR FOREIGN KEY (color_id) REFERENCES color (color_id);

ALTER TABLE widget
    ADD CONSTRAINT FK_WIDGET_ON_LIFECYCLE_STATUS FOREIGN KEY (lifecycle_status_id) REFERENCES lifecycle_status (lifecycle_status_id);

ALTER TABLE widget
    ADD CONSTRAINT FK_WIDGET_ON_METRICS FOREIGN KEY (metrics_id) REFERENCES widget_metrics (widget_metrics_id);

DROP TABLE widget_variant CASCADE;

ALTER TABLE widget
DROP
COLUMN dtype;
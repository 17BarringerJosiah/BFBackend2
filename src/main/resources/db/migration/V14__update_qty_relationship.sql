ALTER TABLE widget_variant
DROP
CONSTRAINT fk_widget_variant_on_metrics;

ALTER TABLE widget_variant
    ADD widget_metrics_id BIGINT;

ALTER TABLE widget_variant
    ADD CONSTRAINT uc_widget_variant_widgetmetrics UNIQUE (widget_metrics_id);

ALTER TABLE widget_variant
    ADD CONSTRAINT FK_WIDGET_VARIANT_ON_WIDGETMETRICS FOREIGN KEY (widget_metrics_id) REFERENCES widget_metrics (widget_metrics_id);

ALTER TABLE widget_variant
DROP
COLUMN metrics_id;

ALTER TABLE widget_variant
    ALTER COLUMN color_id SET NOT NULL;
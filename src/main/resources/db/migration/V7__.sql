
/*
ALTER TABLE widget
    ADD color_id BIGINT;

ALTER TABLE widget
    ADD lifecycle_status_id BIGINT;

ALTER TABLE widget
    ADD metrics_id BIGINT;

ALTER TABLE widget
    ADD CONSTRAINT uc_widget_metrics UNIQUE (metrics_id);

ALTER TABLE widget
    ADD CONSTRAINT FK_WIDGET_ON_COLOR FOREIGN KEY (color_id) REFERENCES color (color_id);

ALTER TABLE widget
    ADD CONSTRAINT FK_WIDGET_ON_LIFECYCLE_STATUS FOREIGN KEY (lifecycle_status_id) REFERENCES lifecycle_status (lifecycle_status_id);

ALTER TABLE widget
    ADD CONSTRAINT FK_WIDGET_ON_METRICS FOREIGN KEY (metrics_id) REFERENCES widget_metrics (widget_metrics_id);


 */
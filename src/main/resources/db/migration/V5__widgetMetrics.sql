CREATE TABLE widget_metrics
(
    widget_metrics_id BIGINT NOT NULL,
    quantity          INTEGER,
    usefulness_rating DECIMAL(5, 1),
    CONSTRAINT pk_widget_metrics PRIMARY KEY (widget_metrics_id)
);
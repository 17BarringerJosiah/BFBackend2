ALTER TABLE widget_metrics
    ADD total_quantity INTEGER;

ALTER TABLE widget_metrics
DROP
COLUMN quantity;
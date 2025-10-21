CREATE TABLE lifecycle_status
(
    lifecycle_status_id BIGINT       NOT NULL,
    lifecycle_status    VARCHAR(255) NOT NULL,
    CONSTRAINT pk_lifecycle_status PRIMARY KEY (lifecycle_status_id)
);
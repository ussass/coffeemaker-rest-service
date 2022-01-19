CREATE TABLE coffeemaker
(
    id                             BIGSERIAL NOT NULL PRIMARY KEY,
    water_temperature              INT       NOT NULL,
    hard_water                     INT       NOT NULL,
    remaining_cups_before_cleaning INT       NOT NULL,
    datetime                       BIGINT    NOT NULL
);
CREATE TABLE IF NOT EXISTS devices (
  uuid varchar,
  state boolean
);

CREATE UNIQUE INDEX uuid_unique_idx ON devices (UUID);
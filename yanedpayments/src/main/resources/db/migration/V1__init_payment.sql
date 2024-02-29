CREATE TABLE IF NOT EXISTS account(
    id SERIAL PRIMARY KEY,
    balance NUMERIC(38,2)
);

CREATE TYPE transaction_type AS ENUM('IN', 'OUT');

CREATE CAST (varchar AS transaction_type) WITH INOUT AS IMPLICIT;

CREATE TABLE IF NOT EXISTS transaction(
    id SERIAL PRIMARY KEY,
    amount NUMERIC(38,2) NOT NULL,
    type transaction_type NOT NULL,
    created_at TIMESTAMP,
    from_account INTEGER REFERENCES account (id) NOT NULL,
    to_account INTEGER REFERENCES account (id)
);
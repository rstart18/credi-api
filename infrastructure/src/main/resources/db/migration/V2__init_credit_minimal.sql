-- Credit domain tables
CREATE TABLE customers (
    id BIGSERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    document_id VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE loan_products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    annual_nominal_rate DECIMAL(8,6) NOT NULL,
    amortization_method VARCHAR(20) NOT NULL DEFAULT 'FRANCES',
    min_amount DECIMAL(15,2) NOT NULL,
    max_amount DECIMAL(15,2) NOT NULL,
    min_term INTEGER NOT NULL,
    max_term INTEGER NOT NULL
);

CREATE TABLE loan_applications (
    id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    term_months INTEGER NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'DRAFT',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (product_id) REFERENCES loan_products(id)
);

CREATE TABLE loans (
    id BIGSERIAL PRIMARY KEY,
    application_id BIGINT NOT NULL,
    principal DECIMAL(15,2) NOT NULL,
    annual_nominal_rate DECIMAL(8,6) NOT NULL,
    currency VARCHAR(3) NOT NULL DEFAULT 'COP',
    status VARCHAR(20) NOT NULL DEFAULT 'APPROVED',
    disbursement_date DATE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (application_id) REFERENCES loan_applications(id)
);

CREATE TABLE installments (
    id BIGSERIAL PRIMARY KEY,
    loan_id BIGINT NOT NULL,
    number INTEGER NOT NULL,
    due_date DATE NOT NULL,
    principal DECIMAL(15,2) NOT NULL,
    interest DECIMAL(15,2) NOT NULL,
    fees DECIMAL(15,2) NOT NULL DEFAULT 0,
    balance_after DECIMAL(15,2) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    FOREIGN KEY (loan_id) REFERENCES loans(id)
);

CREATE TABLE payments (
    id BIGSERIAL PRIMARY KEY,
    loan_id BIGINT NOT NULL,
    paid_at TIMESTAMP NOT NULL,
    amount DECIMAL(15,2) NOT NULL,
    method VARCHAR(20) NOT NULL DEFAULT 'TEST',
    FOREIGN KEY (loan_id) REFERENCES loans(id)
);
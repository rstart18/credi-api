-- Insert demo loan products
INSERT INTO loan_products (name, annual_nominal_rate, amortization_method, min_amount, max_amount, min_term, max_term) VALUES
('Crédito de Consumo', 0.18, 'FRANCES', 1000000.00, 50000000.00, 6, 60),
('Crédito Libre Inversión', 0.22, 'FRANCES', 500000.00, 20000000.00, 12, 48);
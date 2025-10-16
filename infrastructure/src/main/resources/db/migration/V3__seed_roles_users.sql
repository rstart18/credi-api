-- Insert permissions
INSERT INTO permissions (name, module, description) VALUES
('USER_READ', 'USER', 'Read users'),
('USER_WRITE', 'USER', 'Create/Update users'),
('USER_DELETE', 'USER', 'Delete users'),
('LOAN_READ', 'LOAN', 'Read loans'),
('LOAN_WRITE', 'LOAN', 'Create/Update loans'),
('LOAN_APPROVE', 'LOAN', 'Approve loan applications'),
('CUSTOMER_READ', 'CUSTOMER', 'Read customers'),
('CUSTOMER_WRITE', 'CUSTOMER', 'Create/Update customers');

-- Insert roles
INSERT INTO roles (name, description) VALUES
('ADMIN', 'System administrator with full access'),
('OPS', 'Operations user with loan management access'),
('ANALYST', 'Analyst with read-only access');

-- Assign permissions to roles
INSERT INTO role_permissions (role_id, permission_id) 
SELECT r.id, p.id FROM roles r, permissions p WHERE r.name = 'ADMIN';

INSERT INTO role_permissions (role_id, permission_id) 
SELECT r.id, p.id FROM roles r, permissions p 
WHERE r.name = 'OPS' AND p.module IN ('LOAN', 'CUSTOMER');

INSERT INTO role_permissions (role_id, permission_id) 
SELECT r.id, p.id FROM roles r, permissions p 
WHERE r.name = 'ANALYST' AND p.name LIKE '%_READ';

-- Insert demo admin user
INSERT INTO master_users (username, email, first_name, last_name) VALUES
('admin', 'admin@crediapi.com', 'Admin', 'User');

-- Assign admin role to demo user
INSERT INTO user_roles (user_id, role_id) 
SELECT u.id, r.id FROM master_users u, roles r 
WHERE u.username = 'admin' AND r.name = 'ADMIN';
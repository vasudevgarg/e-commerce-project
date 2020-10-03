USE `ecommerceDB`;
ALTER TABLE customer ADD CONSTRAINT constraint_unique_mob_no UNIQUE (mobile_no)
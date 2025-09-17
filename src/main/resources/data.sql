-- Seed data for polymorphic Params
-- This runs after JPA creates the schema
INSERT INTO public.requests (type, params) VALUES
  ('CREATE_ACCOUNT', '{"type":"CREATE_ACCOUNT","email":"user1@example.com","plan":"FREE"}'),
  ('PLACE_ORDER', '{"type":"PLACE_ORDER","items":[{"sku":"A1","qty":2},{"sku":"B3","qty":1}],"total":39.97}'),
  ('SEND_EMAIL', '{"type":"SEND_EMAIL","to":"user2@example.com","subject":"Welcome","retries":0}');

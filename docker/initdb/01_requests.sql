-- Create table if it does not exist (matches JPA entity)
CREATE TABLE IF NOT EXISTS public.requests (
  id BIGSERIAL PRIMARY KEY,
  type VARCHAR(255) NOT NULL,
  params JSONB
);

-- Seed sample data
INSERT INTO public.requests (type, params) VALUES
  ('CREATE_ACCOUNT', '{"email":"user1@example.com","plan":"FREE"}'),
  ('PLACE_ORDER', '{"items":[{"sku":"A1","qty":2},{"sku":"B3","qty":1}],"total":39.97}'),
  ('SEND_EMAIL', '{"to":"user2@example.com","subject":"Welcome","retries":0}');

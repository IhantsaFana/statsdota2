-- Insérer des équipes
INSERT INTO teams (name) VALUES 
('Team Spirit'), 
('Gaimin Gladiators'), 
('Tundra Esports');

-- Insérer des joueurs (exemples basés sur des pros)
INSERT INTO players (name, team_id) VALUES 
('Yatoro', 1), 
('Collapse', 1), 
('Larl', 1), 
('Mira', 1), 
('Miposhka', 1),

('Quinn', 2), 
('Ace', 2), 
('TOfu', 2), 
('dyrachyo', 2), 
('Seleri', 2),

('Skiter', 3), 
('Nine', 3), 
('33', 3), 
('Sneyking', 3), 
('Saksa', 3);

-- Insérer des matchs
INSERT INTO matches (date_played) VALUES 
('2024-02-10 18:30:00'), 
('2024-02-15 19:00:00'), 
('2024-02-20 20:15:00');

-- Insérer les statistiques des matchs
-- Match 1 : Team Spirit vs Gaimin Gladiators
INSERT INTO match_stats (match_id, player_id, kills, deaths, assists, first_kill) VALUES 
(1, 1, 10, 2, 5, TRUE),  -- Yatoro
(1, 2, 3, 4, 7, FALSE),  -- Collapse
(1, 3, 6, 3, 8, FALSE),  -- Larl
(1, 4, 1, 6, 10, FALSE), -- Mira
(1, 5, 2, 5, 12, FALSE), -- Miposhka
(1, 6, 8, 3, 6, FALSE),  -- Quinn
(1, 7, 4, 5, 7, FALSE),  -- Ace
(1, 8, 2, 4, 9, FALSE),  -- TOfu
(1, 9, 9, 2, 4, FALSE),  -- dyrachyo
(1, 10, 3, 7, 8, FALSE); -- Seleri

-- Match 2 : Gaimin Gladiators vs Tundra Esports
INSERT INTO match_stats (match_id, player_id, kills, deaths, assists, first_kill) VALUES 
(2, 6, 7, 3, 9, TRUE),  -- Quinn
(2, 7, 5, 4, 6, FALSE),  -- Ace
(2, 8, 3, 5, 8, FALSE),  -- TOfu
(2, 9, 10, 2, 5, FALSE), -- dyrachyo
(2, 10, 2, 6, 12, FALSE), -- Seleri
(2, 11, 9, 2, 6, FALSE),  -- Skiter
(2, 12, 5, 4, 7, FALSE),  -- Nine
(2, 13, 3, 5, 9, FALSE),  -- 33
(2, 14, 1, 6, 10, FALSE), -- Sneyking
(2, 15, 4, 5, 7, FALSE);  -- Saksa

-- Match 3 : Tundra Esports vs Team Spirit
INSERT INTO match_stats (match_id, player_id, kills, deaths, assists, first_kill) VALUES 
(3, 11, 8, 2, 5, TRUE),  -- Skiter
(3, 12, 6, 3, 7, FALSE),  -- Nine
(3, 13, 4, 5, 8, FALSE),  -- 33
(3, 14, 2, 6, 9, FALSE),  -- Sneyking
(3, 15, 3, 5, 6, FALSE),  -- Saksa
(3, 1, 9, 3, 4, FALSE),  -- Yatoro
(3, 2, 3, 4, 7, FALSE),  -- Collapse
(3, 3, 7, 2, 6, FALSE),  -- Larl
(3, 4, 2, 5, 10, FALSE), -- Mira
(3, 5, 1, 6, 11, FALSE); -- Miposhka

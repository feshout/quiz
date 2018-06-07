INSERT INTO public.user_access (id, name) VALUES (1, 'admin');
INSERT INTO public.user_access (id, name) VALUES (2, 'user');

INSERT INTO public.person (id, date, is_active, login, name, password, user_access_id) VALUES (1, '2018-06-07 13:47:04.063000', true, 'admin', 'A', 'admin', 1);
INSERT INTO public.person (id, date, is_active, login, name, password, user_access_id) VALUES (2, '2018-06-07 13:47:04.065000', true, 'user', 'U', 'user', 2);

INSERT INTO public.answer (id, description, is_correct) VALUES (1, 'Pierwsza odpowiedź', true);
INSERT INTO public.answer (id, description, is_correct) VALUES (2, 'Druga odpowiedź', false);
INSERT INTO public.answer (id, description, is_correct) VALUES (3, 'Trzecia odpowiedź', false);
INSERT INTO public.answer (id, description, is_correct) VALUES (4, 'Czwarta odpowiedź', false);

INSERT INTO public.category (id, create_date, is_active, modify_date, name, created_by_id, modify_by_id) VALUES (1, '2018-06-07 13:47:04.081000', true, '2018-06-07 13:47:04.081000', 'SQL', 2, 2);
INSERT INTO public.category (id, create_date, is_active, modify_date, name, created_by_id, modify_by_id) VALUES (2, '2018-06-07 13:47:04.081000', true, '2018-06-07 13:47:04.081000', 'OOP', 2, 2);

INSERT INTO public.question (id, create_date, description, is_active, modify_date, title, answer1_id, answer2_id, answer3_id, answer4_id, category_id, created_by_id, modify_by_id) VALUES (1, null, 'Opis1', true, null, 'Testowe1', 1, 2, 3, 4, 1, null, null);

INSERT INTO public.quiz (id, start_date, create_by_id) VALUES (1, '2018-06-07 13:47:04.073000', 2);

INSERT INTO public.question_response (id, answer, question_id, quiz_id) VALUES (1, 'Pierwsza odpowiedź', 1, 1);


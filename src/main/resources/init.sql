CREATE TABLE IF NOT EXISTS public.directory
(
    name text COLLATE pg_catalog."default",
    id integer NOT NULL DEFAULT nextval('directory_id_seq'::regclass),
    CONSTRAINT directory_pkey PRIMARY KEY (id)
)

INSERT INTO public.directory VALUES ('first_dir', 1);
INSERT INTO public.directory VALUES ('second_dir', 2);

CREATE TABLE public.file (
    filename text,
    id integer NOT NULL,
    length_file bigint,
    directory_id bigint
);

INSERT INTO public.file VALUES ('first_file', 1, 10, 1);
INSERT INTO public.file VALUES ('second_file', 2, 20, 1);
INSERT INTO public.file VALUES ('fourth_file', 3, 50, 2);
INSERT INTO public.file VALUES ('third_file', 4, 60, 2);
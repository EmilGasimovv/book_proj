ALTER TABLE books
    ADD COLUMN author_id INT,
ADD CONSTRAINT FK_books_authors
FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE ;


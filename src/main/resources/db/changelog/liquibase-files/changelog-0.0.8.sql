ALTER TABLE readings
ADD COLUMN student_id INT,
ADD CONSTRAINT Fk_readers
FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE  CASCADE ,
ADD COLUMN book_id INT,
ADD CONSTRAINT Fk_books
FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE
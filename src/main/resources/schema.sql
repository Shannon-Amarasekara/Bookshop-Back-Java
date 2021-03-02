
insert into books(id, name, image, genre, copies_sold, author_id, price, synopsis)
values
(0, 'Misery', 'https://upload.wikimedia.org/wikipedia/en/6/6f/Stephen_King_Misery_cover.jpg', 'Horror', 875000, 1, 8.99, 'synopsis of misery'),
(0, 'Harry Potter', 'https://www.abebooks.com/images/books/harry-potter/philosophers-stone.jpg', 'Fantasy', 500000000, 2, 4.99, 'synopsis of harry potter'),
(0, 'The Fault In Our Stars', 'https://upload.wikimedia.org/wikipedia/en/a/a9/The_Fault_in_Our_Stars.jpg', 'Romance', 10700000, 3, 6.99, 'synopsis of the fault in our stars'),
(0, 'A Brief History Of Time', 'https://images-na.ssl-images-amazon.com/images/I/51slEJbyEmL._AC_SY400_.jpg', 'Science', 10000000, 4, 7.99, 'synopsis of A Brief History of Time'),
(0, 'Looking For Alaska', 'https://images-na.ssl-images-amazon.com/images/I/91nTClkODkL.jpg', 'Romance', 5388, 3, 7.39, 'synopsis of Looking For Alaska'),
(0, 'The Stranger', 'https://images-na.ssl-images-amazon.com/images/I/81rNFIU-FxL.jpg', 'Philosophy', 4400, 5, 8.17, 'synopsis of the stranger'),
(0, 'The Giver', 'https://cdn.waterstones.com/bookjackets/large/9780/0072/9780007263516.jpg', 'Philosophy', 12000000, 6, 4.49, 'synopsis of the giver'),
(0, 'Lord Of The Flies', 'https://images-na.ssl-images-amazon.com/images/I/81jlbxMyR4L.jpg', 'Philosophy', 25000000, 7, 5.79, 'synopsis of Lord of The Flies'),
(0, 'The Catcher In The Rye', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1554406349l/7178._SY475_.jpg', 'Philosophy', 65000000, 8, 4.99, 'synopsis of Catcher in the Rye'),
(0, 'The Light Between Oceans', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1385609251l/19012815.jpg', 'Philosophy', 3000000, 9, 7.49, 'synopsis of teh light between oceans');

insert into authors(id, first_name, last_name, resume)
values
(1, 'Stephen', 'King', 'stephen king resume'),
(2, 'J.K.', 'Rowling', 'famous for harry potter books'),
(3, 'John', 'Green', 'john green resume'),
(4, 'Stephen', 'Hawking', 'stephen hawking resume'),
(5, 'Albert', 'Camus', 'albert camus resume'),
(6, 'Lois', 'Lowry', 'Lois lowry resume'),
(7, 'William', 'Golding', 'william golding resume'),
(8, 'JD', 'Salinger', 'JD salinger resume'),
(9, 'ML', 'Stedman', 'ML Stedman resume');

select * from bookshop.books;
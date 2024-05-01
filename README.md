# estudioTFG

Mi idea inicial era crear una aplicación web parecida al aula virtual con un chat integrado
parecido al de whatsapp . Me quedó un diagrama entidad relación así.

![AVDiagrama drawio (1)](https://github.com/Rivaillet/estudioTFG/assets/104085995/0becba95-18d7-4a98-bf98-28c17b5dd863)

Pero al empezar a desarrollar las tablas en mySql no conseguía establecer una relación de chats únicos en los usuarios
de tal modo que si se creaba un chat con los ids de los usuarios (1 ,2) no se podía crear un nuevo chat (2,1) que sería
realmente el mismo. Implementé un trigger que comparaba los ids antes de cada insert y lo solucioné.

[scripts.txt](https://github.com/Rivaillet/estudioTFG/files/15092523/scripts.txt)

Pero vi que estaba gastando demasiado tiempo en la funcionalidad del chat , por lo que opté por resideñar la web
enfocándola más en las aulas virtuales y el chat pasa a una funcionalidad opcional.

Rediseñé las tablas y he hecho otro boceto a papel del diagrama entidad relación

![20240421_230052](https://github.com/Rivaillet/estudioTFG/assets/104085995/59e99dc6-a26c-4a8b-835e-afda16f2d8a1)


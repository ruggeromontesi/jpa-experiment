This is a very little project created to discuss about a JPA behaviour I discovered short ago.
Refer to class it.ruggero.jpa.Book, the field title is annotated as not nullable and not updatable.

REST call to create a Book:
curl -X POST  "http://localhost:8080/save" -H "accept: */*"  --header 'Content-Type: application/json'   --data '{"id": 101, "name": "name", "title": "oldTitle"}'

Make the rest call below to check book was properly stored :
curl -X GET  "http://localhost:8080/book/101" -H "accept: */*"  --header 'Content-Type: application/json'


Try to UPDATE the book "wrongly" setting title as null
$ curl -X PUT  "http://localhost:8080/update" -H "accept: */*"  --data '{"id": 101, "name": "newName", "title": null}'


The rest call returns the book with null title, apparently violating constarint set by annotation.


Make the rest call below to check that the field title has not been updated

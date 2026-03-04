hoarau arnaud 


Le point d’entrée est : App.java

Quelles sont les URL à appeler pour utiliser l’API ?

Dans DogController : Base path : @RequestMapping("/dogs")

Endpoints :

GET http://localhost:8080/dogs
➜ retourne la liste des chiens (List<DogDto>)

GET http://localhost:8080/dogs/{id}
➜ retourne un chien par id (DogDto)

POST http://localhost:8080/dogs
Body JSON attendu (exemple) :

{ "id": 1, "name": "Rex", "race": "Berger Allemand" }


➜ crée/sauvegarde et renvoie un DogDto

DELETE http://localhost:8080/dogs/{id}
➜ supprime et renvoie true/false

Pourquoi il n’y a aucun @Autowired ?

Parce que le projet utilise l’injection par constructeur, et Spring n’a pas besoin de @Autowired si la classe n’a qu’un seul constructeur.

Exemples dans le code :

DogController(DogServiceImpl dogService) : injection implicite

DogServiceImpl(DogRepository dogRepository, DogMapper dogMapper) : injection implicite


Où sont les injections de dépendance dans le code ?

Tu peux les “repérer” en listant les constructeurs + les beans Spring :

(A) Dans le Controller

DogController dépend de DogServiceImpl

Bean injecté : DogServiceImpl (car annoté @Service)

(B) Dans le Service

DogServiceImpl dépend de :

DogRepository (bean Spring Data car interface JpaRepository + @Repository)

DogMapper (bean car @Component)

Donc, injections concrètes :

DogController -> DogServiceImpl

DogServiceImpl -> DogRepository

DogServiceImpl -> DogMapper


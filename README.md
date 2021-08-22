## Spring Boot Rest API

**Learning Objectives**

**Rubian Camilo Saenz Rodriguez**
**IETI - 2021-2**

- Explain what needs to be donde to achieve the Level 2 on a  RESTFUL API on the Richardson Maturity Model.
- Implement a Level 2 Users RESTFUL API Microservice.
- Implement a Level 2 Tasks RESTFUL API Microservice.
-  User dependencies injections to create a decoupled architecture.


## Growth Mindset 🤹🏽

"Individuals who believe their talents can be developed (through hard work, good strategies, and input from others) have a growth mindset. They tend to achieve more than those with a more fixed mindset (those who believe their talents are innate gifts)" [What Having a "Growth Mindset" Actually means - Harvard Business Review](https://hbr.org/2016/01/what-having-a-growth-mindset-actually-means)  


**Main Topics**
 * Microservices.
 * RESTFUL API.
 * Richardson Maturity Model.
 * Dependencies Injection.

## Codelab 🧪

🗣️ "I hear and I forget I see and I remember I do and I understand." Confucius

### Part 1: Implementing the Users Microservice RESTFUL API

1. Create a new project using the [Spring Initializr](https://start.spring.io/)
  * Use either *Java* or *Kotlin* as programming language.
  * Use Gradle as project option(if your computer is slow then use  Maven)
  * Add Spring Web dependency before generating the project.

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1/blob/main/images/Spring%20initializr.png?raw=true">

2. Create a new repository on Github and commit the files generated in 1.
3. Create a new package called *dto* and inside define your *UserDto* object with at least the following fields:
    * name.
    * email.
    * lastName.
    * createdAt.
4. Create a new package called *data* and inside define your *User* data object with at least the following fields:
    * id.
    * name.
    * email.
    * lastName.
    * createdAt.
5. Create a new package called *service* an inside create the following interface:

**Java:**
 ```java
     public interface UserService
     {
         User create( User user );

         User findById( String id );
         
         List<User> all();

         void deleteById( String id );

         User update( User user, String userId );
     }
  ```
  **Kotlin:**
  ```kotlin
      interface UserService {

         fun create( user: User): User

         fun findById( String id ): User?
         
         fun  all(): List<User>

         fun deleteById( String id )

         fun update( User user, String userId ): User

      }
  ```
6. Create an implementation of the UserService using a HashMap data structure inside.
7. Make your service implementation *UserServiceHashMap* injectable using the *@Service* annotation.
8. Create a new package called *controller* and create a new class *UserController* inside.
9. Annotate your *UserController* so it becomes a REST Controller:

**Java:**
 ```java
   @RestController
   @RequestMapping( "/v1/user" )
   public class UserController
   {
   }
  ```
  **Kotlin:**
  ```kotlin
   @RestController
   @RequestMapping( "/v1/user" )
   class UserController()
  ```
10. Inject your *UserService* implementation inside the *UserController* via the constructor:

**Java:**
 ```java
   @RestController
   @RequestMapping( "/v1/user" )
   public class UserController
   {
       private final UserService userService;

       public UserController(@Autowired UserService userService )
       {
           this.userService = userService;
       }   
   }
  ```
  **Kotlin:**
  ```kotlin
   @RestController
   @RequestMapping( "/v1/user" )
   class UserController(@Autowired private val userService: UserService)
  ```
11. Implement all the endpoints needed to interact with you *UserService*. Use the following method signatures to help you achieve the Level 2 RESTFUL Maturity:

**Java:**
 ```java
   @RestController
   @RequestMapping( "/v1/user" )
   public class UserController
   {
      private final UserService userService;

      public UserController( UserService userService )
      {
          this.userService = userService;
      }

   
      @GetMapping
      public ResponseEntity<List<User>> all()
      {
          //TODO implement this method using UserService
          return null;
      }
      
      @GetMapping( "/{id}" )
      public ResponseEntity<User> findById( @PathVariable String id )
      {
         //TODO implement this method using UserService
         return null;
      }
      
      
      @PostMapping
      public ResponseEntity<User> create( @RequestBody UserDto userDto )
      {
           //TODO implement this method using UserService
          return null;
      }
      
      @PutMapping( "/{id}" )
      public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id )
      {
           //TODO implement this method using UserService
          return null;
      }

      @DeleteMapping( "/{id}" )
      public ResponseEntity<Boolean> delete( @PathVariable String id )
      {
           //TODO implement this method using UserService
          return null;      
      }
   }      
  ```
  **Kotlin:**
  ```kotlin
   @RestController
   @RequestMapping( "/v1/user" )
   class UserController(@Autowired private val userService: UserService)
   {
      @GetMapping
      fun all(): ResponseEntity<List<User>>
      {
          //TODO implement this method using UserService
          return null
      }
      
      @GetMapping( "/{id}" )
      fun findById( @PathVariable id: String )ResponseEntity<User> 
      {
         //TODO implement this method using UserService
         return null
      }
      
      
      @PostMapping
      fun create( @RequestBody  userDto: UserDto): ResponseEntity<User>
      {
           //TODO implement this method using UserService
          return null
      }
      
      @PutMapping( "/{id}" )
      fun update( @RequestBody userDto: UserDto, @PathVariable id: String): ResponseEntity<User> 
      {
           //TODO implement this method using UserService
          return null
      }

      @DeleteMapping( "/{id}" )
      fun delete( @PathVariable id: String): ResponseEntity<Boolean>
      {
           //TODO implement this method using UserService
          return null     
      }   
   
   
   }
  ```

12. Download and install [Postman](https://www.postman.com/) and test ALL the endpoints of your API.

Primero mediante el metodo GET se observa que de momento esta vacia la lista de usuarios.

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1/blob/main/images/getUser.png?raw=true">

Se verifica el metodo all().

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1/blob/main/images/getAll.png?raw=true">

Se crea un usuario mediante el metodo create al realizar una solicitud POST.

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1/blob/main/images/create.png?raw=true">

Se verifica en la lista de usuarios mediante una solicitud GET.

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1/blob/main/images/getUser-1.png?raw=true">

Se modifica algunos campos del usuario mediante el metodo update utilizando el id del usuario como parametro en la url, gracias a una solicitud PUT.

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1/blob/main/images/update.png?raw=true">

Se verifica en la lista de usuarios que si se hubiera modificado la información del usuario mediante una solicitud GET.

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1/blob/main/images/getUser-1.1.png?raw=true">

 Se elimina el usuario indicando su id en la url dado como parametro mediante el metodo deleteById y ademas gracias a una solicitud delete.

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1/blob/main/images/delete.png?raw=true">

Se verifica que el usuario ha sido eliminado de la lista de usuarios.

<img src="https://github.com/camilosaenz/IETI-LABORATORIO1/blob/main/images/getUser-1.2.png?raw=true">

### Part 2: Implementing the Tasks Microservice RESTFUL API

1. Create a new project using the [Spring Initializr](https://start.spring.io/)
  * Use either *Java* or *Kotlin* as programming language.
  * Use Gradle as project option(if your computer is slow then use  Maven)
  * Add Spring Web dependency before generating the project.
2. Create a new repository on Github and commit the files generated in 1.
3. Create a new package called *dto* and inside define your *TaskDto* object with at least the following fields:
    * name.
    * description.
    * status [TODO, DOING, REVIEW and DONE].
    * assignedTo.
    * dueDate.
    * created.
4. Create a new package called *data* and inside define your *Task* data object with at least the following fields:
    * id.
    * name.
    * description.
    * status [TODO, DOING, REVIEW and DONE].
    * assignedTo.
    * dueDate.
    * created.
5. Create a new package called *service* an inside create the following interface:

**Java:**
 ```java
     public interface TaskService
     {
         Task create( Task task );

         Task findById( String id );
         
         List<Task> all();

         void deleteById( String id );

         Task update( Task task, String id );
     }
  ```
  **Kotlin:**
  ```kotlin
      interface TaskService {

         fun create( task: Task): Task

         fun findById( String id ): Task?
         
         fun  all(): List<Task>

         fun deleteById( String id )

         fun update( Task task, String id ): Task

      }
  ```
6. Create an implementation of the TaskService using a HashMap data structure inside.
7. Make your service implementation *TaskServiceHashMap* injectable using the *@Service* annotation.
8. Implement you *TaskController* (try to avoid copy paste, use the User Microservice as reference but try doing it consciously).
9. Test ALL the endpoints of your API using PostMan or any other tool of your preference.


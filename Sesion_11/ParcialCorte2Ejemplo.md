# Corte 2 - Parcial Sistemas Distribuidos
- Fecha: 09-10-2023
- Hora: 20:20 - 22:00
- Entrega Moodle en el tiempo establecido.

# Backend

## Descripción - crear poryecto con la siguiente estructura:
- Nombre: Corte2PrimerNombrePrimerApellido
- COM: Corhuila
- Dependencias: Spring Boot DevTools, Spring Web, Spring Data JPA, MySQL Driver
- Java: 8, 11, 17(Sugerida)
- Spring Boot: 2.7.16, 3.0.11, 3.1.4(Sugerida)

##  Datos de configuración
- server.port= 
- spring.jpa.hibernate.ddl-auto = 
- spring.datasource.url = jdbc:mysql:
- spring.datasource.username = 
- spring.datasource.password = 

* Nota: Usar puerto 9092 para el servidor y el 3306 para el motor de base de datos.

## Paquetes de aplicación con respectivos archivos (PascalCase):
 - Entity
    - Policy
    - Vehicle
 - IRepository
    - IPolicyRepository
    - IVehicleRepository
 - IService
    - IPolicyService
    - IVehicleService
 - Service
    - PolicyService
    - VehicleService
 - Controller
    - PolicyController
    - VehicleController

# Base de datos 

## Datos de la base de datos
- User: u342060465_corte2
- Base de Datos: u342060465_corte2
- Password = 7tb@?6>kP
- IP = 149.100.155.52

## Necesidadad
### Entidad vehículo con los siguientes campos "vehicle_document_student":
- id: BIGINT (primary key, auto-incremental)
- license_plate: VARCHAR(50)
- make: VARCHAR(50)
- model: VARCHAR(50)
- color: VARCHAR(50)

### Entidad poliza con los siguientes campos "policy_document_student":
- id: BIGINT (primary key, auto-incremental)
- number: VARCHAR(50)
- start_date: DATETIME
- end_date: DATETIME
- value: DECIMAL(10,2)
- vehicle_id: BIGINT (foreign key)

# API

## Datos de la API
- api/policy
- api/vehicle
- Body: raw, JSON
- Métodos: 
    - GET: FindAll, FindById
    - POST: Save 
    - PUT: Update
    - DELETE: DeleteById

## Documentación de la API

### Colección: policy
* Carpeta: policy
    * GET: FindAll
    * GET: FindById
    * POST: Save
    * PUT: Update
    * DELETE: DeleteById

### Colección: vehicle
* Carpeta: vehicle
    * GET: FindAll
    * GET: FindById
    * POST: Save
    * PUT: Update
    * DELETE: DeleteById

### Ejemplo de body
* Si los atributos de "Departamento" son code y name, de la api api/estate debe ser: 
    ```json
    {
        "code": "12",
        "name": "Huila"
    }
    ```
* Si los atrubitos de "City" son code, name y estateId, de la api api/city, el body debe ser:
    ```json
    {
        "code": "121",
        "name": "Neiva",
        "estateId": {
            "id": 1
        }
    }
    ``` 

# Entrgar 

## Bacnkend: Codigo fuente
## Base de datos: Script de creación de la base de datos
## Documentación: Documentación de la API con postman (archivo json)

# Ejemplo de código

## Entity
```java
@Entity
@Table(name="materia_estudiante")
public class MateriaEstudiante {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "materia", length = 50)
	private String materia;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "estudiante_id", nullable = false, unique = true)
    public Estudiante estudianteId;

	// Encapsulamiento
	
} 
```

## IRepository
```java
    @Repository
    public interface IMateriaEstudianteRepository extends JpaRepository<MateriaEstudiante, Long>{

    }
```

## IService
```java
    public interface IMateriaEstudianteService {
        List<MateriaEstudiante> all();        
        public Optional<MateriaEstudiante> findById(Long id);        
        public MateriaEstudiante save(MateriaEstudiante materiaEstudiante);        
        public void update(MateriaEstudiante materiaEstudiante, Long id);        
        public void delete(Long id);
    }
```

## Servic
```java
    @Service
    public class MateriaEstudianteService implements IMateriaEstudianteService {

        @Autowired
        private IMateriaEstudianteRepository iMateriaEstudianteRepository;
        
        @Override
        public List<MateriaEstudiante> all() {
            return iMateriaEstudianteRepository.findAll();
        }

        @Override
        public Optional<MateriaEstudiante> findById(Long id) {
            return iMateriaEstudianteRepository.findById(id);
        }

        @Override
        public MateriaEstudiante save(MateriaEstudiante materiaEstudiante) {
            return iMateriaEstudianteRepository.save(materiaEstudiante);
        }

        @Override
        public void update(MateriaEstudiante materiaEstudiante, Long id) {
            //validar si existe.            
            Optional<MateriaEstudiante> op = iMateriaEstudianteRepository.findById(id);

            if(op.isEmpty()){
                System.out.println("Dato no encontrado");
            }else{
                //Crear nuevo objeto que va a contener los datos que se van actualizar
                MateriaEstudiante materiaEstudianteUpdate = op.get();
                materiaEstudianteUpdate.setMateria(materiaEstudiante.getMateria());
                materiaEstudianteUpdate.setEstudianteId(materiaEstudiante.getEstudianteId());
                
                //Actualizar el objeto
                iMateriaEstudianteRepository.save(materiaEstudianteUpdate);
            }            
        }

        @Override
        public void delete(Long id) {
            iMateriaEstudianteRepository.deleteById(id);
        }
    }
```	

## Controller
```java
    @CrossOrigin(origins = "*")
    @RestController
    @RequestMapping("v1/api/MateriaEstudiante")
    public class MateriaEstudianteController {

        @Autowired
        private IMateriaEstudianteService service;
        
        @GetMapping()
        public List<MateriaEstudiante> all() {
            return service.all();
        }
        
        @GetMapping("{id}")
        public Optional<MateriaEstudiante> show(@PathVariable Long id) {
            return service.findById(id);
        }
        
        @PostMapping
        @ResponseStatus(code = HttpStatus.CREATED)
        public MateriaEstudiante save(@RequestBody MateriaEstudiante materiaEstudiante) {
            return service.save(materiaEstudiante);
        }
        
        @PutMapping("{id}")
        @ResponseStatus(code = HttpStatus.NO_CONTENT)
        public void update(@RequestBody MateriaEstudiante materiaEstudiante, @PathVariable Long id) {
            service.update(materiaEstudiante, id);
        }
        
        @DeleteMapping("{id}")
        @ResponseStatus(code = HttpStatus.NO_CONTENT)
        public void delete(@PathVariable Long id) {
            service.delete(id);
        }
        
    }
```


### Muchos exitos en el desarrollo de la prueba.




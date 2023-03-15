package com.gestion.empleado.Controller;
import com.gestion.empleado.Entity.Empleado;
import com.gestion.empleado.Repository.IEmpleado;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = {"http://localhost:4200/","https://portfoliofacianofa.web.app/","https://portfoliofacianofa.web.app"})
public class EmpleadoController {
    @Autowired
    IEmpleado iEmpleado;
    
    //Ver El Listado
    @GetMapping("empleados")
    public List<Empleado> list(){
        return iEmpleado.findAll();
    }
    
    //traer Elemento
    @GetMapping("empleado/{id}")
    public ResponseEntity<Empleado>getById(@PathVariable("id")Long id){ 
        Empleado empleado=iEmpleado.findById(id).orElseThrow();     
         
    return new ResponseEntity(empleado,HttpStatus.OK);   
    }
    
    
    //Guardar Elemento
    @PostMapping("empleado")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado){
        return iEmpleado.save(empleado);
    }
    
    
    //Borrar Elemento
    @DeleteMapping("empleado/{id}")
    public ResponseEntity<?>delete(@PathVariable("id")long id){
        if(!iEmpleado.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.NOT_FOUND);
        }
            iEmpleado.deleteById(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"),HttpStatus.OK);  }
    
    
    //Editar
    @PutMapping("editar/{id}")
    public ResponseEntity<Empleado>encontrarEmpleado(@PathVariable("id")Long id,@RequestBody Empleado empleados){ 
        Empleado empleado=iEmpleado.findById(id).orElseThrow();     
        empleado.setNombre(empleados.getNombre());
        empleado.setApellido(empleados.getApellido());
        empleado.setCargo(empleados.getCargo());
        empleado.setEmail(empleados.getEmail());
        iEmpleado.save(empleado);
    return new ResponseEntity(empleado,HttpStatus.OK);   
    }
}
    
package com.gestion.empleado.Repository;

import com.gestion.empleado.Entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IEmpleado extends JpaRepository<Empleado, Long> {

}

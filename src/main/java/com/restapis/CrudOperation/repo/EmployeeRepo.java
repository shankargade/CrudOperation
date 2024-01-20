package com.restapis.CrudOperation.repo;

import com.restapis.CrudOperation.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from employee where name like :#{#empName}%", nativeQuery = true)
    List<Optional<Employee>> findByName(@Param("empName") String empName);

    @Query(value = "select * from employee where city like :#{#empCity}%", nativeQuery = true)
   List <Optional<Employee>> findByCity(@Param("empCity") String empCity);

    @Query(value = "select * from employee where mob_no like :#{#mob_no}%",nativeQuery = true)
    List<Optional<Employee>> findByMobNo(@Param("mob_no") String mob_no);


    @Query(value = "select * from employee ORDER BY salray",nativeQuery = true)
    List<Optional<Employee>> orderBysalary();
    // We can write any number of methods
}

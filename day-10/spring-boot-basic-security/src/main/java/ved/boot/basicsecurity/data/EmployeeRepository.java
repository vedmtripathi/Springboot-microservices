package ved.boot.basicsecurity.data;

import org.springframework.data.jpa.repository.JpaRepository;

import ved.boot.basicsecurity.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

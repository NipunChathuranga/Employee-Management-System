import Axios from "axios";

const EMPLOYEE_API_BASE_URL = "http://localhost:8080/api/v1/employees";

class EmployeeService {
  getEmloyees() {
    return Axios.get(EMPLOYEE_API_BASE_URL);
  }

  createEmployee(emp){
    return Axios.post(EMPLOYEE_API_BASE_URL,emp);
  }
  
  getEmployeeByID(employeeID){
    return Axios.get(EMPLOYEE_API_BASE_URL + '/' + employeeID);
  }

  updateEmployee(employee,employeeId){
    return Axios.put(EMPLOYEE_API_BASE_URL +'/'+employeeId,employee);
  }

  deleteEmployee(employeeId){
    return Axios.delete(EMPLOYEE_API_BASE_URL+'/'+employeeId);
  }
  





}

export default new EmployeeService();
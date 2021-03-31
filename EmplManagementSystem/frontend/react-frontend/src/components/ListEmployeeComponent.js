import React, { Component } from "react";
import EmployeeService from "../services/EmployeeService";

//For the future reference
// constructor(props) {
//     super(props)

//     this.state = {

//     }

//   }

class ListEmployeeComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      employees: [],
    };
    this.addEmployee = this.addEmployee.bind(this);
    this.editEmployee = this.editEmployee.bind(this);
    this.deleteEmployee = this.deleteEmployee.bind(this);
  }

  componentDidMount() {
    EmployeeService.getEmloyees().then((response) => {
      this.setState({ employees: response.data });
      
    });
  }

  deleteEmployee(id){
      EmployeeService.deleteEmployee(id).then((res)=>{
        this.setState({employees:this.state.employees.filter(
          employee => employee.empID !== id
        )})
      });
  }






  addEmployee(){
    this.props.history.push('/add-employee');
  }

  editEmployee(id){
    this.props.history.push(`/update-employee/${id}`);
  }


  render() {
    return (
      <div>
        <h2 className="text-center">Employee List</h2>
        <div className="row">
            <button className="btn btn-primary" onClick={this.addEmployee}>Add Employee</button>
        </div>
        <div className="row">
          <table className="table table-striped table-bordered">
            <thead>
              <tr>
                <th>Employee First Name</th>
                <th>Employee Last Name</th>
                <th>Employee Email</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {this.state.employees.map((employee) => (
                
                <tr key={employee.empID}>
                  <td>{employee.fname}</td>
                  <td>{employee.lname}</td>
                  <td>{employee.email}</td>
                  <td>
                    <button onClick={()=>this.editEmployee(employee.empID)} className="btn btn-info">Update</button>
                    <button style={{marginLeft:"10px"}} onClick={()=>this.deleteEmployee(employee.empID)} className="btn btn-danger">Delete</button>
                  </td>
                </tr>
              ))
              
             

              }
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default ListEmployeeComponent;

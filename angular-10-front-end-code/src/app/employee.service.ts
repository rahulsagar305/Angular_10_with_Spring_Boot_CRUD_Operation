import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL ="http://localhost:9090/api/1.0/employees";

  constructor( private httpclient:HttpClient) { }

  getEmployessList ():Observable<Employee[]>{
    return this.httpclient.get<Employee[]>(`${this.baseURL}`)
  }

  createEmployee(employee:Employee):Observable<object>{
    return this.httpclient.post(`${this.baseURL}`,employee)
  }

  getEmployeeById(id : number):Observable<Employee>{
    return this.httpclient.get<Employee>(`${this.baseURL}/${id}`)
  }

  updateEmployee(id : number,employee : Employee):Observable<object>{
    return this.httpclient.put(`${this.baseURL}/${id}`,employee)
  }

  deleteEmployee(id : number):Observable<object>{
    return this.httpclient.delete(`${this.baseURL}/${id}`)
  }
  
}

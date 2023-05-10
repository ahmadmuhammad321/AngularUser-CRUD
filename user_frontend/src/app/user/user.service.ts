import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './user';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = "http://localhost:8080/user/all";
  private deleteurl = "http://localhost:8080/user/delete/";
  private addurl = "http://localhost:8080/user/add";
  private editurl = "http://localhost:8080/user/edit/";


  constructor(private http: HttpClient) { }
  getUsers(): Observable<User[]>{
    return this.http.get<User[]>(`${this.baseUrl}`);
  }
  deleteuser(id: number): void {
    
  id.toString;
   
  this.deleteurl = this.deleteurl+id;
  console.log(this.deleteurl);
    this.http.delete(this.deleteurl).subscribe(() => this.getUsers());
   
  }
 

  adduser(data: any, id?: number): void {
    id?.toString;
    if(id==null){
      this.http.post<any>(this.addurl,data).subscribe(() => this.getUsers());
    }
    else{
      this.http.put<any>(this.editurl+id,data).subscribe(() => this.getUsers());
    }
    
  }
  deleteall(){
    this.http.delete("http://localhost:8080/user/delete/all").subscribe(() => this.getUsers());
  }
}

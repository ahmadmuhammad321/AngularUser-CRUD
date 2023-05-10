import { Component, OnInit, ViewChild } from '@angular/core';
import {UserService} from '../user.service'
import { User } from '../user';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  users!: User[];
  ID?: number;
  @ViewChild('regForm') form?: NgForm;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getUsers().subscribe((data: User[]) => {
      console.log(data)
      this.users = data;
      console.log(this.users);
      
    });
  }
  deleteuser(id: number): void{

    this.userService.deleteuser(id);
    console.log(id);
    this.ngOnInit();
    window.location.reload();
    

  }
  edituser(id: number,fname: string, lname: string, email: string): void{

    
    this.form?.setValue({
      first_NAME: fname,
      last_NAME: lname,
      email: email,
    });

    this.ID=id;
    
    
  }

  Register(regForm?:NgForm, ){  
    console.log(regForm); 
      this.userService.adduser(regForm?.value,this.ID);
    this.ngOnInit();
    window.location.reload();

  }  

  deleteall(){
    this.userService.deleteall();
    this.ngOnInit();
    window.location.reload();
  }

  
}


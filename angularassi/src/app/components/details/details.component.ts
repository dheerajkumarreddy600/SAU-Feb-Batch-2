import { Component, OnInit } from '@angular/core';
import { Student } from './students';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  registrationForm: FormGroup;
  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.registrationForm = this.fb.group({
      firstName: ['', [Validators.required]],
        lastName: ['', [Validators.required]],
        contact: ['', [Validators.required, Validators.maxLength(10)]],
        dob: ['', [Validators.required]],
        city: ['', [Validators.required]],
        pin: ['', [Validators.minLength(6)]]
      }
    );
  }
  get firstName() {
    return this.registrationForm.get('firstName');
  }

  get dob() {
    return this.registrationForm.get('dob');
  }

  get lastName() {
    return this.registrationForm.get('lastName');
  }
  get contact() {
    return this.registrationForm.get('contact');
  }
  get city() {
    return this.registrationForm.get('city');
  }
  get pin() {
    return this.registrationForm.get('pin');
  }
  public users : Student[] = [];


  onsubmit() {
    let result = this.registrationForm.value;
    const record : Student = {
      firstname : result.firstName,
      lastname : result.lastName,
      contact : result.contact, 
      dob : result.dob,
      city : result.city,
      pin : result.pin
    };

    this.users.push(record);
  
    sessionStorage.setItem('Users', JSON.stringify(this.users));
    console.log(typeof(this.users));
  }
  public flag = 1;
  public arrow = "";
  

 public sorttable(column:string) {
    
    if (this.flag == 1)
    {  this.users = this.users.sort((x:Student, y: Student) => {
        if (x[column] < y[column]) {
          return -1;
        }
        if (x[column] > y[column]) {
          return 1;
        }
        return 0;
      });
      this.flag = 0;
      this.arrow = "↑";
      
    }
    else {
      this.users = this.users.sort((x:Student, y: Student) => {
        if (x[column] > y[column]) {
          return -1;
        }
        if (x[column] < y[column]) {
          return 1;
        }
        return 0;
      });
      
      this.flag = 1;
      this.arrow = "↓";
      
    }
    
    sessionStorage.setItem('Users', JSON.stringify(this.users));
    console.log(this.users);
  }
  delete(firstname:string) {
    this.users = this.users.filter(item => item.firstname != firstname);
    sessionStorage.setItem('Users', JSON.stringify(this.users));
    alert("row deleted");
}
displaytable() {
  if (this.users.length > 0) {
    return true;
  }
  return false;
}



}

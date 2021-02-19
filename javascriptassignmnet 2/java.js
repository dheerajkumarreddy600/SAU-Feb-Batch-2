var firstname=document.getElementById("name1");
var Lastname=document.getElementById("name2");
var Age=document.getElementById("age");
var g1=document.getElementById("male").value;
var g2=document.getElementById("female").value;
var roll=document.getElementById("roll");
var dob=document.getElementById("date");
var gender;
var email=document.getElementById("email");
if(g1=="yes"){
   gender="Male";
}
else{
   gender="Female";
}

function Details (firstname,Lastname,Age,roll,dob,gender) {
    
    this.firstname=firstname;
    this.Lastname=Lastname;
    this.Age=Age;
    
    this.roll=roll;
    this.dob=dob;
    this.gender=gender;
}
 
email.onblur =function(){
    var xy=email.value;
    if (/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/.test(xy)){
        document.getElementById("er").innerHTML="valid";
    }
        else
        {
            document.getElementById("er").innerHTML="Invalid";
            email.focus();
            email.select();
    }
    
}
roll.onblur = function () {
    var i; var counter = 0;
    for (i = 0; i < localStorage.length; i++) {
        if (localStorage.key(i) == roll.value) {
            document.getElementById("rollno").innerHTML = "user exist";
            roll.focus();
            roll.select();
            counter = 1;
        }
        else{
            break;
        }
    }
    if (counter == 0)
        document.getElementById("rollno").innerHTML = "stored in memory";
        
      
}

function validate(){
    
         
         let obj1= new Details(firstname.value,Lastname.value, Age.value,roll.value,dob.value,gender);
         localStorage.setItem(roll.value, JSON.stringify(obj1));
     

     }
 
  
 function getdet()
{
    var rwe=document.getElementById("rool").value;
    
    document.getElementById("disp").innerHTML=localStorage.getItem(rwe);
}
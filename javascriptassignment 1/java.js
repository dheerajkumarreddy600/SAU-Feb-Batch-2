function getlen(){
    let x=document.getElementById("txt1").value;
    
    document.getElementById("len").innerHTML=x.length;
}
function toup(){
    let x=document.getElementById("txt1").value;
    let a=x.toLowerCase();
    let b=x.toUpperCase();
    document.getElementById("up").innerHTML=b;
    document.getElementById("lo").innerHTML=a;
}
function vc() {
    let s=document.getElementById("txt1").value;
    const vowels = 'aeiou';
    var consonants = [];
    var ovels=[];
    for (var i = 0; i < s.length; i++) {
    if (vowels.includes(s[i])) {
    ovels+=s[i]+'\n';
    } else {
    consonants += s[i] + '\n';
    }
    }
    document.getElementById("ov").innerHTML=ovels;
    document.getElementById("con").innerHTML=consonants;
}
function alle(){
let str=document.getElementById("txt1").value;
var reg = /\d/;   
var y=reg.test(str);
if(y&&true) 
  
{ 
    document.getElementById("te").innerHTML = "the given string contains numbers";
    alert("enter valid string");
} 
else
{ 
    document.getElementById("te").innerHTML = "the given string doesnot    contains numbers";
}
}
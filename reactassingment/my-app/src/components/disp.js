import React from 'react';
import books from './details' ;
import {useParams} from 'react-router-dom';

function Disp(){
    let {id} =useParams();
    const book = books.filter((book)=>
         book.id==parseInt(id,10))[0]
         
    
    return(
      <div >
          <h2>Details of {book.name}</h2>
        
          <h4>Authorname:{book.author}</h4>
          <h4>Book Cost:{book.cost}</h4>
          <h4>Discription:{book.dis}</h4>

      </div>
    )
}
export default Disp;

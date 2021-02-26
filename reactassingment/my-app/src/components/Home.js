import React from 'react';
import books from './details' ;
import {Link} from'react-router-dom';

class Home extends React.Component{
  constructor(){
    super();
   this.state={
      books:books
    }
  }
  render(){
    let b=this.state.books.map((book)=>
      {
        return(
          <div><h3 key={book.id}>
            <Link to={`/home/${book.id}`} >{book.name}</Link></h3>
          </div>
        );
      });
      return (
        <div>{b}</div>
      );
  }
}
export default Home;

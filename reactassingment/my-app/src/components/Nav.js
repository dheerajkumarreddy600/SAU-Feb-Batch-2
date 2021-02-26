import React from 'react';
import {Link} from'react-router-dom';


function Nav() {
    const texst = {
        color:"white"
        
    }
    const st = {
        color:"yellow"
        
    }
  return (
    <nav >
        <Link  style={st} to='/'><h2>BookStore</h2></Link>
           
        <ul className="nav-links">
            <Link style={texst} to='/home'>
            <li><h2>Books</h2></li>
            </Link >
            

            

        </ul>
    </nav>  );

}
export default Nav;
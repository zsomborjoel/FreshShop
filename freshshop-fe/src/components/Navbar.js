import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import logo from '../logo.svg';
import { ButtonCartContainer, ButtonProductContainer } from './Button';

class Navbar extends Component {
    render() {
        return (
            <nav className="navbar navbar-expand-sm bg-primary bg-dark px-sm-5">
                <Link to='/'>
                    <img src={logo} alt="store" className="navbar-brand"/>
                </Link>
                <ul className="ul.navbar-nav.align-items-center">
                    <li className="nav-item active ml-5">
                    <Link to='/'>
                    <ButtonProductContainer>
                        products
                    </ButtonProductContainer>
                    </Link>
                    </li>
                </ul>
                <Link to="/cart" className="ml-auto">
                    <ButtonCartContainer>
                        <span className="mr-2">
                            <i className="fas fa-cart-plus" />
                        </span>
                        my cart
                    </ButtonCartContainer>
                </Link>
            </nav>
        );
    }
}


export default Navbar;
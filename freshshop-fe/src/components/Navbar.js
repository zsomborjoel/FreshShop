import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import logo from '../logo.svg';
import { ButtonCartContainer, DefaultNavButtonContainer } from './Button';

class Navbar extends Component {
    render() {
        return (
            <nav class="navbar navbar-expand-md navbar-dark bg-dark">
                <div class="collapse navbar-collapse">
                    <Link to='/'>
                    <img src={logo} alt="store" className="navbar-brand"/>
                    </Link>
                    <ul class="navbar-nav mr-auto">
                        <li className="nav-item ml-5">
                            <Link to='/'>
                                <DefaultNavButtonContainer>
                                    products
                                </DefaultNavButtonContainer>
                            </Link>
                        </li>
                        <li className="nav-item ml-5">
                            <Link to='/info'>
                                <DefaultNavButtonContainer>
                                    info
                                </DefaultNavButtonContainer>
                            </Link>
                        </li>
                    </ul>
                        <Link to="/login" className="mr-5">
                            <DefaultNavButtonContainer>
                            login
                            </DefaultNavButtonContainer>
                        </Link>
                        <Link to="/login" className="mr-5">
                            <DefaultNavButtonContainer>
                            sign up
                            </DefaultNavButtonContainer>
                        </Link>
                        <Link to="/cart">
                            <ButtonCartContainer>
                                <span className="mr-2">
                                    <i className="fas fa-cart-plus" />
                                </span>
                                my cart
                            </ButtonCartContainer>
                        </Link>
                </div>
            </nav>  
        );
    }
}


export default Navbar;
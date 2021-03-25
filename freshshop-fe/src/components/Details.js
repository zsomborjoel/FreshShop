import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { ProductConsumer } from '../context';
import { ButtonCartContainer } from './Button';

class Details extends Component {
    render() {
        return (
            <ProductConsumer>
                {value => {
                    const {id, company, img, info, price, title, inCart} = value.detailProduct;
                    return (
                        <div className = "container py-5">
                            {/* begin title */}
                            <div className = "row">
                                <div className = "col-10 mx-auto text-center text-slanted text-blue my-5">
                                    <h1>{title}</h1>
                                </div>
                            </div>
                            {/* end title */}
                            {/* product info */}
                            <div className="row">
                                <div className="col-10 mx-auto col-md-6 my-3 text-capitalize">
                                    <div>
                                        <img src={img} className="img-fluid" alt="product"/>
                                    </div>
                                </div>
                                {/* product text */}
                                <div className="col-10 mx-auto col-md-6 my-3 text-capitalize">
                                    <h1>Product : {title}</h1>
                                    <h4 className="text-title text-uppercase text-muted mt-3 mb-2">
                                        made by: <span className="text-lowercase">
                                        {company}
                                        </span>
                                    </h4>
                                    <h4 className="text-blue">
                                        <strong>
                                            price: <span>$</span>
                                            {price}
                                        </strong>
                                    </h4>
                                    <p className="text-capitalize font-weight-bold mt-3 mb-0">
                                        some info about product:
                                    </p>
                                    <p className="text-muted lead">{info}</p>
                                    {/* buttons */}
                                    <div>
                                        <Link to="/">
                                            <ButtonCartContainer 
                                                cart
                                                disabled={inCart ? true : false}
                                                onClick={()=>(
                                                    value.addToCart(id)
                                                )}
                                            >
                                                {inCart ? "inCart" : "add to cart"}
                                            </ButtonCartContainer>
                                        </Link>
                                    </div>
                                </div>
                            </div>
                        </div>
                    )
                }}
            </ProductConsumer>
        );
    }
}

export default Details; 
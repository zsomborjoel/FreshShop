import React, { Component } from 'react';
import Product from './Product'
import Title from './Title'

class ProductList extends Component {
    render() {
        return (
            <React.Fragment>
                <div className="py-5">
                    <div className="container">
                        <div className="row">
                            <Title name="our" title="products" />
                        </div>
                    </div>
                </div>
            </React.Fragment>
        );
    }
}

export default ProductList;
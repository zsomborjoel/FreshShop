import React, { Component } from 'react'
import { storeProducts, detailProduct } from './data'

// React context api
const ProductContext = React.createContext();
// Provider
// Consumer

class ProductProvider extends Component {
    state = {
        products: [],
        detailProduct: detailProduct
    };
    componentDidMount() {
        // copies of values not referencing
        // change values assigned to object
        this.setProducts()
    }
    setProducts = () => {
        let tempProducts = [];
        storeProducts.forEach(item => {
            const singleItem = {...item};
            tempProducts = [...tempProducts,singleItem];

        })
        this.setState(() => {
            return { products: tempProducts }
        })
    }
    getItem = (id) => {
        return this.state.products.find(item => item.id === id);
    }
    handleDetail = () => {
        const product = this.getItem();
        this.setState(() => {
            return {detailProduct:product}
        })
        console.log('Hello from detail');
    }
    addToCart = (id) => {
        console.log(`Hello from add to cart.id is ${id}}`);
    }
    render() {
        return (
            <ProductContext.Provider value={{
                ...this.state,
                handleDetail: this.handleDetail,
                addToCart: this.addToCart
            }}>
                {this.props.children}            
            </ProductContext.Provider>
        )
    }
}

const ProductConsumer = ProductContext.Consumer;

export { ProductProvider, ProductConsumer };
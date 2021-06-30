import * as BT from "./productTypes";
import axios from "axios";

export const fetchProduct = (productId) => {
  return (dispatch) => {
    dispatch({
      type: BT.FETCH_PRODUCT_REQUEST,
    });
    axios
      .get("http://localhost:8081/v1/product/" + productId)
      .then((response) => {
        dispatch(productSuccess(response.data));
      })
      .catch((error) => {
        dispatch(productFailure(error));
      });
  };
};


const productSuccess = (book) => {
    return {
      type: BT.PRODUCT_SUCCESS,
      payload: book,
    };
  };
  
  const productFailure = (error) => {
    return {
      type: BT.PRODUCT_FAILURE,
      payload: error,
    };
  };
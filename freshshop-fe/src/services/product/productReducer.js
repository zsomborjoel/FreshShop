import * as BT from "./productTypes";

const initialState = {
  product: "",
  error: "",
};

const reducer = (action, state = initialState) => {
  switch (action.type) {
    case BT.SAVE_PRODUCT_REQUEST:
    case BT.FETCH_PRODUCT_REQUEST:
    case BT.UPDATE_PRODUCT_REQUEST:
    case BT.DELETE_PRODUCT_REQUEST:
    case BT.FETCH_LANGUAGES_REQUEST:
    case BT.FETCH_GENRES_REQUEST:
      return {
        ...state,
      };
    case BT.PRODUCT_SUCCESS:
      return {
        product: action.payload,
        error: "",
      };
    case BT.PRODUCT_FAILURE:
      return {
        product: "",
        error: action.payload,
      };
    default:
      return state;
  }
};

export default reducer;

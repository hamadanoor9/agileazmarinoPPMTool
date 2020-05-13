import {
  createStor,
  applyMiddleware,
  compse,
  createStore,
  compose
} from "redux";
import thunk from "redux-thunk";
import rootReducer from "./reducers";

const initialState = {};

const middleware = [thunk];

let store;

if (window.navigator.userAgent.includes("Chrome")) {
  const composeEnhancer =
    window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
  store = createStore(
    rootReducer,
    initialState,
    composeEnhancer(applyMiddleware(...middleware))
  );
} else {
  store = createStore(
    rootReducer,
    initialState,
    compose(applyMiddleware(...middleware))
  );
}

export default store;

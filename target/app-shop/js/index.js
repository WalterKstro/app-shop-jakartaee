import {updateCart} from "./exports.js";

(()=>{

    const url = document.URL;
    const path = url.split('/').at(-1);

    if (path == 'me') {updateCart()}

})()
import axios from 'axios';

const PRODUCT_REST_API_URL = 'http://localhost:8080/api/product';

class ProductrService {
    getProducts() {
        return axios.get(PRODUCT_REST_API_URL + "/getAll");
    }

    findById(id) {
        return axios.get(PRODUCT_REST_API_URL + "/findById/" + id);
    }

    findByName(name) {
        return axios.get(PRODUCT_REST_API_URL + "/findByName/" + name);
    }

    getId(name) {
        return axios.get(PRODUCT_REST_API_URL + "/getId/" + name);
    }
}

export default new ProductrService();
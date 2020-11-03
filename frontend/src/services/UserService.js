import axios from 'axios';

const USER_REST_API_URL = 'http://localhost:8080/api/user';

class UserService {
    getUsers() {
        return axios.get(USER_REST_API_URL + "/getAll");
    }

    findById(id) {
        return axios.get(USER_REST_API_URL + "/findById/" + id);
    }

    findByUser(user) {
        return axios.get(USER_REST_API_URL + "/findByUser/" + user);
    }

    findByEmail(email) {
        return axios.get(USER_REST_API_URL + "/findByEmail/" + email);
    }

    getId(user) {
        return axios.get(USER_REST_API_URL + "/getId/" + user);
    }

    login(user, password) {
        return axios.get(USER_REST_API_URL + "/login/" + user + "/" + password);
    }
}

export default new UserService();
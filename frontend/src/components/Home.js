import React from 'react';
import UserService from '../services/UserService';
import { LoadCookie } from '../services/Cookie'

class Home extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            user: ''
        }
    }

    componentWillMount() {
        UserService.findById(LoadCookie("id")).then(response => (this.info = response.data))
            .catch(error => console.log(error))
            .finally(() => {
                this.setState({
                    user: this.info
                });
            })
        do {

        } while (this.state.user === undefined);
    }

    render() {
        return (
            <div>
                {
                    this.state.user.email
                }
            </div>
        );
    }
}

export default Home;
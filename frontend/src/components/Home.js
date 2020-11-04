import React from 'react';
import UserService from '../services/UserService';
import RaisedButton from 'material-ui/RaisedButton';
import { MuiThemeProvider } from 'material-ui/styles';
import { SaveCookie, LoadCookie } from '../services/Cookie';

class Home extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            user: ''
        }
    }

    componentWillMount() {
        let id = LoadCookie("id");
        UserService.findById(id).then(response => (this.info = response.data))
            .catch(error => console.log(error))
            .finally(() => {
                this.setState({
                    user: this.info
                });
                SaveCookie("id", id); //Recarga la cookie una hora mas
            })
        do {

        } while (this.state.user === undefined);
    }

    render() {
        if (this.state.user === undefined) {
            return (
                <div>
                    <MuiThemeProvider>
                        <RaisedButton label="login" primary={true} style={{ margin: 15 }} onClick={() => { window.location = "/login" }} />
                    </MuiThemeProvider>
                </div>
            );
        } else {
            return (
                <div>
                    {
                        this.state.user.email
                    }
                </div>
            );
        }
    }
}

export default Home;
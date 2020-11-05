import React from 'react';
import TextField from 'material-ui/TextField';
import RaisedButton from 'material-ui/RaisedButton'
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import UserService from '../services/UserService';
import { SaveCookie } from '../services/Cookie'

class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            user: '',
            password: ''
        }
    }

    login = () => {
        this.info = false;
        UserService.login(this.state.user, this.state.password)
            .then(response => (this.info = response.data))
            .catch(error => console.log(error))
            .finally(() => {
                if ("" + this.info === "true") {
                    UserService.getId(this.state.user)
                        .then(response => (this.info = response.data))
                        .catch(error => console.log(error))
                        .finally(() => {
                            SaveCookie("id", this.info);
                            window.location = "/";
                        });
                } else if ("" + this.info === "false") {
                    window.location = "/login";
                }
                else if ("" + this.info === "error") {
                    alert("No se pudo enviar la autenticacion de 2 pasos.");
                } else {
                    this.codeAuth(3, "" + this.info);
                }
            });
    }

    codeAuth = (oportunities, key) => {
        do {
            let code = prompt('Enter the code sent to your email: ');
            if (code === key) {
                oportunities = 0;
                UserService.getId(this.state.user)
                    .then(response => (this.info = response.data))
                    .catch(error => console.log(error))
                    .finally(() => {
                        SaveCookie("id", this.info);
                        window.location = "/";
                    });
            } else {
                if (code === null) {
                    //repite sin mas
                } else {
                    oportunities--;
                }
            }
        } while (oportunities > 0); //evita que al cambiar de pagina se cierre
    }

    render() {
        return (
            <div style={{
                height: "100vh",
                width: "100%",
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
                background: "#95CFED",
            }}>
                <div style={{
                    height: 260,
                    width: 400,
                    border: '1px solid black',
                    display: "block",
                    alignItems: "center",
                    justifyContent: "center",
                    background: "#ffffff",
                    paddingBottom: "25px",
                }}>
                    <MuiThemeProvider>
                        <TextField
                            hintText="Enter your User"
                            floatingLabelText="User"
                            onChange={(event, newValue) => this.setState({ user: newValue })} />
                        <br />
                        <br />
                        <TextField
                            type="password"
                            hintText="Enter your Password"
                            floatingLabelText="Password"
                            onChange={(event, newValue) => this.setState({ password: newValue })} />
                        <br />
                        <br />
                        <a style={{
                            color: "#0000ff",
                            fontSize: 15,
                            textDecoration: "none"
                        }}
                            href="/register">Create Account</a>
                        <br />
                        <div style={{
                            float: "right",
                        }}>
                            <RaisedButton label="login" primary={true} style={{ margin: 15 }} onClick={() => this.login()} />
                        </div>
                    </MuiThemeProvider>
                </div>
            </div>
        );
    }
}

export default Login;
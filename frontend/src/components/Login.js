import React from 'react';
import TextField from '@material-ui/core/TextField'
import Button from '@material-ui/core/Button'

class Login extends React.Component {
    constructor(props) {
        super(props);
    }

    login = () => {
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
                    height: 230,
                    width: 400,
                    border: '1px solid black',
                    display: "block",
                    alignItems: "center",
                    justifyContent: "center",
                    background: "#ffffff",
                    paddingTop: "50px",
                }}>
                    <TextField id="outlined-basic" label="User" variant="outlined"/>
                    <br /><br />
                    <TextField id="filled-password-input" label="Password" type="password" autoComplete="current-password" variant="outlined" />
                    <div style={{
                        width: 300,
                        marginTop: "10px",
                        float: "right",
                    }}>
                        <Button variant="contained" color="primary" onClick={() => this.login()}>
                            Login
                        </Button>
                    </div>
                </div>
            </div>
        );
    }
}

export default Login;
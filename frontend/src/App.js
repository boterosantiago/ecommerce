import React from 'react';
import './App.css';
import UserComponent from './components/UserComponent'
import Login from './components/Login'
import Home from './components/Home'
import NotFound from './components/NotFound';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import AppBar from 'material-ui/AppBar';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import UserService from './services/UserService';
import RaisedButton from 'material-ui/RaisedButton';
import { SaveCookie, LoadCookie, DeleteCookie } from './services/Cookie';
import { icCart, icUser, icHome } from './assets/Icons';

class App extends React.Component {

  home = () => <Home />

  login = () => <Login />
  register = () => <UserComponent />
  notFound = ({ location }) => <NotFound />

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

    } while (this.state.user === undefined); //espera que lea el usuario
  }

  _loginButton = () => {
    if (this.state.user === undefined) {
      return (
        <div>
          <MuiThemeProvider>
            <RaisedButton label="login" primary={true} style={{ margin: 15 }} onClick={() => { window.location = "/login" }} icon={icUser} />
          </MuiThemeProvider>
        </div>
      );
    } else {
      return (
        <div>
          <MuiThemeProvider>
            <RaisedButton label="logout" primary={true} style={{ margin: 15 }} onClick={() => { DeleteCookie("id"); window.location = "/login" }} icon={icUser} />
            <RaisedButton label="Cart" primary={true} style={{ margin: 15 }} onClick={() => { window.location = "/cart" }} icon={icCart} />
          </MuiThemeProvider>
        </div>
      );
    }
  }

  render() {
    return (
      <div className="App">
        <Router>
          <MuiThemeProvider>
            <div>
              <AppBar
                title="Ecommerce 💻🛒"
                position="static"
                showMenuIconButton={false}
              >
                {this._loginButton()}
                <RaisedButton label="" primary={true} style={{ margin: 15, borderRadius: 90, boxShadow: null }} onClick={() => { window.location = "/" }} icon={icHome} />
              </AppBar>
            </div>
          </MuiThemeProvider>
          <Switch>
            <Route exact path="/" component={this.home} />
            <Route path="/login" component={this.login} />
            <Route exact path="/register" component={this.register} />
            <Route path="/payment" component={this.payment} />
            <Route component={this.notFound} />
          </Switch>

          Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon"> www.flaticon.com</a>
        </Router>
      </div>
    );
  }
}


export default App;

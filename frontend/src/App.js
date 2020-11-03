import React from 'react';
import './App.css';
import UserComponent from './components/UserComponent'
import Login from './components/Login'
import NotFound from './components/NotFound';
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

class App extends React.Component {

  home = () => <UserComponent />

  login = () => <Login />
  register = () => <UserComponent />
  notFound = ({ location }) => <NotFound />

  render() {
    return (
      <div className="App">
        <Router>
          <Switch>
            <Route exact path="/" component={this.home} />
            <Route path="/login" component={this.login} />
            <Route exact path="/register" component={this.register} />
            <Route path="/payment" component={this.payment} />
            <Route component={this.notFound} />
          </Switch>
        </Router>
      </div>
    );
  }
}


export default App;

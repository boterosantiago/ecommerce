import React from 'react';
import UserService from '../services/UserService';

class UserComponent extends React.Component
{
    constructor(props)
    {
        super(props)
        this.state = {
            users:[]
        }
    }

    componentDidMount()
    {
        UserService.getUsers().then((response) => {
            this.setState({
                users: response.data
            })
        });
    }

    render ()
    {
        return (
            <div>
                <h1 className = "text-center">Users List: </h1>
                <table className = "table table-striped">
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>User</td>
                            <td>Password</td>
                            <td>email</td>
                            <td>isAdmin</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.users.map(
                                user =>
                                <tr key = {user.id}>
                                    <td>{user.id}</td>
                                    <td>{user.user}</td>
                                    <td>{user.password}</td>
                                    <td>{user.email}</td>
                                    <td>{user.isAdmin}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        );
    }
}

export default UserComponent;
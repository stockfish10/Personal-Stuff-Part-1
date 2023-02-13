import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom';
import axios from 'axios';

export default function Home() {

    const [users, setUsers] = useState([]);

    const {id} = useParams();
    
    useEffect(() => {
        loadUsers();
    }, [])

    const loadUsers = async () => {
        await fetch("http://localhost:8080/users")
            .then(res => res.json())
            .then((result) => {
                setUsers(result)
            })
    };

    const deleteUser = async (id) => {
        await axios.delete(`http://localhost:8080/user/${id}`);
        loadUsers();
    }

    return (
        <div className="container">
            <div className="py-4">
                <table className="table border shadow">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Username</th>
                            <th scope="col">Email</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            
                            users.map((user) => {
                                return <tr>
                                    <th scope="row" key={user.id}>{user.id}</th>
                                    <td>{user.name}</td>
                                    <td>{user.username}</td>
                                    <td>{user.email}</td>
                                    <td>
                                        <button className="btn btn-primary mx-2">View</button>
                                        <Link className="btn btn-outline-primary mx-2" 
                                        to={`/edituser/${user.id}`}
                                        >Edit</Link>
                                        <button className="btn btn-danger mx-2" 
                                        onClick={()=>deleteUser(user.id)}
                                        >Delete</button>
                                    </td>
                                </tr>
                            })
                        }

                    </tbody>
                </table>
            </div>
        </div>
    )
}

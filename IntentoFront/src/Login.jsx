import React, { useState } from 'react';

export function Login() {
    const [nombre, setNombre] = useState('');
    const [mensaje, setMensaje] = useState('');

    async function userExist(nombre) {
        try {
            const response = await fetch(`http://localhost:8080/api/users/exists/${nombre}`);
            if (!response.ok) {
                throw new Error('Error al obtener la respuesta del servidor');
            }
            return await response.text(); // Devolver la respuesta como texto
        } catch (error) {
            console.error('Error:', error);
            throw error; // Propaga el error para que pueda ser manejado en el lugar donde se llama a userExist()
        }
    }

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const existeUsuario = await userExist(nombre);
            // Aquí comparas la respuesta directamente
            if (existeUsuario === 'El usuario existe') {
                setMensaje('El usuario existe');
            } else {
                setMensaje('El usuario no existe');
            }
        } catch (error) {
            setMensaje('Error al verificar la existencia del usuario');
        }
    };

    return (
        <div className="login-container">
            <h2>Iniciar Sesión</h2>
            <form onSubmit={handleSubmit}>
                <input
                    id="inputName"
                    type="text"
                    value={nombre}
                    placeholder="Nombre de usuario"
                    onChange={(e) => setNombre(e.target.value)}
                    required
                />
                <input
                    id="inputPassword"
                    type="password"
                    name="contraseña"
                    placeholder="Contraseña"
                    required
                />
                <input id="inputSubmit" type="submit" value="Iniciar Sesión" />
            </form>
            {mensaje && <p>{mensaje}</p>}
        </div>
    );
}

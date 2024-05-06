import React, { useState } from 'react';
import './Login.css';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await fetch('http://localhost:8080/api/users/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ email, password }),
      });

      if (response.ok) {
        console.log('Inicio de sesión exitoso');

        sessionStorage.setItem('email',email)
        navigate('/myClasses');

      } else {
        throw new Error('Inicio de sesión fallido');
      }
    } catch (error) {
      console.error('Error al iniciar sesión:', error.message);
    }
  };

  return (
    <div className="login-container">
      <div className="login-content">
        <h2>Iniciar sesión</h2>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label htmlFor="email">Correo electrónico:</label>
            <input
              type="email"
              id="email"
              value={email}
              onChange={handleEmailChange}
              placeholder="Introduce tu correo electrónico"
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="password">Contraseña:</label>
            <input
              type="password"
              id="password"
              value={password}
              onChange={handlePasswordChange}
              placeholder="Introduce tu contraseña"
              required
            />
          </div>
          <button type="submit" className="btn-submit">Iniciar sesión</button>
        </form>
      </div>
    </div>
  );
};

export default Login;

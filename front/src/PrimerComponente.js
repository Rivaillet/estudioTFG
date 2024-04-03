import React, { useState, useEffect } from 'react';

function PrimerComponente() {
  // Estado para almacenar los datos obtenidos de la solicitud GET
  const [userData, setUserData] = useState(null);
  // Estado para indicar si la solicitud está en progreso
  const [loading, setLoading] = useState(true);
  // Estado para manejar errores
  const [error, setError] = useState(null);

  useEffect(() => {
    // Función para realizar la solicitud GET
    const fetchData = async () => {
      try {
        // Realiza la solicitud GET
        const response = await fetch('http://localhost:8080/api/users/1');
        
        // Verifica si la solicitud fue exitosa
        if (!response.ok) {
          throw new Error('No se pudo obtener los datos');
        }
        
        // Parsea la respuesta a formato JSON
        const userDataResponse = await response.json();
        
        // Actualiza el estado con los datos obtenidos
        setUserData(userDataResponse);
      } catch (error) {
        // Maneja cualquier error que pueda ocurrir
        setError(error);
      } finally {
        // Indica que la carga ha terminado, independientemente de si tuvo éxito o falló
        setLoading(false);
      }
    };

    // Llama a la función para realizar la solicitud GET
    fetchData();
  }, []); // El segundo argumento asegura que useEffect solo se ejecute una vez, al montar el componente

  // Renderiza los resultados
  return (
    <div>
      {loading ? (
        <p>Cargando...</p>
      ) : error ? (
        <p>Error: {error.message}</p>
      ) : (
        <div>
          <h1>Datos del usuario:</h1>
          <p>Nombre completo: {userData.firstName} {userData.lastName}</p>
          <p>Email : {userData.email}</p>
          <p>ID: {userData.id}</p>
        </div>
      )}
    </div>
  );
}

export default PrimerComponente;


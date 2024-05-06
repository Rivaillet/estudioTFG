import React, { useState, useEffect } from 'react';
import './ClassroomList.css'
import ClassroomCard from './ClassroomCard';

const ClassroomList = () => {
    const [classrooms, setClassrooms] = useState([]);

    useEffect(() => {
        fetchData(); // Llama a la función fetchData al montar el componente
    }, []); // El segundo argumento [] indica que solo se ejecuta una vez al montar el componente

    const fetchData = async () => {
        try {
            const response = await fetch('http://localhost:8080/api/classrooms/allClasses');
            if (!response.ok) {
                throw new Error('Error al obtener las aulas');
            }
            const data = await response.json();
            setClassrooms(data); // Establece las aulas recibidas en el estado
        } catch (error) {
            console.error('Error al obtener las aulas:', error);
        }
    };

    // Función para dividir las aulas en filas de 3
    const divideIntoRows = (array, chunkSize) => {
        const rows = [];
        for (let i = 0; i < array.length; i += chunkSize) {
            rows.push(array.slice(i, i + chunkSize));
        }
        return rows;
    };

    // Divide las aulas en filas de 3
    const rowsOfClassrooms = divideIntoRows(classrooms, 3);

    return (
        <div className="classroomList-container">
            <h2>Lista de Aulas</h2>   
            {rowsOfClassrooms.map((row, index) => (
                <div key={index} className="classroomList-row">
                    {row.map(classroom => (
                        <div key={classroom.idClassroom} className="classroomList-col">
                            <ClassroomCard classroomTitle={classroom.classroomName} 
                                            idClassroom={classroom.idClassroom}/>
                        </div>
                    ))}
                </div>
            ))}
        </div>
    );
}

export default ClassroomList;

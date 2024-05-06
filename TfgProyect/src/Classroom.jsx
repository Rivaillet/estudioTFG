/* eslint-disable react/prop-types */
import './Classroom.css'
import { useParams } from 'react-router-dom'
import React, { useState, useEffect } from 'react';
import SubjectCard from './SubjectCard';

export function Classroom() {

    const {idClassroom} = useParams()
    const [subjects, setSubjects] = useState([])

    useEffect(() => {
        fetchData(); // Llama a la función fetchData al montar el componente
    }, []); // El segundo argumento [] indica que solo se ejecuta una vez al montar el componente

    const fetchData = async () => {
        try {
            console.log(idClassroom)
            const response = await fetch(`http://localhost:8080/api/subjects/${idClassroom}`);
            if (!response.ok) {
                throw new Error('Error al obtener las aulas');
            }
            const data = await response.json();
            setSubjects(data); // Establece las aulas recibidas en el estado
        } catch (error) {
            console.error('Error al obtener las aulas:', error);
        }
    };

    return (
        <div className="classroom-container">
            <h2>TEMARIO</h2>
            <div className="classroom-list-container">
                <div className="classroom-subjects-list">
                    {subjects.map(subject => (
                        <SubjectCard
                            key={subject.idSubject}
                            number={subject.number}
                            title={subject.title}
                            description={subject.description}
                        />
                    ))}
                </div>
            </div>
        </div>
    );
}

export default Classroom
import React from 'react';
import './ClassroomCard.css'; // Importa tu archivo CSS para estilizar el componente
import { Navigate, useNavigate } from 'react-router-dom';


const ClassroomCard = ({ classroomTitle = 'AULA 22222', professorName = 'JOSE' , idClassroom = 3 }) => {
    
    const navigate = useNavigate();
    const accesClassroom = (e) => {
    navigate(`/classroom/${idClassroom}`)
  };
    
    return (
<div className="classroomCard-card">
  <p className="classroomCard-heading">
    {classroomTitle}
  </p>
  <p>
    {'PROFESOR : '}
  </p>
  <p>{professorName}</p>
  <button onClick={accesClassroom}>Acceder</button>


  </div>

    );
}



export default ClassroomCard;
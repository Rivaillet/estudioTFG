/* eslint-disable react/prop-types */
import { useState } from "react"
import './SubjectCard.css'
export function SubjectCard({ number = 33 , title = 'SUBJECT' , description = 'lorem ipsun'}) {


    return (
        
        <div className="subject-card">
    <div className="subject-img-container">
        <div className="subject-img">
            <h1>TEMA {number}</h1>
            <p>{description}</p>
        </div>
        <div className="subject-description subject-card">
            <span className="subject-title">
                {title}
            </span>
        </div>
    </div>
</div>
    )
}

export default SubjectCard
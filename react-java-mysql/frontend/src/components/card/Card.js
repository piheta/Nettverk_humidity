import React from 'react';
import "./Card.css";



function Card({name, precentage, latin}) {
    return (
    <div className="card">
        <div className="plant-precentage">
            <h2>{"34"}</h2>
        </div>
        <div className="card-info">
            <h2>Plant: {name}</h2>
            <h2>Humidity: {precentage}</h2>
            <div className="latin-plant">
            <h2>{latin}</h2>
            </div>
        </div>
        
    </div>
    );
}

export default Card;
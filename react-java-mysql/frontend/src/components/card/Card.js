import React from 'react';
import "./Card.css";


const plant = {
    name: "Rose",
    precentage: "50%",
    last_watered: "10:00",
    latin: "Rosa"
};

function Card() {
    return (
    <div className="card">
        <div className="plant-precentage">
            <h2>{plant.precentage}</h2>
        </div>
        <div className="card-info">
            <h2>Plant: {plant.name}</h2>
            <h2>Humidity: {plant.precentage}</h2>
            <h2>Last watered: {plant.last_watered}</h2>
            <div className="latin-plant">
            <h2>{plant.latin}</h2>
            </div>
        </div>
        
    </div>
    );
}

export default Card;
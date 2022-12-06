import React, { useEffect, useState } from 'react';
import { getLastHumidity } from '../../services/PlantService';
import "./Card.css";


function Card({plant}) {

    const [humidity, setHumidity] = useState([]);

    useEffect(() => {
        setInterval(() => {
            getLastHumidity(plant.plantId).then((humidityData) => {
                setHumidity(humidityData);
            })
        },3000);
        
    }, [plant.plantId])
    return (
    <div className="card">
        <div className="plant-precentage">
            <h2>{humidity.humidity+"%"}</h2>
        </div>
        <div className="card-info">
            <h2>Plant: {plant.plantName}</h2>
            <h2>Humidity: {humidity.humidity+"%"}</h2>
            <div className="latin-plant">
            <h2>{plant.plantLatinName}</h2>
            </div>
        </div>
        
    </div>
    );
}

export default Card;
import React, { useEffect, useState } from 'react';
import Card from './Card';
import './CardList.css';
import {getAllPlants} from '../../services/PlantService'

function CardList() {
    
    const [plants, setPlants] = useState([]);


    useEffect(() => {
        getAllPlants().then((plantData) => {
            setPlants(plantData);
        })
    }, [])
    
    return ( 
    <div className="cardlist">
        {
            
            plants.map((plant) => {
                return <Card plant={plant}/>;
                
            })
        }
    </div> 
    );
}

export default CardList;
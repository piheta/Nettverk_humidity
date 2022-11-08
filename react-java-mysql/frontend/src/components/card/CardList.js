import React from 'react';
import Card from './Card';
import './CardList.css';

function cardList() {
    return ( 
    <div className="cardlist">
        <Card/>
        <Card/>
        <Card/>
    </div> 
    );
}

export default cardList;
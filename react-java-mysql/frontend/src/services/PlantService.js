import axios from "axios";

const API_BASE_URL = process.env.API_BASE_URL;

export function getAllPlants(){
    return axios({
        method: 'GET',
        url: "http://localhost:8080" + '/plants',
        headers: {
            'Accept': '*/*',
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin" : "*"
        },
    }).then((response) => {
        console.log(response);
        if (response.status === 200) {
            return response.data;
        }else{
            console.log(response.status);
        }
    })
};
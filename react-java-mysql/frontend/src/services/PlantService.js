
export function getLastHumidity(plantID) {

    return fetch("http://10.212.25.196:8080/humidity/" + plantID,{
        method: "GET",
        headers:{
            'Accept': '*/*',
             "Content-Type": "application/json"
        }
    })
    .then((response) =>{
        if (response.status === 200) {
            let responseData = response.json();
            return responseData;
        }else{
            console.log(response.status);
        }
    })
};

export function getAllPlants(){

    return fetch("http://10.212.25.196:8080/plants",{
        method: "GET",
        headers:{
            'Accept': '*/*',
             "Content-Type": "application/json"
        }
    })
    .then((response) =>{
        let responseData = response.json();

        if (response.status === 200) {
            return responseData;
        }else{
            console.log(response.status);
        }
    })
};

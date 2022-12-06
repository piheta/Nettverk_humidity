
export function getAllPlants(){

    return fetch("http://10.212.25.196:8080/plants",{
        method: "GET",
        headers:{
            'Accept': '*/*',
             "Content-Type": "application/json"
        }
    })
    .then((response) =>{
        console.log(response);
        if (response.status === 200) {
            return response.json();
        }else{
            console.log(response.status);
        }
    })
    // return axios({
    //     method: 'GET',
    //     url: "http://localhost:8080/plants",
    //     headers: {
    //         'Accept': '*/*',
    //         "Content-Type": "application/json"
    //     },
    // }).then((response) => {
    //     console.log(response);
    //     if (response.status === 200) {
    //         return response.data;
    //     }else{
    //         console.log(response.status);
    //     }
    // })
};

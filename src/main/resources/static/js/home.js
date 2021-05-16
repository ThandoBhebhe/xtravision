

function setUsersVisitation (firstTimeOrNot){
    let firstTimeOrNotObject = {
        "firstTimeOrNot":firstTimeOrNot
    }
    fetch('http://localhost:8080/suvs',{

        method: 'POST',
        headers:{
            'Accept': 'application/json',
            'Content-Type':'application/json'
        },
        body: JSON.stringify(firstTimeOrNotObject)

    }).then(response =>{
        return response.text()
    }).then(data =>{
        console.log('This the data')
        console.log(data)
        // window.location.href = 'rent'
    })
}


// function setUsersVisitation (firstTimeOrNot){
//     let firstTimeOrNotObject = {
//         "firstTimeOrNot":firstTimeOrNot
//     }
//     fetch('http://localhost:8080/suvs',{
//
//         method: 'POST',
//         headers:{
//             'Accept': 'application/json',
//             'Content-Type':'application/json'
//         },
//         body: JSON.stringify(firstTimeOrNotObject)
//
//     }).then(response =>{
//         return response.text()
//     }).then(data =>{
//         console.log('This the data')
//         console.log(data)
//         // window.location.href = 'rent'
//     })
// }

function thanks(){

    if(document.getElementById('pinInput').value.length  !== 4){
        alert('Please enter a PIN with 4 digits')
    }else{
        alert('Thank you for using Xtra-Vision')
        window.location.href = 'home'
    }


}
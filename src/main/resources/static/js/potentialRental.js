

setPageUp()
function setPageUp(){
    fetch('http://localhost:8080/getprentals')

        .then(response => {
            return response.json()
        }).then(data =>{
            console.log('This is the data '+data)
            console.log(data)

            console.log('This is the image')
            let movieName = data[0].movieName
            let movieImage = data[0].movieCover

            console.log(movieImage)
            console.log(movieName)
            document.getElementById('cover-image').src = movieImage
            document.getElementsByClassName('description-paragraph').innerHTML = movieName
        populateTable(data)

    })
}

function populateTable(arrayOfMovies){
    let table = document.getElementById('movies-table')


    for(i =0;i<arrayOfMovies.length;i++){

        let row = table.insertRow(i)
        row.setAttribute('id',i)
        row.insertCell(0).innerHTML = '<img class="img-in-table" src="'+arrayOfMovies[i].movieCover+'"img>'
        row.insertCell(1).innerHTML= '2.99'
        row.insertCell(2).innerHTML= '<td> <button id="'+arrayOfMovies[i].movieName+'" type="button" class="btn btn-danger " onclick="removeRow()">Remove</button>'
    }
}

function removeRow() {

    let td = event.target.parentNode;
    let tr = td.parentNode; // select the row the td is is

    let movieId = tr.id
    console.log(movieId)

    console.log('This is the ID being used'+movieId)

    potentialMovieObject = {
        movieName: movieId
    }

    fetch('http://localhost:8080/rm-potrbid/'+movieId,{

        method: 'DELETE',
        headers:{
            'Accept': 'application/json',
            'Content-Type':'application/json'
        },
        body: JSON.stringify(potentialMovieObject)

    }).then( function (response){
        console.log('posted to '+JSON.stringify(potentialMovieObject))
        console.log('Post request complete', response)
    })

    tr.parentNode.removeChild(tr);
}




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

    })



}

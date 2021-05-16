clearList();


function clearList(){

    fetch('http://localhost:8080/cpr/',{

        method: 'DELETE',
        headers:{
            'Accept': 'application/json',
            'Content-Type':'application/json'
        }

    }).then(response =>{
        return response.json()
    }).then(data =>{
        console.log(data)
    })
}

getMovies()

//reguest movies from API
function getMovies(){
    let url="https://imdb8.p.rapidapi.com/auto-complete?q=ave";

    fetch(url,{
        "method":"GET",
        "headers": {
            "x-rapidapi-key": "e234bd6ff1msh8dbcc003e8e72f7p1a5721jsn32a79b5977eb",
            "x-rapidapi-host": "imdb8.p.rapidapi.com"
        }
    }).then( (response)=>{

        return response.json()
    }).then((data)=>{
        console.log(data[0])
        moviesArray = []

        for (movieAtIndex=0;movieAtIndex<data.d.length;movieAtIndex++){

            moviesArray.push(data.d[movieAtIndex]) //adding movies that come from the api to my movie moviesArray
        }
        let movie = moviesArray.map((movie)=>{
            // console.log(movie)

            if(typeof movie.i !== 'undefined'){//some movies dont have an image so i check to not include them
                let cover = movie.i.imageUrl
                let title = movie.l
                return `<div class="card-container">
                        <div> <img value onclick="setClickedMovie(this.alt,this.src)" class="img-card" id="${title}" src=${cover} alt="${title}">
                        </div>
                        <div class="card-info">
                            <p class="card-text">${title} </p>
                        </div>
                    </div>`
            }else{
                console.log('Found undefined')
            }
        }).join("")
        document.querySelector('.col').insertAdjacentHTML("afterbegin", movie)

    })
}

//adding onclick listener on the com.xtravision.movie to fill the next page
let clickedMovieName
let clickedMovieImage
function setClickedMovie(movieName, movieImage){


    clickedMovieName = movieName
    clickedMovieImage = movieImage
    console.log(clickedMovieName+movieImage);
    console.log('This is element got by class ')
    console.log(document.getElementById(movieName))

    let myElement = document.getElementById(movieName)
    console.log('this is the element we got '+myElement)

    let elementOpacity = window.getComputedStyle(myElement).getPropertyValue('opacity')
    console.log('this is opacity of element '+elementOpacity)

    potentialMovieObject = {
        movieName: clickedMovieName,
        movieCover:clickedMovieImage
    }

    if(elementOpacity == 1){

//    make a post request to the backend with movie name and cover
        fetch('http://localhost:8080/addprental/',{

            method: 'POST',
            headers:{
                'Accept': 'application/json',
                'Content-Type':'application/json'
            },
            body: JSON.stringify(potentialMovieObject)


        }).then( response =>{

            return response.text()
        }).then(data =>{
            console.log('Tried to add, got this')
            console.log(data)
            if (data != 'success'){
                console.log(data)
                alert(data)
                myElement.style.opacity = 1
            }
        })

        myElement.style.opacity = 0.7
    }else{
        console.log("we are going to delete this")
        console.log(potentialMovieObject.movieName)

        fetch('http://localhost:8080/rm-potrbn/'+potentialMovieObject.movieName,{

            method: 'DELETE',
            headers:{
                'Accept': 'application/json',
                'Content-Type':'application/json'
            },
            body: JSON.stringify(potentialMovieObject.movieName)


        }).then( function (response){
            console.log('posted to '+JSON.stringify(potentialMovieObject))
            console.log('Post request complete', response)
        }).then(data =>{

            console.log('This is the size')
            console.log(data)
        })

        myElement.style.opacity = 1
    }

}

function selectedMovie(){

    fetch('http://localhost:8080/getprs')

        .then(response => {
            return response.json()
        }).then(data =>{

        if(data === 0){
            alert("Please choose a movie to rent")
            window.location.href ='rent'
        }else{
            window.location.href = 'potential-rental'
        }

    })
}

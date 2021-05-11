
getMovies()

//reguest movies from API
function getMovies(){
    let url="https://imdb8.p.rapidapi.com/auto-complete?q=ave";

    fetch(url,{
        "method":"GET",
        "headers": {
            "x-rapidapi-key": "66e6c0fd2bmsha01312a7e1a48a9p154386jsn7c10950223d4",
            "x-rapidapi-host": "imdb8.p.rapidapi.com"
        }
    }).then( (response)=>{

        return response.json()
    }).then((data)=>{
        console.log(data[0])
        moviesArray = []

        for (movieAtIndex=0;movieAtIndex<data.d.length;movieAtIndex++){

            moviesArray.push(data.d[movieAtIndex])
        }
        let movie = moviesArray.map((movie)=>{
            console.log(movie)

            if(typeof movie.i !== 'undefined'){//some movies dont have an image so i check to not include them
                let cover = movie.i.imageUrl
                let title = movie.l
                return `<div class="card-container">
                        <div> <img value onclick="setClickedMovie(this.alt,this.src)" id="img-card" src=${cover} alt="${title}">
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
    clickedMovieName = movieName;
    clickedMovieImage = movieImage
    alert(clickedMovieName+movieImage);


}

function selectedMovie(){
//    make a post request to the backend with movie name and cover
}

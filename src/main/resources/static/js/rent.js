
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

            moviesArray.push(data.d[movieAtIndex]) //adding movies that come from the api to my movie moviesArray
        }
        let movie = moviesArray.map((movie)=>{
            // console.log(movie)

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
    console.log(clickedMovieName+movieImage);


}

function selectedMovie(){
  if(clickedMovieName == null) {
      alert('Please select movie to rent')
      window.location.href ='rent'
  }else{

      potentialMovieObject = {
          movieName: clickedMovieName,
          movieCover:clickedMovieImage
      }

//    make a post request to the backend with movie name and cover
      fetch('http://localhost:8080/addprental',{

          method: 'POST',
          headers:{
              'Accept': 'application/json',
              'Content-Type':'application/json'
          },
          body: JSON.stringify(potentialMovieObject)

      }).then( function (response){
          console.log('posted to '+JSON.stringify(potentialMovieObject))
          console.log('Post request complete', response)
      })
      window.location.href = 'potential-rental'
  }
}

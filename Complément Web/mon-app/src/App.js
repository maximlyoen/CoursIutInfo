import './App.css';
import axios from 'axios';
import { useState } from 'react';
import livre from './livre.png';

function App() {
  const [books, setBooks] = useState([]);
  const [totalItems, setTotalItems] = useState(0);
  const [startIndex, setStartIndex] = useState(0);
  const [query, setQuery] = useState('');
  const itemsPerPage = 9;
  function handleSearch(event) {
    setBooks([]);
    setQuery(event.target.value);
    setTotalItems(0);
    setStartIndex(0);
    if (event.target.value.trim() !== "") {
      let requete =
        `https://www.googleapis.com/books/v1/volumes?q=inauthor:${event.target.value}&startIndex=${startIndex}&maxResults=${itemsPerPage}`;
      axios
        .get(requete)
        .then((response) => {
          setBooks(response.data.items);
          setTotalItems(response.data.totalItems);
        })
        .catch((error) => {
          console.log("Erreur serveur" + error);
        })
    }
  }
  function handlePageChange(newStartIndex) {
    setStartIndex(newStartIndex);
    let requete =
      `https://www.googleapis.com/books/v1/volumes?q=inauthor:${query}&startIndex=${newStartIndex}&maxResults=${itemsPerPage}`;
    axios
      .get(requete)
      .then((response) => {
        setBooks(response.data.items);
      })
      .catch((error) => {
        console.log("Erreur serveur" + error);
      })
  }
  if(totalItems == 0 && query.trim() !== "") {
    return (
      <div>
        <header>  
          <div>
            <h1>Research API Google</h1>
          </div>
          <div>
            <h1>Book title</h1>
            <input type="text" id="author" onChange={handleSearch}/>
          </div>
        </header>
        <div id="result">
          <p>0 book in stock for this research</p>
          {totalItems > itemsPerPage && (
            <footer className="pagination">
              {startIndex > 0 && (
                <button onClick={() => handlePageChange(startIndex - itemsPerPage)}>&lt;&lt; Previus page</button>
              )}
              <p>{`${startIndex + 1}-${Math.min(startIndex + itemsPerPage, totalItems)}/${totalItems}`}</p>
              {startIndex + itemsPerPage < totalItems && (
                <button onClick={() => handlePageChange(startIndex + itemsPerPage)}>Next page &gt;&gt;</button>
              )}
            </footer>
          )}
        </div>
      </div>
    )
  }else{
    return(
      <div>
      <header>
        <div>
          <h1>Research API Google</h1>
        </div>
        <div>
          <h1>Book Title</h1>
          <input type="text" id="author" onChange={handleSearch}/>
        </div>
      </header>
      <div id="result">
        {books.length > 0 ? books.map((book) => (
          <div key={book.id} >
            <a href={`https://books.google.fr/books?id=${book.id}`} > 
              <h2>{book.volumeInfo.title}</h2>
              <p>{book.volumeInfo.authors?.join(', ')}</p>
              <img src={book.volumeInfo.imageLinks?.thumbnail || livre} alt={book.volumeInfo.title}/>
            </a>
          </div>
        )) : (query.trim() !== "" && <p>research</p>)}
        {totalItems > itemsPerPage && (
          <footer className="pagination">
            {startIndex > 0 && (
              <button onClick={() => handlePageChange(startIndex - itemsPerPage)}>&lt;&lt; Previus Page</button>
            )}
            <p>{`${startIndex + 1}-${Math.min(startIndex + itemsPerPage, totalItems)}/${totalItems}`}</p>
            {startIndex + itemsPerPage < totalItems && (
              <button onClick={() => handlePageChange(startIndex + itemsPerPage)}>Next Page &gt;&gt;</button>
            )}
          </footer>
        )}
      </div>
    </div>
    );
  }
}
export default App;
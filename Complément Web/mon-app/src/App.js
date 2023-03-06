import './App.css';
import axios from 'axios';
import { useState } from 'react';

function App() {
  const [books, setBooks] = useState([]);
  const [totalItems, setTotalItems] = useState(0);
  const [startIndex, setStartIndex] = useState(0);
  const [query, setQuery] = useState('');

  const itemsPerPage = 10;
  const currentPage = Math.floor(startIndex / itemsPerPage) + 1;
  const totalPages = Math.ceil(totalItems / itemsPerPage);

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

  const element = (
    <div>
      <header>
        <h1>Titre du livre</h1>
        <input type="text" id="author" onChange={handleSearch}/>
      </header>
      <div id="result">
        {books.length > 0 ? books.map((book) => (
          <div key={book.id}>
            <h2>{book.volumeInfo.title}</h2>
            <p>{book.volumeInfo.authors?.join(', ')}</p>
            <a href={`https://books.google.fr/books?id=${book.id}`}>
              <img src={book.volumeInfo.imageLinks?.thumbnail} alt={book.volumeInfo.title}/>
            </a>
          </div>
        )) : (query.trim() !== "" && <p>Aucun ouvrage correspondant a votre recherche</p>)}
        {totalItems > itemsPerPage && (
          <footer className="pagination">
            {startIndex > 0 && (
              <button onClick={() => handlePageChange(startIndex - itemsPerPage)}>&lt;&lt; Page précédente</button>
            )}
            <p>{`${startIndex + 1}-${Math.min(startIndex + itemsPerPage, totalItems)}/${totalItems}`}</p>
            {startIndex + itemsPerPage < totalItems && (
              <button onClick={() => handlePageChange(startIndex + itemsPerPage)}>Page suivante &gt;&gt;</button>
            )}
          </footer>
        )}
      </div>
    </div>
  );

  return element;
}

export default App;

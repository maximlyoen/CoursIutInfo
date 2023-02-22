import logo from './logo.svg';
import './App.css';

function App() {
  const element = (
    <div>
      <header>
        <h1>Titre du livre</h1>
        <input type="text" id="title"/>
        <button onClick={findBookByTitle}>Rechercher</button>
      </header>
      <div id="result">
        
      </div>
    </div>
  );
  function findBookByTitle(event){
    const title = event.target.value;
    const url = "https://www.googleapis.com/books/v1/volumes?q=inauthor:%22" + title + "%22";
    fetch(url)
    .then(response => response.json())
    .then(data => {
      /*affiche le titre et l'auteur*/
      const result = document.getElementById("result");
      result.innerHTML = "";
      data.items.forEach(item => {
        const title = item.volumeInfo.title;
        const author = item.volumeInfo.authors[0];
        const p = document.createElement("p");
        p.innerHTML = title + " - " + author + " - <a href=\"https://books.google.fr/books?id=" + item.id + "\"><img src=\"" + item.volumeInfo.imageLinks.thumbnail + "\"></a>";
        result.appendChild(p);
      }
      );
    });
  }

  return element;
  
}

export default App;

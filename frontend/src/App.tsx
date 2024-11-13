import './App.css';
import logo from './assets/logoBranco.png'
import Navbar from 'components/Navbar';

const App = () => {
  return (
    <div className="App">
      <img src={logo} alt="Logo" className="logo" />
      <div className="line"></div>
      <h1 className = "title">Desafio Élin Duxus</h1>
      <Navbar/>
    </div>
  );
}

export default App;

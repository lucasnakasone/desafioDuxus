import { useState } from 'react';
import logo from '../../assets/logoBranco.png';
import axios from 'axios';

const Navbar = () => {  

  const [responseData, setResponseData] = useState(null);
  
  const timeDaData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/times-da-data?data=1994-01-01');
      setResponseData(response.data); 
    } catch (error) {
      console.error('Erro na requisição:', error);
    }
  };

  const integranteMaisUsado = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/integrante-mais-usado');
      setResponseData(response.data); 
    } catch (error) {
      console.error('Erro na requisição:', error);
    }
  };
  
  const timeMaisComum = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/time-mais-comum');
      setResponseData(response.data); 
    } catch (error) {
      console.error('Erro na requisição:', error);
    }
  };

  const funcaoMaisComum = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/funcao-mais-comum');
      setResponseData(response.data); 
    } catch (error) {
      console.error('Erro na requisição:', error);
    }
  };

  const franquiaMaisFamosa = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/franquia-mais-famosa');
      setResponseData(response.data); 
    } catch (error) {
      console.error('Erro na requisição:', error);
    }
  };

  const contagemPorFranquia = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/contagem-por-franquia');
      setResponseData(response.data); 
    } catch (error) {
      console.error('Erro na requisição:', error);
    }
  };

  const contagemPorFuncao = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/contagem-por-funcao');
      setResponseData(response.data); 
    } catch (error) {
      console.error('Erro na requisição:', error);
    }
  };

  return (
    <div>
    <nav className="navbar">
      <div className="navbar-logo">
        <img src={logo} className="navbar-logo"/>
      </div>
      <div>
        <button className="navbar-button-style navbar-button-cadastro">Cadastro de times</button>
      </div>
      <div className="navbar-buttons">
        <button className="navbar-button-style" onClick={timeDaData}> Time da data</button>
        <button className="navbar-button-style" onClick={integranteMaisUsado}> Integrante mais usado</button>
        <button className="navbar-button-style" onClick={timeMaisComum}> Time mais comum</button>
        <button className="navbar-button-style" onClick={funcaoMaisComum}> Funcao mais comum</button>
        <button className="navbar-button-style" onClick={franquiaMaisFamosa}> Franquia mais famosa</button>
        <button className="navbar-button-style" onClick={contagemPorFranquia}> Contagem por franquia</button>
        <button className="navbar-button-style" onClick={contagemPorFuncao}> Contagem por função
        </button>
      </div>
     </nav>
    
    {responseData && (
      <div 
        style={{
          marginTop: '20px',
          textAlign: 'left',
          whiteSpace: 'pre-wrap',
          color: 'whitesmoke'
        }}>
        <h4>JSON Response:</h4>
        <pre>{JSON.stringify(responseData, null, 2)}</pre>
      </div>
    )}
    
    </div>
  );
}

export default Navbar;
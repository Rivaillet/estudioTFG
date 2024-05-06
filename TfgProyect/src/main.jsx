import ReactDOM from 'react-dom/client';
import { BrowserRouter } from 'react-router-dom'; // Importa BrowserRouter
import App from './App.jsx'; // Importa el componente principal de la aplicación

ReactDOM.createRoot(document.getElementById('root')).render(
  
    <BrowserRouter> {/* Envuelve tu aplicación con BrowserRouter */}
    <App />
  </BrowserRouter>
    
    
    
)

/*
    ES ALGO MJUY IMPORTANTO DE REACT 
    HACE QUE LOS COMPONENTES COBREN VIDA 

    
    Necesitamos que los cambios respondan al usuario

    RENDERIZADO CONDICIONAL
    const text = isFollowing ? 'Siguiendo' : 'Seguir'  (Si is following es true el texto es siguiendo , sino Seguir)
    const buttonClassName = isFollowing ? 'tw-followcard-button is following' 
    : 'tw-follow-card-button'

    Y AL ELEMENTO BOTON LE PASAMOS

    <button className={buttonClassName}>

    */
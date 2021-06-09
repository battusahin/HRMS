
import './App.css';
import Navi from './layouts/Navi'
import Footer from './layouts/Footer'
import 'semantic-ui-css/semantic.min.css'
import { Container } from "semantic-ui-react";

function App() {
  return (
    <div className="App">
      <Navi/>
      <Container className="main">

      </Container>
      <Footer/>
    </div>
  );
}

export default App;
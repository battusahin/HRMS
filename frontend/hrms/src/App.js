import "./App.css";
import Navi from "./layouts/Navi";
import Footer from "./layouts/Footer";
import "semantic-ui-css/semantic.min.css";
import { Container } from "semantic-ui-react";
import Dashboard from './layouts/Dashboard';


function App() {
  return (
    <div className="App">
      <Navi />
      <Container className="main">
        <Dashboard/>
      </Container>
      <Footer className="footer"/>
    </div>
  );
}

export default App;

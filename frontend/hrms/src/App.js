import "./App.css";
import Navi from "./layouts/Navi";
import Footer from "./layouts/Footer";
import "semantic-ui-css/semantic.min.css";
import { Container } from "semantic-ui-react";
import { Switch, Route } from "react-router-dom";
import Dashboard from './layouts/Dashboard';
import { routes } from './Routing';

function App() {
  return (
    <div className="App">
      <Navi />
      <Container className="main">
        <Switch>
          {routes.map((route) => (
            <Route exact={route.exact} path={route.path} key={route.title}>    
              <Dashboard> {route.component} </Dashboard>
            </Route>
          ))}
        </Switch>
      </Container>
      <Footer className="footer--pin"/>
    </div>
  );
}

export default App;

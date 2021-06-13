import Sidebar from "./Sidebar";
import {
   Row,
   Col
  } from "react-bootstrap";

export default function Dashboard({ children }) {
  return (
    <div>
      
        <Row>
          <Col sm={3}><Sidebar/></Col>
          <Col sm={9}>asdsad</Col>
        </Row>
      
    </div>
  );
}

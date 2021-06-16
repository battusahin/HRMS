import React, { useState, useEffect } from "react";
import { Form, Card, FormControl, ListGroup } from "react-bootstrap";
import CityService from "../services/cityService";
import JobPositionService from "../services/jobPositionService";

export default function SideBar() {
  const [cities, setCities] = useState([]);
  const [jobPositions, setJobPositions] = useState([]);

  useEffect(() => {
    let cityService = new CityService();
    cityService.getCities().then((result) => setCities(result.data.data));
  }, []);

  useEffect(() => {
    let jobPositionService = new JobPositionService();
    jobPositionService
      .getJobPositions()
      .then((result) => setJobPositions(result.data.data));
  }, []);

  return (
    <div>
      <ListGroup>
        <ListGroup.Item action variant="success">
          İş İlanları
        </ListGroup.Item>
        <ListGroup.Item action variant="success">
          İş Verenler
        </ListGroup.Item>
        <ListGroup.Item action variant="success">
          Kullanıcılar
        </ListGroup.Item>
        <ListGroup.Item action variant="success">
          Cvler
        </ListGroup.Item>
      </ListGroup>
    </div>
  );
}

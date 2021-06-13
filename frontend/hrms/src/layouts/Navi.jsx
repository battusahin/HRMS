import React, { useState } from "react";

import {
  Navbar,
  Container,
  Nav,
  Form,
  Button,
  Jumbotron,
  FormControl
} from "react-bootstrap";

export default function Navi() {
  return (
    <div>
      <Navbar bg="light" expand="md">
        <Container>
          <Navbar.Brand href="#" style={{ fontSize: "30px" }}>
            H R M S
          </Navbar.Brand>
          <Navbar.Toggle aria-controls="navbarScroll" />
          <Navbar.Collapse id="navbarScroll">
            <Nav
              className="ml-auto my-2 my-lg-4 mr-5"
              style={{ maxHeight: "100px" }}
              navbarScroll
            >
              <Nav.Link href="#action1" className="h4 mr-4">
                Home
              </Nav.Link>
              <Nav.Link href="#action1" className="h4 mr-4">
                Resumes
              </Nav.Link>
              <Nav.Link href="#action1" className="h4 mr-4">
                JobPostings
              </Nav.Link>
              <Nav.Link href="#action1" className="h4 mr-4">
                Candidates
              </Nav.Link>
              <Nav.Link href="#action1" className="h4 mr-4">
                Employers
              </Nav.Link>
            </Nav>
            <Button variant="outline-primary" className="ml-2 mr-3">
              Login
            </Button>
            <Button variant="outline-primary">SignUp</Button>
          </Navbar.Collapse>
        </Container>
      </Navbar>
      <Jumbotron style={{ padding: "12rem" }}>
        <h1 style={{ fontSize: "8rem" }} className="mb-5">WELCOME</h1>
        <p style={{ fontSize: "3rem" }}>
          Human Resources Management System
        </p>

        <Form className="d-inline-flex">
          <FormControl
            type="search"
            placeholder="City"
            className="mr-4 ml-4"
            aria-label="Search"
          />
          <Button variant="outline-success">Search</Button>
        </Form>
      </Jumbotron>
    </div>
  );
}

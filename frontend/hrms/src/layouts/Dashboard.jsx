import Sidebar from "./Sidebar";
import { Row, Col } from "react-bootstrap";
import JobPostings from "../pages/JobPostings";
import Resumes from '../pages/Resumes';
import Employer from '../pages/users/Employer';
import Candidate from '../pages/users/Candidate'
import {Route} from 'react-router'
import ResumeDetail from "../pages/ResumeDetail";
import AddJobPosting from "../pages/AddJobPosting"

export default function Dashboard({ children }) {
  return (
    <div>
      <Row>
        <Col xs={12} md={3}>
          <Sidebar />
        </Col>
        <Col xs={12} md={9}>
          <Route exact path="/" component={JobPostings} />
          <Route exact path="/resumes" component={Resumes} />
          <Route exact path="/jobPostings" component={JobPostings} />
          <Route exact path="/employers" component={Employer} />
          <Route exact path="/candidates" component={Candidate} />
          <Route exact path="/resume/:id" component={ResumeDetail} />
          <Route exact path="/addJobPosting" component={AddJobPosting} />
        </Col>
      </Row>
    </div>
  );
}
